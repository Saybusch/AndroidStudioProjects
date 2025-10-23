package com.example.a3_zada;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText user;
    EditText pwd;
    CheckBox remember;
    TextView answer;
    ArrayList<String> loginDB = new ArrayList<>();
    ArrayList<String> pwdDB = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.zaloguj);
        login.setOnClickListener(v -> Zaloguj(v));
    }
    private void Zaloguj(View view) {
        user = findViewById(R.id.E_login);
        pwd = findViewById(R.id.E_haslo);
        remember = findViewById(R.id.zapamietaj);
        answer = findViewById(R.id.answer);
        String log = user.getText().toString();
        String pass = pwd.getText().toString();
        if(log.isEmpty() || pass.isEmpty())
            Toast.makeText(this, "Wypełnij login i haslo", Toast.LENGTH_SHORT).show();
        else {
            if(remember.isChecked()) {
                if(loginDB.contains(log)){
                    answer.setText("login jest już w bazie" + pass);
                }
                else{
                    answer.setText("użytkownik " + log + "\nhasło" + pass);
                    Toast.makeText(this, "Login i hasło wpisane do bazy", Toast.LENGTH_SHORT).show();
                    loginDB.add(log);
                    pwdDB.add(pass);
                }
            }
            else{
                answer.setText("użytkownik " + log + "\nhasło" + pass);
                Toast.makeText(this, "Login i hasło nie zostało wpisane do bazy", Toast.LENGTH_SHORT).show();
            }
        }
    }
}