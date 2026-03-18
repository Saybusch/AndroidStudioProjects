package com.example.a11_zadc;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
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
        int[] views = {R.id.imgView1, R.id.imgView2, R.id.imgView3, R.id.imgView4, R.id.imgView5, R.id.imgView6};
        int[] imgIds = {R.drawable.niebieski_smok, R.drawable.karlik_szponiasty, R.drawable.dziobak, R.drawable.wyrak, R.drawable.golec, R.drawable.zaba_szklana};
        for (int i = 0; i < views.length; i++){
            int varia = i;
            ImageView view = findViewById(views[varia]);
            view.setOnClickListener(v -> {
                Intent intent = new Intent(this, animal_detail.class);
                intent.putExtra("imgSrc", imgIds[varia]);
                intent.putExtra("txt", view.getContentDescription());
                startActivity(intent);
            });
        }
    }
}