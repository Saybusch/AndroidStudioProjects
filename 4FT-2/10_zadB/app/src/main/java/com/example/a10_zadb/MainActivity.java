package com.example.a10_zadb;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edit;
    Button add, remove;
    ListView list;
    ArrayList<String> listStr = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.edit);
        add = findViewById(R.id.addItem);
        remove = findViewById(R.id.removeItem);
        list = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_layout, R.id.text, listStr);
        list.setAdapter(adapter);
        add.setOnClickListener(v -> {
            try{
                if(!edit.getText().toString().isEmpty()){
                    listStr.add(edit.getText().toString());
                    adapter.notifyDataSetChanged();
                }
                else throw new Exception();
            }
            catch (Exception e) { Toast.makeText(this, "error", Toast.LENGTH_SHORT).show(); }
        });
        remove.setOnClickListener(v -> {
            try{
                if(!edit.getText().toString().isEmpty()){
                    listStr.remove(listStr.size()-1);
                    adapter.notifyDataSetChanged();
                }
                else throw new Exception();
            }
            catch (Exception e) { Toast.makeText(this, "error", Toast.LENGTH_SHORT).show(); }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                listStr.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }
}