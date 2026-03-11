package com.example.a10_zadg;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ListView ucz;
    Button btn, reset;
    ArrayAdapter adapter;
    Random random = new Random();
    ArrayList<String> checked = new ArrayList<>();
    String[] student = {
            "Anna Kowalska",
            "Jan Nowak",
            "Piotr Wiśniewski",
            "Maria Wójcik",
            "Tomasz Kamiński",
            "Katarzyna Lewandowska",
            "Paweł Zieliński"
    };
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
        ucz = findViewById(R.id.uczniowie);
        btn = findViewById(R.id.btn);
        reset = findViewById(R.id.reset);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, student);
        ucz.setAdapter(adapter);
        AlertDialog.Builder buildErr = new AlertDialog.Builder(this);
        buildErr.setTitle("Błąd");
        buildErr.setMessage("Nie zaznaczono żadnego ucznia");
        buildErr.setPositiveButton("OK", null);
        AlertDialog alertErr = buildErr.create();
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setTitle("Wylosowany uczeń");
        build.setPositiveButton("OK", null);
        btn.setOnClickListener(v -> {
            for(int i = 0; i < ucz.getChildCount(); i++){
                if(ucz.isItemChecked(i)) checked.add(student[i]);
            }
            if(checked.isEmpty()) alertErr.show();
            else{
                String wylosowany = checked.get(random.nextInt(checked.size()));
                build.setMessage("Do odpowiedzi: \n\n" + wylosowany);
                build.setCancelable(false);
                build.setPositiveButton("OK", null);
                build.create().show();
            }
        });
        reset.setOnClickListener(v -> {
            checked.clear();
            for(int i = 0; i < ucz.getChildCount(); i++){
                ucz.setItemChecked(i, false);
            }
        });
    }
}