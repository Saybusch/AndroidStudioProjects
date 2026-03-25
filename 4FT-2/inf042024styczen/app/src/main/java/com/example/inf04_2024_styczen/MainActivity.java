package com.example.inf04_2024_styczen;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button throwDice, resetGame;
    TextView scoreNow, scoreGlobal;
    int globalSuma = 0;
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
        Random random = new Random();
        int[] images = {R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5};
        int[] resources = {R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6};
        ArrayList<Integer> values = new ArrayList<>();
        throwDice = findViewById(R.id.throwDice);
        resetGame = findViewById(R.id.resetGame);
        scoreNow = findViewById(R.id.scoreNow);
        scoreGlobal = findViewById(R.id.scoreGlobal);
        throwDice.setOnClickListener(v -> {
            int suma = 0;
            values.clear();
            for(int i = 0; i < 5; i++) {
                values.add(random.nextInt(6)+1);
                ImageView img = findViewById(images[i]);
                img.setImageResource(resources[values.get(i)]);
            }
            for(int i = 1; i <= 6; i++) {
                int total = 0;
                for( int liczba : values ){
                    if(liczba == i) total++;
                }
                if (total > 1) suma += total * i;
            }
            scoreNow.setText("Wynik tego losowania: " + suma);
            globalSuma += suma;
        });
    }
}