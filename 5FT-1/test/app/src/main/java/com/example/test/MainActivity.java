package com.example.test;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button play, stop, pause, browserbtn;
    WebView browser;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.play);
        stop = findViewById(R.id.stop);
        pause = findViewById(R.id.pause);
        browserbtn = findViewById(R.id.browserbtn);
        browser = findViewById(R.id.browser);
        mediaPlayer = MediaPlayer.create(this, R.raw.dzwiek);
        play.setOnClickListener(v -> {
            if(!mediaPlayer.isPlaying()){
                mediaPlayer.start();
                Toast.makeText(MainActivity.this, "Odtwarzanie", Toast.LENGTH_SHORT).show();
            }
        });
        stop.setOnClickListener(v -> {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.dzwiek);
                Toast.makeText(MainActivity.this, "Zatrzymano", Toast.LENGTH_SHORT).show();
            }
        });
        pause.setOnClickListener(v -> {
            if(mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                Toast.makeText(MainActivity.this, "Pauzowanie", Toast.LENGTH_SHORT).show();
            }
        });
        browserbtn.setOnClickListener(v -> {
            browser.setWebViewClient(new WebViewClient());
            browser.getSettings().setJavaScriptEnabled(true);
            browser.loadUrl("https://google.com");
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}