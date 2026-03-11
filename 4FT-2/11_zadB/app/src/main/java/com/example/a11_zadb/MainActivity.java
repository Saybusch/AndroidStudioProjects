package com.example.a11_zadb;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button req1, req2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        req1 = findViewById(R.id.req1);
        req2 = findViewById(R.id.req2);
        req1.setOnClickListener(v -> {
            Intent intent = new Intent(this, galeria.class);
            intent.putExtra("text", getText(R.string.req1));
            intent.putExtra("src", R.drawable.krzyk);
            startActivity(intent);
        });
        req2.setOnClickListener(v -> {
            Intent intent = new Intent(this, galeria.class);
            intent.putExtra("text", getText(R.string.req2));
            intent.putExtra("src", R.drawable.noc);
            startActivity(intent);
        });
    }
}