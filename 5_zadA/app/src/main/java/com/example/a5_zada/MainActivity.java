package com.example.a5_zada;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn1.setOnClickListener(v -> losuj());
        btn2.setOnClickListener(v -> losuj2());
    }
    public void losuj(){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 1; i < 43; i++) lista.add(i);
        Collections.shuffle(lista);
        ArrayList<Integer> los = new ArrayList<>();
        for(int i = 0; i < 5; i++) los.add(lista.get(i));

        StringBuilder string = new StringBuilder();
        for(int i:los){
            string.append(i);
            string.append(" ");
        }
        txt.setText(string);
    }
    public void losuj2(){
        HashSet<Integer> unique = new HashSet<>();
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        while(unique.size() < 5){
            int los = random.nextInt(42)+1;
            unique.add(los);
        }
        for(int i:unique){
            text.append(i + " ");
        }
        txt.setText(text);
    }
}