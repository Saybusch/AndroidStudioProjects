package com.example.a4_zada;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText edit;
    Button btn;
    TextView txt;
    ToggleButton tg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.edit);
        btn = findViewById(R.id.btn);
        txt = findViewById(R.id.txt);
        tg = findViewById(R.id.tg);

        tg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                if(b) {
                    edit.setTransformationMethod(null);
                    tg.setForeground(getDrawable(R.drawable.oczko_otwarte));
                }
                else {
                    edit.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    tg.setForeground(getDrawable(R.drawable.oczko_zamkniete));
                }
            }
        });

        btn.setOnClickListener(v -> {
            try{
                String pass = edit.getText().toString();
                if (pass.length() > 7){
                    int cU = 0, cD = 0, cS = 0;
                    String characters = "!@#$%^&*()-+=";
                    for (int i = 0; i < pass.length(); i++){
                        char letter = pass.toCharArray()[i];
                        if(characters.indexOf(letter) != -1) cS += 1;
                        if(Character.isUpperCase(letter)) cU += 1;
                        if(Character.isDigit(letter)) cD += 1;
                    }
                    if(cS > 0 && cU > 0 && cD > 0) txt.setText("Hasło spełnia warunki");
                    else throw new Exception();
                }
                else throw new Exception();
            }
            catch (Exception e){
                txt.setText("Hasło nie spełnia warunków");
            }
        });
    }
}