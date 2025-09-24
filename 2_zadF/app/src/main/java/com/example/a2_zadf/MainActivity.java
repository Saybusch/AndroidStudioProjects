package com.example.a2_zadf;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText weight;
    EditText height;
    Button btn;
    TextView txt;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        btn = findViewById(R.id.btn);
        txt = findViewById(R.id.txt);
        img = findViewById(R.id.img);

        btn.setOnClickListener(v -> {
            if (weight.getText().toString().isEmpty() || height.getText().toString().isEmpty()){
                Toast.makeText(this, "Niepoprawna waga lub wzrost", Toast.LENGTH_SHORT).show();
            }
            else {
                float bmi = BMI(Float.parseFloat(weight.getText().toString()), Float.parseFloat(height.getText().toString()));
                txt.setText("Twoje BMI: " + String.valueOf(bmi));
                if (bmi < 18.5) img.setImageResource(R.drawable.low);
                else if (bmi > 18.5 && bmi < 24.9) img.setImageResource(R.drawable.normal);
                else img.setImageResource(R.drawable.over);
            }
        });



    }
    public float BMI(float weight, float height){
        return weight/(height*height);
    }
}