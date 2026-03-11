package com.example.a11_zada;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button vvg_btn, sd_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        vvg_btn = findViewById(R.id.vvg_btn);
        sd_btn = findViewById(R.id.sd_btn);
        vvg_btn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), OpisActivity.class);
            startActivity(intent);
        });
        sd_btn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Opis2Activity.class);
            startActivity(intent);
        });
    }
}