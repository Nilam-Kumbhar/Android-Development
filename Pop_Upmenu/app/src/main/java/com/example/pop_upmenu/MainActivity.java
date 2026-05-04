package com.example.pop_upmenu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.clickBtn);

        // Setting onClick behavior to the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initializing popup menu
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);

                // Inflate popup menu
                popupMenu.getMenuInflater().inflate(R.menu.popupmenu, popupMenu.getMenu());

                // Item click listener
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        Toast.makeText(MainActivity.this,
                                "You Clicked " + menuItem.getTitle(),
                                Toast.LENGTH_SHORT).show();

                        return true;
                    }
                });

                popupMenu.show();
            }
        });
    }
}