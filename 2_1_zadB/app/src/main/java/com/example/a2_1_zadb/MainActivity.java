package com.example.a2_1_zadb;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

    EditText edittext;
    Button btn1;
    Button btn2;
    TextView txt;
    int pot = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edittext = findViewById(R.id.edittxt);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        txt = findViewById(R.id.txt);

        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { pot = 1; }
        });

        btn1.setOnClickListener(v -> {
            String text = edittext.getText().toString();
            if(!text.isEmpty()) potega(text);
            else alert();
        });
        btn2.setOnClickListener(v -> {
            String text = edittext.getText().toString();
            if(!text.isEmpty()) squareRoot(text);
            else alert();
        });
    }
    public void potega(String edit){
        int liczba = Integer.parseInt(edit);
        String wynik = liczba + "^ " + pot + " = " + (int)Math.pow(liczba, pot);
        txt.setText(wynik);
        pot++;
    }
    public void squareRoot(String edit){
        int liczba = Integer.parseInt(edit);
        if(liczba > 0) {
            String wynik = "\\" + '/' + liczba + "=" + String.valueOf(Math.sqrt(liczba));
            txt.setText(wynik);
        }
        else alert();
    }
    public void alert(){
        Toast.makeText(this, "Pole jest puste lub posiada niepoprawne dane", Toast.LENGTH_SHORT).show();
    }
}