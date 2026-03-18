package com.example.a11_zade;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Collections;

public class test extends AppCompatActivity {
    TextView question, questionNumber;
    RadioButton ans1, ans2, ans3, ans4;
    RadioGroup rg;
    Button btn;
    int currentQuestion = 1;
    String[][] questions = {
            {
                "Mechanizm obietnic (ang. promises) w języku JavaScript ma na celu",
                    "zastąpić mechanizm dziedziczenia w programowaniu obiektowym.",
                    "obsłużyć przechwytywanie błędów aplikacji.",
                    "poprawić czytelność kodu synchronicznego.",
                    "obsłużyć funkcjonalność związaną z kodem asynchronicznym.",
                    "D"
            },
            {
                "Oznaczeniem komentarza jednoliniowego w języku Python jest:",
                    "#",
                    "!",
                    "\"\"",
                    "//",
                    "A"
            }
    };
    ArrayList<String> userAnswers = new ArrayList<>();
    int totalQuestions = questions.length;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test);
        question = findViewById(R.id.question);
        questionNumber = findViewById(R.id.questionNumber);
        rg = findViewById(R.id.rg);
        btn = findViewById(R.id.btn);
        ans1 = findViewById(R.id.answer1);
        ans2 = findViewById(R.id.answer2);
        ans3 = findViewById(R.id.answer3);
        ans4 = findViewById(R.id.answer4);
        questionNumber.setText(currentQuestion + "/" + totalQuestions);
        question.setText(questions[0][0]);
        ans1.setText(questions[0][1]);
        ans2.setText(questions[0][2]);
        ans3.setText(questions[0][3]);
        ans4.setText(questions[0][4]);
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setMessage("Brak odpowiedzi. Zaznacz odpowiedź");
        build.setPositiveButton("OK", null);
        AlertDialog.Builder finisher = new AlertDialog.Builder(this);
        finisher.setTitle("Koniec testu");
        finisher.setPositiveButton("Spróbuj jeszcze raz", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                recreate();
            }
        });
        finisher.setNegativeButton("Zamknij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        btn.setOnClickListener(v -> {
            int selectedId = rg.getCheckedRadioButtonId();
            if(selectedId == ans1.getId()) userAnswers.add("A");
            else if (selectedId == ans2.getId()) userAnswers.add("B");
            else if (selectedId == ans3.getId()) userAnswers.add("C");
            else if (selectedId == ans4.getId()) userAnswers.add("D");
            else {
                build.create().show();
                return;
            }
            if(currentQuestion == totalQuestions) {
                int score = 0;
                for(int i = 0; i < userAnswers.size(); i++) if(userAnswers.get(i).equals(questions[i][5])) score++;
                finisher.setMessage("Twój wynik: " + score + "/" + totalQuestions);
                finisher.create().show();
                return;
            }
            question.setText(questions[currentQuestion][0]);
            ans1.setText(questions[currentQuestion][1]);
            ans2.setText(questions[currentQuestion][2]);
            ans3.setText(questions[currentQuestion][3]);
            ans4.setText(questions[currentQuestion][4]);
            questionNumber.setText(currentQuestion + "/" + totalQuestions);
            currentQuestion++;
        });
    }
}