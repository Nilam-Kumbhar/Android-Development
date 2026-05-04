package com.example.optionmenu;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout currentLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentLayout =(RelativeLayout) findViewById(R.id.a);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.android) {
            currentLayout.setBackgroundColor(Color.RED);
            return true;

        } else if (id == R.id.java) {
            currentLayout.setBackgroundColor(Color.GREEN);
            return true;

        } else if (id == R.id.kotlin) {
            currentLayout.setBackgroundColor(Color.BLUE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}