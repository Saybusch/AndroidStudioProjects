package com.example.a1_zada;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button btn;
    ImageView img;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.txt);
        btn = findViewById(R.id.btn);
        img = findViewById(R.id.obraz);
        layout = findViewById(R.id.main);


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sayHello(text, img, layout);
                }
            });

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void sayHello(TextView text, ImageView img, LinearLayout layout){
        text.setText("Witam Cię w pierwszej aplikacji !!! \n Aplikacji autorstwa XYZ");
        img.setVisibility(View.VISIBLE);
        layout.setBackgroundColor(getResources().getColor(R.color.yellow));
    }
}