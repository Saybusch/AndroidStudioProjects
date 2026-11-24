package com.example.projekt1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ProgressBar circle, line;
    Button btn;
    TextView txt;
    int progress = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        circle = findViewById(R.id.circleBar);
        line = findViewById(R.id.lineBar);
        btn = findViewById(R.id.addBtn);
        txt = findViewById(R.id.progress);
        circle.setVisibility(View.INVISIBLE);
        btn.setOnClickListener(v -> {
            progress += 10;
            circle.setVisibility(View.VISIBLE);
            if(progress > 100) progress = 0;
            line.setProgress(progress);
            txt.setText("Postęp: " + progress + "%");
            if(progress == 100) {
                circle.setVisibility(View.INVISIBLE);
                txt.setText("Zakończono!");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}