package com.example.inf04_2021_czerwiec;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText login;
    EditText pass;
    EditText passRepeat;
    Button confirm;
    TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        passRepeat = findViewById(R.id.passwordRepeat);
        confirm = findViewById(R.id.btn);
        answer = findViewById(R.id.answer);
        answer.setText("Autor 12345678910");
        confirm.setOnClickListener(v -> {
            if(!login.getText().toString().contains("@")){
                answer.setText("Nieprawidłowy adres e-mail");
            }
            else{
                if(!pass.getText().toString().equals(passRepeat.getText().toString())){
                    answer.setText("Hasło się różnią");
                }
                else {
                    answer.setText("Witaj " + login.getText().toString());
                }
            }
        });
    }
}