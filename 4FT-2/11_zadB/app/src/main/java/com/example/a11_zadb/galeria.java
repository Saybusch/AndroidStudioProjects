package com.example.a11_zadb;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class galeria extends AppCompatActivity {
    ImageView img;
    TextView txt;
    Button rtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_galeria);
        img = findViewById(R.id.img);
        txt = findViewById(R.id.txt);
        rtn = findViewById(R.id.rtn);
        img.setImageDrawable(getDrawable(getIntent().getIntExtra("src", 0)));
        txt.setText(getIntent().getStringExtra("text"));
        rtn.setOnClickListener(v -> {
            startActivity(super.getParentActivityIntent());
        });
    }
}