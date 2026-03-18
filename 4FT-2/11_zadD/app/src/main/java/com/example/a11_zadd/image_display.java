package com.example.a11_zadd;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class image_display extends AppCompatActivity {
    ImageView img;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image_display);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        img = findViewById(R.id.imgView);
        txt = findViewById(R.id.text);
        if(getIntent().getBooleanExtra("loggedIn", false)){
            img.setImageResource(getIntent().getIntExtra("imageID", 0));
            txt.setText(getIntent().getCharSequenceExtra("txt"));
            txt.setTextSize(24);
            txt.setTextColor(getColor(R.color.black));
        }
        else {
            txt.setText("Zaloguj się aby wyświetlić obraz!");
            txt.setTextSize(32);
            txt.setTextColor(getColor(R.color.red));
        }
    }
}