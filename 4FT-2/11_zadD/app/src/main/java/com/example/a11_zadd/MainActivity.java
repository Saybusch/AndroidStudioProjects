package com.example.a11_zadd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button login;
    boolean isLoggedIn = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.login);
        login.setOnClickListener(v -> {
            if(isLoggedIn) {
                Toast.makeText(this, "Wylogowano", Toast.LENGTH_SHORT).show();
                isLoggedIn = false;
            }
            else {
                Toast.makeText(this, "Zalogowano", Toast.LENGTH_SHORT).show();
                isLoggedIn = true;
            }
        });
        int[] ids = {R.id.img1, R.id.img2};
        int[] imageIds = {R.drawable.starry_night, R.drawable.the_kiss};
        String[] text = {"Starry Night", "The Kiss"};
        for(int i = 0; i < ids.length; i++){
            int var  = i;
            Button btn = findViewById(ids[var]);
            btn.setOnClickListener(v -> {
                Intent intent = new Intent(this, image_display.class);
                intent.putExtra("imageID", imageIds[var]);
                intent.putExtra("loggedIn", isLoggedIn);
                intent.putExtra("txt", text[var]);
                startActivity(intent);
            });
        }
    }
}