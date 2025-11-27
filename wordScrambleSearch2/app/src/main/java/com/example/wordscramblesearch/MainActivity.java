package com.example.wordscramblesearch;

import android.app.AlertDialog;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button send, randomSelect, confirmGuess;
    EditText word, typeGuess;
    TextView displayWord, wins, guesses, hint;
    String correctWord;
    int winCount = 0, guessCount = 0, currentGuesses = 0;
    String[] slownik = {
            "Klawiatura",
            "Kalkulator",
            "Monitor",
            "Mysz",
            "Krzeslo",
            "Informatyk"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        send = findViewById(R.id.send);
        confirmGuess = findViewById(R.id.confirmGuess);
        word = findViewById(R.id.word);
        randomSelect = findViewById(R.id.randomSelect);
        typeGuess = findViewById(R.id.typeGuess);
        displayWord = findViewById(R.id.displayWord);
        wins = findViewById(R.id.wins);
        guesses = findViewById(R.id.guesses);
        hint = findViewById(R.id.hint);
        send.setOnClickListener(v -> {
            String typedWord = word.getText().toString();
            try{
                if(typedWord.isEmpty()) throw new Exception();
                else {
                    send.setVisibility(v.GONE);
                    randomSelect.setVisibility(v.GONE);
                    word.setVisibility(v.GONE);
                    confirmGuess.setVisibility(v.VISIBLE);
                    typeGuess.setVisibility(v.VISIBLE);
                    displayWord.setVisibility(v.VISIBLE);
                    hint.setVisibility(v.VISIBLE);
                    word.setText("");
                    displayWord.setText("Twoje słowo to: " + mieszajLitery(typedWord));
                    correctWord = typedWord;
                }
            }
            catch (Exception e) {Toast.makeText(this, "Niepoprawne dane wejściowe!", Toast.LENGTH_SHORT).show();}
        });
        confirmGuess.setOnClickListener(v -> {
            if(correctWord.equals(typeGuess.getText().toString())){
                winCount++;
                wins.setText("Wygrane: " + String.valueOf(winCount));
                Toast.makeText(this, "Gratulacje! Wygrałeś!", Toast.LENGTH_SHORT).show();
                send.setVisibility(v.VISIBLE);
                randomSelect.setVisibility(v.VISIBLE);
                word.setVisibility(v.VISIBLE);
                confirmGuess.setVisibility(v.GONE);
                typeGuess.setVisibility(v.GONE);
                displayWord.setVisibility(v.GONE);
                hint.setVisibility(v.GONE);
                word.setText("");
                typeGuess.setText("");
            }
            else{
                currentGuesses++;
                String typedWord = word.getText().toString();
                StringBuilder currentHint = new StringBuilder();
                if(currentGuesses > 2){
                    if(currentGuesses - 2 >= typedWord.length()) {
                        for (int i = 0; i < typedWord.length(); i++) {
                            currentHint.append(typedWord.toCharArray()[i]);
                        }
                    }
                    else{
                        for(int i = 0; i < currentGuesses - 2; i++) {
                            currentHint.append(typedWord.toCharArray()[i]);
                        }
                    }
                    //hint.setText("Hint: " + currentHint.toString());
                }
                else{
                    //hint.setText("Hint: ");
                }

                guessCount++;
                guesses.setText("Liczba zgadnięć: " + String.valueOf(guessCount));
                Toast.makeText(this, "Niepoprawne słowo! Spróbuj jeszcze raz", Toast.LENGTH_SHORT).show();
            }
        });
        randomSelect.setOnClickListener(v -> {
            Random random = new Random();
            String typedWord = slownik[random.nextInt(slownik.length)+1];
            send.setVisibility(v.GONE);
            randomSelect.setVisibility(v.GONE);
            word.setVisibility(v.GONE);
            confirmGuess.setVisibility(v.VISIBLE);
            typeGuess.setVisibility(v.VISIBLE);
            displayWord.setVisibility(v.VISIBLE);
            hint.setVisibility(v.VISIBLE);
            word.setText("");
            displayWord.setText("Twoje słowo to: " + mieszajLitery(typedWord));
            correctWord = typedWord;
        });
    }
    private String mieszajLitery(String slowo){
        List<Character> listaLiter = new ArrayList<>();
        for(char c : slowo.toCharArray()){
            listaLiter.add(c);
        }
        Collections.shuffle(listaLiter);
        StringBuilder sb = new StringBuilder();
        for (char c : listaLiter){
            sb.append(c);
        }
        return sb.toString();
    }
}