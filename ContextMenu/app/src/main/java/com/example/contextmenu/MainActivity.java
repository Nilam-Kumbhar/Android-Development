package com.example.contextmenu;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    TextView textView;
    RelativeLayout r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        r = (RelativeLayout) findViewById(R.id.rel);
// here you have to register a view for context menu you can register any view
// like listview, image view, textview, button etc
        registerForContextMenu(textView);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
// you can set menu header with title icon etc
        menu.setHeaderTitle("Choose a color");
// add menu items
        menu.add(0, v.getId(), 0, "Yellow");
        menu.add(0, v.getId(), 0, "Gray");
        menu.add(0, v.getId(), 0, "Cyan");
    }
    // menu item select listener
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Yellow") {
            r.setBackgroundColor(Color.YELLOW);
        } else if (item.getTitle() == "Gray") {
            r.setBackgroundColor(Color.GRAY);
        } else if (item.getTitle() == "Cyan") {
            r.setBackgroundColor(Color.CYAN);
        }
        return true;
    }
}
