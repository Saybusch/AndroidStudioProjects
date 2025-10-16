package com.example.a2_1_zadc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText edit;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        edit = findViewById(R.id.editTxt);
        txt = findViewById(R.id.txt);

        btn.setOnClickListener(v -> {
            String ele = edit.getText().toString().trim();
            try {
                if (!ele.isEmpty()) {
                    int element = Integer.parseInt(ele);
                    if (element < 0)
                        Toast.makeText(this, "Element ciągu Fibonacciego liczymy tylko z liczb dodatnich", Toast.LENGTH_SHORT).show();
                    else {
                        int fib = fibonacci(element);
                        txt.setText(element + " element ciągu Fibonacciego wynosi " + fib);
                    }
                } else throw new Exception();
            }
            catch (Exception e) { Toast.makeText(this, "Wpisz liczbę", Toast.LENGTH_SHORT).show(); }
        });
    }
    private int fibonacci(int n) {
        if(n==0) return 0;
        else if (n==1) return 1;
        else return fibonacci(n-2) + fibonacci(n-1);
    }
}