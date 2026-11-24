package com.example.converter;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    Spinner input, output;
    Button btn;
    TextView answer, error;
    ArrayAdapter<String> inputAdapter;
    ArrayAdapter<String> outputAdapter;
    String[] inputs = new String[]{"Czwórkowy", "Dziesiętny"};
    String[] outputs = new String[]{"Czwórkowy", "Dziesiętny"};
    Konwerter conv = new Konwerter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.edit);
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
        btn = findViewById(R.id.btn);
        answer = findViewById(R.id.answer);
        error = findViewById(R.id.error);
        inputAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, inputs);
        outputAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, outputs);
        input.setAdapter(inputAdapter);
        output.setAdapter(outputAdapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean good = true;
                error.setText("");
                StringBuilder str = new StringBuilder();
                str.append("Wynik: ");
                String text = edit.getText().toString().strip();
                if(text.isBlank()) error.setText("Wpisz liczbę do konwersji");
                else{
                    try{
                        int pos1 = input.getSelectedItemPosition();
                        int pos2 = output.getSelectedItemPosition();
                        for(char item : text.toCharArray()){
                            if(Character.isLetter(item)) throw new Exception();
                        }
                        if(pos1 == pos2){
                            str.append(text);
                        }
                        else if (pos1 == 0){
                            String[] check = {"0", "1", "2", "3"};
                            for(String item : check){
                                if(!text.contains(item)) throw new Exception();
                            }
                            str.append(conv.czworkowyNaDziesietny(text));
                        }
                        else {
                            str.append(conv.dziesietnyNaCzworkowy(Long.parseLong(text)));
                        }
                    } catch (Exception e){
                        error.setText("Błędna liczba dla wybranego systemu");
                    }
                }
                answer.setText(str.toString());
            }
        });
    }
}