package com.example.a4_sprawdzenie_silyhasla;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edit;
    ToggleButton toggle;
    TextView progress;
    ProgressBar progressBar;
    TextView length;
    Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.edit);
        toggle = findViewById(R.id.toggle);
        progress = findViewById(R.id.progress);
        progressBar = findViewById(R.id.progressBar);
        length = findViewById(R.id.lengthPass);
        clear = findViewById(R.id.clearAll);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                if(b) {
                    edit.setTransformationMethod(null);
                }
                else{
                    edit.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                passwordCheck(edit.getText().toString());
                length.setText("Długość hasła: " + edit.getText().toString().length());
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

            }
        });
        clear.setOnClickListener(v -> {
            edit.setText("");
            progress.setText("Siła Hasła");
            progress.setTextColor(Color.BLACK);
            progressBar.setProgress(0);
        });
    }
    public void passwordCheck(String password){
        int punkty = 0;
        if (password.length() >= 8) punkty++;
        if (password.matches(".*[A-Z].*")) punkty++;
        if (password.matches(".*[a-z].*")) punkty++;
        if (password.matches(".*\\d.*")) punkty++;
        if (password.matches(".*[!@#$%^&*()_+].*")) punkty++;

        switch (punkty){
            case 0: case 1:
                progress.setText("Hasło bardzo słabe");
                progress.setTextColor(Color.RED);
                break;
            case 2 :
                progress.setText("Hasło słabe");
                progress.setTextColor(Color.parseColor("#CC5500"));
                break;
            case 3:
                progress.setText("Hasło średnie");
                progress.setTextColor(Color.parseColor("#BA8E23"));
                break;
            case 4:
                progress.setText("Hasło dobre");
                progress.setTextColor(Color.CYAN);
                break;
            case 5:
                progress.setText("Hasło bardzo silne");
                progress.setTextColor(Color.GREEN);
                break;
        }
        progressBar.setProgress(punkty);
    }
    public void ratePassword(String password){
        progressBar.setMax(100);
        int points = 0; int upper = 0; int lower = 0; int num = 0; int symb = 0;
        int consUpper = 0; int consLower = 0; int consNum = 0;
        String characters = "!@#$%^&*()";
        int pLen = password.length();
        char lastLetter = ' ';
        if(pLen == 0) progressBar.setProgress(0);
        for(int i = 0; i < pLen; i++) {
            char letter = password.toCharArray()[i];
            if (Character.isDigit(letter)) num++;
            if (Character.isUpperCase(letter)) upper++;
            if (Character.isLowerCase(letter)) lower++;
            if (characters.indexOf(letter) != -1) symb++;
            if(i > 0){
                if(Character.isDigit(letter) == Character.isDigit(lastLetter)) consNum++;
                if(Character.isUpperCase(letter) == Character.isUpperCase(lastLetter)) consUpper++;
                if(Character.isLowerCase(letter) == Character.isLowerCase(lastLetter)) consLower++;
            }
            lastLetter = letter;
        }
        //Additions

        points += 4 * pLen;
        if(consUpper != pLen-1) points += (2*(pLen - upper));
        if(consLower != pLen-1) points += (2*(pLen - lower));
        if(num > 0) points += (num * 4);
        if(symb > 0) points += (symb * 6);

        //Deductions

        if(num == pLen) points -= num;
        if(pLen == upper+lower) points -= upper+lower;
        if(consUpper > 0) points -= (consUpper-1)*2;
        if(consLower > 0) points -= (consLower-1)*2;
        if(consNum > 0) points -= (consNum-1)*2;

        length.setText(String.valueOf(points));

        if (points < 30) {
            progress.setText("Hasło bardzo słabe");
            progress.setTextColor(Color.RED);
        }
        else if (points < 50){
            progress.setText("Hasło słabe");
            progress.setTextColor(Color.parseColor("#CC5500"));
        } else if (points < 75) {
            progress.setText("Hasło średnie");
            progress.setTextColor(Color.parseColor("#BA8E23"));
        } else if (points < 90) {
            progress.setText("Hasło dobre");
            progress.setTextColor(Color.CYAN);
        }
        else{
            progress.setText("Hasło bardzo silne");
            progress.setTextColor(Color.GREEN);
        }
        progressBar.setProgress(points);
    }
}