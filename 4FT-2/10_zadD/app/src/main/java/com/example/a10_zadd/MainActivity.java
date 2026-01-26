package com.example.a10_zadd;

import android.os.Bundle;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Console;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edit;
    Button adder, change;
    ListView lista;
    ArrayAdapter<String> adapter;
    ArrayList<String> array = new ArrayList<String>();
    int selectedIndex = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.edit);
        adder = findViewById(R.id.add);
        change = findViewById(R.id.change);
        lista = findViewById(R.id.lista);
        array.add("Chleb");
        array.add("Mleko");
        array.add("Jajka");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
        lista.setAdapter(adapter);
        adder.setOnClickListener(v -> {
            String text = edit.getText().toString();
            if (!text.isEmpty()) {
                array.add(text);
                adapter.notifyDataSetChanged();
            }
        });
        change.setOnClickListener(v -> {
            if (selectedIndex >= 0) {
                String item = edit.getText().toString().trim();
                if (!item.isEmpty()) {
                    array.set(selectedIndex, item);
                    adapter.notifyDataSetChanged();
                    edit.setText("");
                    selectedIndex = -1;
                }
            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedIndex = position;
            }
        });
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder build = new AlertDialog.Builder(parent.getContext());
                build.setTitle("Czy chcesz usunąć item?");
                build.setPositiveButton("OK", null);
                AlertDialog dialog = build.create();
                dialog.show();
                return true;
            }
        });
    }
}