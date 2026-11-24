package com.example.savedata;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    CheckBox check;
    Button btn, clearEdit;
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
        edit = findViewById(R.id.edit);
        check = findViewById(R.id.check);
        btn = findViewById(R.id.btn);
        clearEdit = findViewById(R.id.clearEdit);

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String text = preferences.getString("edit", "");
        edit.setText(text);

        boolean zaznaczone = preferences.getBoolean("check", false);
        check.setChecked(zaznaczone);

        btn.setOnClickListener(v -> {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("edit", edit.getText().toString());
            editor.putBoolean("check", check.isChecked());
            editor.commit();
            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
        });
        clearEdit.setOnClickListener(v -> {
            edit.setText("");
            SharedPreferences.Editor editor = preferences.edit();
            editor.remove("check");
            editor.commit();
        });
    }
}