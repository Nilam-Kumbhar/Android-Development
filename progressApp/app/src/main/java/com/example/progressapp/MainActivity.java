package com.example.progressapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button b, b1;
    ProgressBar p;
    Handler handler = new Handler();
    int progressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.button);
        b1 = findViewById(R.id.button1);
        p = findViewById(R.id.progressBar);

        p.setVisibility(View.GONE);

        // Button 1 → Show normal ProgressBar
        b.setOnClickListener(v -> p.setVisibility(View.VISIBLE));

        // Button 2 → Show Horizontal ProgressDialog (No try-catch)
        b1.setOnClickListener(v -> {

            ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setCancelable(true);
            progressDialog.setMessage("File downloading...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setProgress(0);
            progressDialog.setMax(100);
            progressDialog.show();

            progressStatus = 0;

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressStatus += 10;
                    progressDialog.setProgress(progressStatus);

                    if (progressStatus < 100) {
                        handler.postDelayed(this, 500);
                    } else {
                        progressDialog.dismiss();
                    }
                }
            }, 500);
        });
    }
}