package com.example.socialmediaapps;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnWhatsapp = findViewById(R.id.btnWhatsapp);
        Button btnInstagram = findViewById(R.id.btnInstagram);
        Button btnFacebook = findViewById(R.id.btnFacebook);
        Button btnTelegram = findViewById(R.id.btnTelegram);

        btnWhatsapp.setOnClickListener(v -> openApp("com.whatsapp"));
        btnInstagram.setOnClickListener(v -> openApp("com.instagram.android"));
        btnFacebook.setOnClickListener(v -> openApp("com.facebook.katana"));
        btnTelegram.setOnClickListener(v -> openApp("org.telegram.messenger"));
    }

    private void openApp(String packageName) {

        PackageManager packageManager = getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(packageName);

        if (intent != null) {
            // App installed → Open app
            startActivity(intent);
        } else {
            // App not installed → Open Play Store
            Intent playStoreIntent = new Intent(Intent.ACTION_VIEW);
            playStoreIntent.setData(Uri.parse(
                    "https://play.google.com/store/apps/details?id=" + packageName));
            startActivity(playStoreIntent);

            Toast.makeText(this, "App not installed", Toast.LENGTH_SHORT).show();
        }
    }
}
