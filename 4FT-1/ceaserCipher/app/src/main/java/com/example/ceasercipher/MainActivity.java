package com.example.ceasercipher;

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
    Button send, plus, minus;
    EditText word, shift;
    TextView text;
    String alphabet = "abcdefghiklmnopqrstuvwxyz";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        word = findViewById(R.id.word);
        send = findViewById(R.id.send);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        shift = findViewById(R.id.shift);
        text = findViewById(R.id.text);
        send.setOnClickListener(v ->{
            StringBuilder string = new StringBuilder();
            try{
                String cipher = word.getText().toString();
                int shiftInt = Integer.parseInt(shift.getText().toString());
                if(cipher.isEmpty()) throw new Exception();
                else {
                    for(char c : cipher.toCharArray()){
                        string.append(alphabet.toCharArray()[(alphabet.indexOf(c) + shiftInt) % 26]);
                    }
                }
            }
            catch (Exception e) {
                Toast.makeText(this, "Niepoprawne dane wejściowe", Toast.LENGTH_SHORT).show();
            }
            text.setText(string.toString());
        });
        plus.setOnClickListener(v -> {
            int shiftInt = Integer.parseInt(shift.getText().toString());
            word.setText(String.valueOf(shiftInt + 1));
        });
        plus.setOnClickListener(v -> {
            int shiftInt = Integer.parseInt(shift.getText().toString());
            word.setText(shiftInt - 1);
        });
    }
}