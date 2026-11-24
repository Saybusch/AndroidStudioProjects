package com.example.projekt2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView limitSign, amountSign, amountWord, resultTxt;
    EditText edit;
    SeekBar seek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.inputTxt);
        seek = findViewById(R.id.seekBar);
        limitSign = findViewById(R.id.barLimit);
        amountSign = findViewById(R.id.amountChars);
        amountWord = findViewById(R.id.amountWords);
        resultTxt = findViewById(R.id.resultTxt);
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {}
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String txt = edit.getText().toString().trim();
                amountSign.setText("Liczba znaków: " + txt.length());
                int liczbaSlow = 0;
                if(txt.length() > 0) {
                    liczbaSlow++;
                    for(char item : txt.toCharArray()) if(item == ' ') liczbaSlow++;
                }
                amountWord.setText("Liczba słów: " + liczbaSlow);
                int limit = seek.getProgress();
                resultTxt.setText(shortenedTxt(txt, limit));
            }
        });
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                limitSign.setText("Limit znaków: " + seekBar.getProgress());
                resultTxt.setText(shortenedTxt(edit.getText().toString(), seekBar.getProgress()));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public String shortenedTxt(String text, int limit){
        if(text.length() <= limit) return text;
        return text.substring(0, limit);
    }
}