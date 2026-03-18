package com.example.a11_zade;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText login, password;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        btn = findViewById(R.id.btn);
        Intent intent = new Intent(this, test.class);

        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setTitle("Błąd");
        build.setMessage("Błędne hasło, spróbuj ponownie");
        build.setPositiveButton("OK", null);

        btn.setOnClickListener(v -> {
            if(login.getText().toString().equals("l") && password.getText().toString().equals("p")) {
                startActivity(intent);
                finish();
            }
            else build.create().show();
        });

    }
}