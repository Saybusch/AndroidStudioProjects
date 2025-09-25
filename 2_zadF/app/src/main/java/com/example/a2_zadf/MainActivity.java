package com.example.a2_zadf;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

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
            try{
                if (weight.getText().toString().isEmpty() || height.getText().toString().isEmpty()) throw new Exception();
                else {
                    float w =Float.parseFloat(weight.getText().toString());
                    float h = Float.parseFloat(height.getText().toString());
                    float bmi = BMI(w, h);
                    if(bmi < 0 || h < 0 || w < 0) throw new Exception();
                    txt.setText(getResources().getString(R.string.bmi) + bmi);
                    if (bmi < 18.5) img.setImageResource(R.drawable.low);
                    else if (bmi >= 18.5 && bmi <= 24.9) img.setImageResource(R.drawable.normal);
                    else img.setImageResource(R.drawable.over);
                }
            }
            catch (Exception e){
                Toast.makeText(this, getResources().getString(R.string.warn), Toast.LENGTH_SHORT).show();
            }

        });
    }
    public float BMI(float weight, float height){
        return weight/(height*height);
    }
}