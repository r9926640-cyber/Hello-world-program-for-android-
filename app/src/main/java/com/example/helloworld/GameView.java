package com.example.helloworld;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import java.util.Random;

public class GameView extends View {
    // Load the C++ NDK library
    static { System.loadLibrary("helloworld"); }
    public native String getGameTitle();

    private Paint paint;
    private int score = 0;
    private float targetX = -1, targetY = -1;
    private float radius = 150f;
    private Random random = new Random();

    public GameView(Context context) {
        super(context);
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Draw dark background
        canvas.drawColor(Color.parseColor("#121212"));

        // Initialize target at the center of the screen on first frame
        if (targetX == -1) {
            targetX = getWidth() / 2f;
            targetY = getHeight() / 2f;
        }

        // Draw the title (fetched from C++) and the Score
        paint.setColor(Color.WHITE);
        paint.setTextSize(80f);
        canvas.drawText(getGameTitle(), 50, 120, paint);
        
        paint.setColor(Color.parseColor("#00E676")); // Neon Green
        paint.setTextSize(100f);
        canvas.drawText("Score: " + score, 50, 250, paint);

        // Draw the Target
        paint.setColor(Color.parseColor("#FF4081")); // Neon Pink
        canvas.drawCircle(targetX, targetY, radius, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // Calculate distance between the touch and the target center
            float dx = event.getX() - targetX;
            float dy = event.getY() - targetY;
            double distance = Math.sqrt(dx * dx + dy * dy);

            // If the tap was inside the circle
            if (distance <= radius) {
                score++;
                // Move target to a random location within screen bounds
                targetX = radius + random.nextInt(getWidth() - (int)(radius * 2));
                targetY = radius + random.nextInt(getHeight() - (int)(radius * 2));
                
                // Shrink the target slightly to make it harder (min 50px)
                if (radius > 50f) radius -= 5f;
                
                // Force the screen to redraw immediately
                invalidate(); 
            }
        }
        return true;
    }
}
