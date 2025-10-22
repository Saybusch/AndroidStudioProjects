package com.example.a2_1_zadd;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText ile_osob;
    EditText ile_dni;
    EditText zakwaterowanie;
    EditText transport;
    EditText wyzywienie;
    CheckBox dodatkowe;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        ile_osob = findViewById(R.id.ile_osob);
        ile_dni = findViewById(R.id.ile_dni);
        zakwaterowanie = findViewById(R.id.zakwaterowanie);
        transport = findViewById(R.id.transport);
        wyzywienie = findViewById(R.id.wyzywienie);
        dodatkowe = findViewById(R.id.dodatkowe);
        txt = findViewById(R.id.txt);
        btn.setOnClickListener(v -> {
            try {
                if(ile_osob.getText().toString().isEmpty() || ile_dni.getText().toString().isEmpty()) throw new Exception("liczba osób lub dni nie spełnia wymogów");
                int getIn = Integer.parseInt(zakwaterowanie.getText().toString());
                int transfer = Integer.parseInt(transport.getText().toString());
                int foods = Integer.parseInt(wyzywienie.getText().toString());
                double suma = getIn + foods + transfer;
                if (dodatkowe.isChecked()) suma += (suma * 0.2);
                txt.setText("Szacowany koszt wakacyjnego wyjazdu: " + String.valueOf(Math.round(koszty()) + "zł"));
            }
            catch (Exception e) {
                Toast.makeText(this, e.toString().substring(20), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public double koszty(){
        int people = Integer.parseInt(ile_osob.getText().toString());
        int days = Integer.parseInt(ile_dni.getText().toString());
        int getIn = Integer.parseInt(zakwaterowanie.getText().toString());
        int transfer = Integer.parseInt(transport.getText().toString());
        int foods = Integer.parseInt(wyzywienie.getText().toString());
        if (dodatkowe.isChecked()) return ((people * (getIn + foods) * days) + (transfer * people)) * 1.2;
        else return (people * (getIn + foods) * days) + (transfer * people);
    }
}