package com.example.helloworld;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Launch the custom game loop instead of a standard layout
        setContentView(new GameView(this));
    }
}
