package com.example.a4_zadb;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText password = findViewById(R.id.password);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2= findViewById(R.id.btn2);
        Button btn3= findViewById(R.id.btn3);
        Button btn4= findViewById(R.id.btn4);
        Button btn5= findViewById(R.id.btn5);
        Button btn6= findViewById(R.id.btn6);
        Button btn7= findViewById(R.id.btn7);
        TextView txt1 = findViewById(R.id.ans1);
        TextView txt2 = findViewById(R.id.ans2);
        TextView txt3 = findViewById(R.id.ans3);
        TextView txt4 = findViewById(R.id.ans4);
        TextView txt5 = findViewById(R.id.ans5);
        TextView txt6 = findViewById(R.id.ans6);
        TextView txt7 = findViewById(R.id.ans7);
        String pass = password.getText().toString();
        btn1.setOnClickListener(v -> {
            int num = 0;
            for(int i = 0; i < pass.length(); i++){
                char letter = pass.toCharArray()[i];
                if(Character.isDigit(letter)) num++;
            }
            if(num == 3) txt1.setText("TAK");
            else txt1.setText("NIE");
        });
        btn2.setOnClickListener(v -> {
            boolean correct = false;
            for(int i = 0; i < pass.length(); i++){
                char letter = pass.toCharArray()[i];
                correct = Character.isWhitespace(letter);
                if(correct) break;
            }
            if(correct) txt2.setText("NIE");
            else txt2.setText("TAK");
        });
        btn3.setOnClickListener(v -> {
            int special = 0;
            String specialCharacters = "!@#$%^&*()?";
            for(int i = 0; i < pass.length(); i++){
                char letter = pass.toCharArray()[i];
                if(specialCharacters.indexOf(letter) != -1) special++;
            }
            if(pass.length() >= 5 && special >= 3) txt3.setText("TAK");
            else txt3.setText("NIE");
        });
        btn4.setOnClickListener(v -> {
            boolean correct = false;
            for(int i = 0; i < pass.length(); i++){
                char letter = pass.toCharArray()[i];
                if (i < 2) correct = Character.isDigit(letter);
                else if(i == 2) correct = pass.contains("-");
                else if(i < 6) correct = Character.isDigit(letter);
                else correct = false;
            }
            if (correct) txt4.setText("TAK");
            else txt4.setText("NIE");
        });
        btn5.setOnClickListener(v -> {
            boolean onlyNumber = false;
            for(int i = 0; i < pass.length(); i++){
                char letter = pass.toCharArray()[i];
                onlyNumber = Character.isDigit(letter);
            }
            if(pass.length() == 1 && onlyNumber) txt5.setText("TAK");
            else txt5.setText("NIE");
        });
        btn6.setOnClickListener(v -> {
            boolean correct = false;
            for(int i = 0; i < pass.length(); i++){
                char letter = pass.toCharArray()[i];
                if(i < 3) correct = Character.isUpperCase(letter);
                else if (i < 7) correct = Character.isDigit(letter);
                else correct = false;
            }
            if(pass.length() == 1 && correct) txt6.setText("TAK");
            else txt6.setText("NIE");
        });
    }
}