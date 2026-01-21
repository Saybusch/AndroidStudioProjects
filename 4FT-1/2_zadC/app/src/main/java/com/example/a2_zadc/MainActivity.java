package com.example.a2_zadc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edit;
    Button btn;
    Button btn2;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.editTextText);
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        txt = findViewById(R.id.textView2);

        btn.setOnClickListener(view -> MainActivity.this.convertToKelvin());
        btn2.setOnClickListener(view -> MainActivity.this.convertToFahrenheit());

    }
    private void convertToKelvin() {
        String tempString = edit.getText().toString();
        if(!tempString.isEmpty()){
            double tempC = Double.parseDouble(tempString);
            double tempK = tempC + 273.15;
            txt.setText(String.format("Temperatura w Kelvinach: %.2f", tempK));
        } else {
            Toast.makeText(this, "Proszę wprowadzić temperaturę", Toast.LENGTH_SHORT).show();
        }
    }
    private void convertToFahrenheit() {
        String tempString = edit.getText().toString();
        if(!tempString.isEmpty()){
            double tempC = Double.parseDouble(tempString);
            double tempF = (9*tempC)/5 + 32;
            txt.setText(String.format("Temperatura w Fahrenheitach: %.2f", tempF));
        } else {
            Toast.makeText(this, "Proszę wprowadzić temperaturę", Toast.LENGTH_SHORT).show();
        }
    }
}