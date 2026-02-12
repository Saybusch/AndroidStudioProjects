package com.example.inf04_2025_styczen;

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
    Button sendProgramInput, turnOn;
    EditText inputData;
    TextView displayWashingProgram, displayVaccumPowerState, displayVaccumStatus;
    boolean on = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        sendProgramInput = findViewById(R.id.sendProgramInput);
        turnOn = findViewById(R.id.turnOn);
        inputData = findViewById(R.id.programInput);
        displayWashingProgram = findViewById(R.id.displayProgram);
        displayVaccumPowerState = findViewById(R.id.displayOnOff);
        displayVaccumStatus = findViewById(R.id.displayStatus);
        sendProgramInput.setOnClickListener(v -> {
            String programNumber = inputData.getText().toString();
            try{
                int number = Integer.parseInt(programNumber);
                if(number >= 1 && number <= 12) displayWashingProgram.setText("Numer prania: "+ number);
            }
            catch (Exception e) { }
        });
        turnOn.setOnClickListener(v -> {
            if(!on){
                turnOn.setText("WYŁĄCZ");
                displayVaccumPowerState.setText("Odkurzacz włączony");
                on = true;
            }
            else {
                turnOn.setText("WŁĄCZ");
                displayVaccumPowerState.setText("Odkurzacz wyłączony");
                on = false;
            }
        });
    }
}