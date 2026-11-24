package com.example.photogallery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Switch flowerSwitch, carSwitch, animalSwitch;
    ArrayList<Image> images = new ArrayList<>();
    ArrayList<ImageView> imageViews = new ArrayList<>();
    int[] resID = {R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5, R.id.img6};
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        flowerSwitch = findViewById(R.id.flowerSwitch);
        carSwitch = findViewById(R.id.carSwitch);
        animalSwitch = findViewById(R.id.animalSwitch);
        for(int i = 0; i < 6; i++) imageViews.add(findViewById(resID[i]));
        images.add(new Image(1, "Kwiat", "flower1.jpg", 1));
        images.add(new Image(2, "Kwiat", "flower2.jpg", 1));
        images.add(new Image(3, "Kot", "animal1.jpg", 2));
        images.add(new Image(4, "Pies", "animal2.jpg", 2));
        images.add(new Image(5, "Samochod", "car1.jpg", 3));
        images.add(new Image(6, "Samochod", "car2.jpg", 3));
        flowerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                for(int i = 0; i < images.size(); i++){
                    Image img = images.get(i);
                    if(img.category == 1) {
                        if(b) imageViews.get(i).setVisibility(View.VISIBLE);
                        else imageViews.get(i).setVisibility(View.INVISIBLE);
                    }
                }
            }
        });
        carSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                for(int i = 0; i < images.size(); i++){
                    Image img = images.get(i);
                    if(img.category == 3){
                        if(b) imageViews.get(i).setVisibility(View.VISIBLE);
                        else imageViews.get(i).setVisibility(View.INVISIBLE);
                    }
                }
            }
        });
        animalSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                for(int i = 0; i < images.size(); i++){
                    Image img = images.get(i);
                    if(img.category == 2){
                        if(b) imageViews.get(i).setVisibility(View.VISIBLE);
                        else imageViews.get(i).setVisibility(View.INVISIBLE);
                    }
                }
            }
        });
    }
}