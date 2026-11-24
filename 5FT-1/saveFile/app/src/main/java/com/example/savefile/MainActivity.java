package com.example.savefile;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    Button load, save;
    EditText text;
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
        load = findViewById(R.id.load);
        save = findViewById(R.id.save);
        text = findViewById(R.id.text);

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);

        load.setOnClickListener(v -> {
            try{
                FileInputStream fIn = openFileInput("textfile.txt");
                InputStreamReader isr = new InputStreamReader(fIn);
                BufferedReader reader = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String line;
                while((line = reader.readLine()) != null){
                    sb.append(line).append("\n");
                }
                reader.close();
                text.setText(sb.toString());
                Toast.makeText(this, "File has been loaded", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        save.setOnClickListener(v -> {
            String data = text.getText().toString();
            try {
                FileOutputStream fOut = openFileOutput("textfile.txt", MODE_PRIVATE);
                OutputStreamWriter osw = new OutputStreamWriter(fOut);
                osw.write(data);
                osw.close();
                Toast.makeText(this, "File has been saved", Toast.LENGTH_SHORT).show();
                text.setText("");
            } catch (IOException e){
                e.printStackTrace();
            }
        });
    }
}