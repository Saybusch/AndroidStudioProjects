package com.example.a11_zade;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;

public class test extends AppCompatActivity {
    TextView question, questionNumber;
    RadioButton ans1, ans2, ans3, ans4;
    RadioGroup rg;
    String[][] questions = {
            {
                "Mechanizm obietnic (ang. promises) w języku JavaScript ma na celu",
                    "zastąpić mechanizm dziedziczenia w programowaniu obiektowym.",
                    "obsłużyć przechwytywanie błędów aplikacji.",
                    "poprawić czytelność kodu synchronicznego.",
                    "obsłużyć funkcjonalność związaną z kodem asynchronicznym."
            },
            {
                "Oznaczeniem komentarza jednoliniowego w języku Python jest:",
                    "#",
                    "!",
                    "\"\"",
                    "//"
            }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test);
        question = findViewById(R.id.question);
        questionNumber = findViewById(R.id.questionNumber);
        for(String[] quest : questions){
            question.setText(quest[0]);
            ans1.setText(quest[1]);
            ans2.setText(quest[2]);
            ans3.setText(quest[3]);
            ans4.setText(quest[4]);
        }
    }
}