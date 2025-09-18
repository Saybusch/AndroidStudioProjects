package com.example.a2_zadd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    EditText edit1;
    EditText edit2;
    Button btn;
    int koszt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        txt = findViewById(R.id.txt3);
        btn = findViewById(R.id.btn1);
        btn.setOnClickListener(v -> {
            if(!edit1.getText().toString().isEmpty() && !edit2.getText().toString().isEmpty()) {
                int numerKawy = Integer.parseInt(edit1.getText().toString());
                int waga = Integer.parseInt(edit2.getText().toString());
                koszt = 0;
                switch (numerKawy){
                    case 1:
                        koszt = 5 * waga;
                        break;
                    case 2:
                        koszt = 7 * waga;
                        break;
                    case 3:
                        koszt = 6 * waga;
                        break;
                    default:
                        break;
                }
                txt.setText("Koszt zamówienia wynosi " + koszt +" zł");
            }
        });

    }
}