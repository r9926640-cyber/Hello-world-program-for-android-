package com.example.helloworld;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends Activity {
    // Load the C++ library when the app starts
    static {
        System.loadLibrary("helloworld");
    }

    // Declare the C++ function
    public native String stringFromJNI();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        // Call the C++ function to set the text
        tv.setText(stringFromJNI());
        tv.setTextSize(24f);
        tv.setGravity(Gravity.CENTER);
        setContentView(tv);
    }
}
