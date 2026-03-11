package com.example.a11_zada;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OpisActivity extends AppCompatActivity {
    ImageView img;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_opis);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        img = findViewById(R.id.img);
        txt = findViewById(R.id.txt);
        img.setImageResource(R.drawable.van_gogh);
        txt.setText("Vincent van Gogh - holenderski malarz postimpresjonistyczny, którego twórczość dzięki żywej kolorystyce i emocjonalnemu " +
                "oddziaływaniu wywarła dalekosiężny wpływ na sztukę XX w. Artysta cierpiał na napady lękowe i narastające " +
                "ataki spowodowane zaburzeniami psychicznymi. Zmarł w wieku 37 lat jako twórca nieznany szerszemu ogółowi, w " +
                "wyniku postrzału z broni palnej – prawdopodobnie samobójczego.");
    }
}