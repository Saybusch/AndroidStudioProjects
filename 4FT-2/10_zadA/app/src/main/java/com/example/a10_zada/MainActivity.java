package com.example.a10_zada;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ListView carView;
    TextView carViewText;
    //String[] list_car;
    String[] list_car = {
            "BMW seria X",
            "BMW seria Y",
            "BMW seria XY",
            "Audi seria X",
            "Audi seria Y",
            "Audi seria XY",
            "Mercedes seria X",
            "Mercedes seria XY",
            "Lexus",
            "Volvo",
            "Jaguar",
            "Porsche"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        carView = findViewById(R.id.carView);
        carViewText = findViewById(R.id.carViewSelect);
        //list_car = getResources().getStringArray(R.array.list_car);

         ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.my_list, R.id.text, list_car);

        carView.setAdapter(adapter);
        carView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long Id){
                String value = adapter.getItem(position);
                carViewText.setText(value);
            }
        });

    }
}