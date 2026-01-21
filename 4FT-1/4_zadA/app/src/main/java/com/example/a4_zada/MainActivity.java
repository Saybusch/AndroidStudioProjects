package com.example.a4_zada;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    TextView power;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.edit);
        btn = findViewById(R.id.btn);
        txt = findViewById(R.id.txt);
        tg = findViewById(R.id.tg);
        power = findViewById(R.id.strength);

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
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {

            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int strength = checkStrength(edit.getText().toString());
                if (strength < 5) power.setText("Hasło słabe");
                else if (strength < 10) power.setText("Hasło średnie");
                else if (strength < 20) power.setText("Hasło dobre");
                else power.setText("Hasło silne");
            }
        });
    }
    public int checkStrength(String password){
        int pow = 0;
        if(password.length() >= 8) pow++;
        String characters = "!@#$%^&*()-+=";
        for (int i = 0; i < password.length(); i++){
            char letter = password.toCharArray()[i];
            if (Character.isDigit(letter)) pow++;
            if (Character.isUpperCase(letter)) pow++;
            if(characters.indexOf(letter) != -1) pow += 2;
        }
        return pow;
    }
}