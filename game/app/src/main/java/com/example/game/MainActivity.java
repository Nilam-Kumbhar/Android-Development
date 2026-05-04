package com.example.game;

import android.os.Bundle;
import com.google.androidgamesdk.GameActivity;

public class MainActivity extends GameActivity {

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
