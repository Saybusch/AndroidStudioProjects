package com.example.a2_zade;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    TextView txt;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.edit);
        txt = findViewById(R.id.txt);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        try {
            btn1.setOnClickListener(v -> {
                if (edit.getText().toString().isEmpty()) DataCheck(-1);
                else txt.setText(PolePowierzchni(Integer.parseInt(edit.getText().toString())));
            });
            btn2.setOnClickListener(v -> {
                if (edit.getText().toString().isEmpty()) DataCheck(-1);
                else txt.setText(Objetosc(Integer.parseInt(edit.getText().toString())));
            });
        }
        catch (Exception e) {
            DataCheck(-1);
        };
    }
    public String PolePowierzchni(int dlugosc) {
        DataCheck(dlugosc);
        dlugosc *= dlugosc * 6;
        return "Pole powierzchni sześcianu = " + String.valueOf(dlugosc) + " ";
    }
    public String Objetosc(int dlugosc) {
        DataCheck(dlugosc);
        dlugosc *= dlugosc*dlugosc;
        return "Objętość sześcianu = " + String.valueOf(dlugosc) + " ";
    }
    public void DataCheck(int value){
        if(value < 0) Toast.makeText(this, "Wprowadź poprawną liczbę całkowitą", Toast.LENGTH_SHORT).show();
    }
}