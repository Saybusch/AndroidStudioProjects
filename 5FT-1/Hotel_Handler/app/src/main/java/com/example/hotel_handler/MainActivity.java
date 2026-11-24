package com.example.hotel_handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button imgBtn, loginBtn;
    ImageView img;
    TextView imgDesc;
    EditText login, password;
    ProgressBar progress;
    int imageIndex = 0;
    int[] images = {R.drawable.obraz1, R.drawable.obraz2, R.drawable.obraz3};
    String[] imagesDesc = {"Hotel", "Basen", "Pokój"};
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
        imgBtn = findViewById(R.id.viewGallery);
        loginBtn = findViewById(R.id.loginbtn);
        img = findViewById(R.id.img);
        imgDesc = findViewById(R.id.imgDesc);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        progress = findViewById(R.id.progress);
        Handler handle = new Handler(Looper.getMainLooper());
        imgBtn.setOnClickListener(v -> {
            imageIndex = (imageIndex + 1) % 3;
            img.setImageDrawable(getDrawable(images[imageIndex]));
            imgDesc.setText(imagesDesc[imageIndex]);
        });
        Runnable imgShuffle = new Runnable() {
            @Override
            public void run() {
                imageIndex = (imageIndex + 1) % 3;
                img.setImageDrawable(getDrawable(images[imageIndex]));
                handle.postDelayed(this, 5000);
            }
        };
        //handle.postDelayed(imgShuffle, 5000);
        loginBtn.setOnClickListener(v -> {

            //handle.removeCallbacks(imgShuffle);
            if(login.getVisibility() == View.INVISIBLE){
                login.setVisibility(View.VISIBLE);
                password.setVisibility(View.VISIBLE);
            }else {
                if(login.getText().toString().isBlank() || password.getText().toString().isBlank()){
                    Toast.makeText(this, "Nie podano loginu albo hasła", Toast.LENGTH_SHORT).show();
                    return;
                }
                progress.setVisibility(View.VISIBLE);
                progress.setProgress(0);
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        int current = progress.getProgress();
                        progress.setProgress(current + 5);
                        if(current < 100) handle.postDelayed(this,100);
                        else{
                            Toast.makeText(MainActivity.this, "Zalogowano!", Toast.LENGTH_SHORT).show();
                            progress.setVisibility(View.INVISIBLE);
                            login.setVisibility(View.INVISIBLE);
                            password.setVisibility(View.INVISIBLE);
                            login.setText("");
                            password.setText("");
                            //handle.postDelayed(imgShuffle, 5000);
                        }
                    }
                };
                handle.postDelayed(r, 100);
            }
        });
    }
}