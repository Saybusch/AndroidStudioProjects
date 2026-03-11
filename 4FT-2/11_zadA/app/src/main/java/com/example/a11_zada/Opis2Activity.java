package com.example.a11_zada;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Opis2Activity extends AppCompatActivity {

    ImageView img;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_opis2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        img = findViewById(R.id.img);
        txt = findViewById(R.id.txt);
        img.setImageResource(R.drawable.salvador_dali);
        txt.setText("Salvador Domingo Felipe Jacinto Dalí i Domènech - hiszpański malarz, grafik, rzeźbiarz, pisarz i teoretyk sztuki, jeden z najbardziej " +
                "znanych surrealistów[2].\n" +
                "\n" +
                "Jest jednym z bardziej rozpoznawalnych artystów XX wieku. Postrzegany bywał jako skrajny ekscentryk, " +
                "wymyślił własną metodę surrealistyczną zwaną „paranoiczno-krytyczną”");
    }
}