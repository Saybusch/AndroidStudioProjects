package com.example.wideo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button play, pause, stop;
    VideoView video;
    MediaPlayer media;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);
        video = findViewById(R.id.video);
        media = MediaPlayer.create(this, R.raw.film);
        Uri path = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.film);
        video.setVideoURI(path);
        play.setOnClickListener(v -> {
            video.start();
        });
        pause.setOnClickListener(v -> {
            if (video.isPlaying()){
                video.pause();
            }
        });
        stop.setOnClickListener(v -> {
            if (video.isPlaying()){
                video.stopPlayback();
                video.setVideoURI(path);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}