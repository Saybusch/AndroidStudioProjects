package com.example.a2_zadb;

import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    Button btn;
    Button btn2;
    EditText et;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        et = findViewById(R.id.editTextText);

        btn.setOnClickListener(view -> MainActivity.this.showToast());
        btn2.setOnClickListener(view -> MainActivity.this.showView());


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void showToast(){
        String info = et.getText().toString().trim();
        if(info.isEmpty()) Toast.makeText(MainActivity.this, "Podaj wartość", Toast.LENGTH_SHORT).show();
        else Toast.makeText(MainActivity.this, "Informacja z pola EditText: "+info, Toast.LENGTH_SHORT).show();
    }
    private void showView(){
        String info = et.getText().toString().trim();
        txt = findViewById(R.id.textView);
        if(info.isEmpty()) txt.setText("Podaj wartość");
        else txt.setText("Informacja z pola EditText: "+info);
    }
}