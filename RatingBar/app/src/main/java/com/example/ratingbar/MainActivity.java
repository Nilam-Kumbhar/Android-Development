package com.example.ratingbar;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.RatingBar;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    RatingBar r;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r=(RatingBar)findViewById(R.id.ratingBar);
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                String rating=String.valueOf(r.getRating());
                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show(); }   });
    }
}