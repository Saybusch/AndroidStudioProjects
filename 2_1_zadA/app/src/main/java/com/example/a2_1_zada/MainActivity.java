package com.example.a2_1_zada;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView text;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);
        btn = findViewById(R.id.button);

        text.setText(new Date().toString());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTime();
                if (counter > 0) Toast.makeText(MainActivity.this, "aktualizacja daty i godziny", Toast.LENGTH_SHORT).show();
                else Toast.makeText(MainActivity.this, counter + "aktualizacja daty i godziny", Toast.LENGTH_SHORT).show();
                counter++;
            }
        });

    }
    public void updateTime(){
        text.setText(new Date().toString());
    }
}