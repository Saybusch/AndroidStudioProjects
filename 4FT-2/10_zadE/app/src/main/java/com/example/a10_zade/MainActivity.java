package com.example.a10_zade;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText input;
    TextView selected;
    ListView lista;
    ArrayAdapter<String> adapter;
    ArrayList<String> numbers = new ArrayList<String>();

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

        btn = findViewById(R.id.btn);
        input = findViewById(R.id.input);
        selected = findViewById(R.id.selected);
        lista = findViewById(R.id.lista);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item, numbers);
        lista.setAdapter(adapter);
        btn.setOnClickListener(v -> {
            String number = input.getText().toString();
            boolean check = false;
            for (int i = 0; i < number.length(); i++){
                char sign = number.toCharArray()[i];
                check = (Character.isSpaceChar(sign) || Character.isAlphabetic(sign));
            }
            if(number.isEmpty() || number.length() < 3 || !check)
                Toast.makeText(this, "Niepoprawne dane", Toast.LENGTH_SHORT).show();
            else{
                numbers.add(number);
                adapter.notifyDataSetChanged();
            }
        });
        lista.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
            @Override
            public void onChildViewAdded(View parent, View child) {
                if(numbers.get(numbers.size()-1).length() == 3)
                    lista.getChildAt(numbers.size()-1).setAlpha(0.5f);
            }
            @Override
            public void onChildViewRemoved(View parent, View child) {

            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected.setText("Wybrany kontakt: " + numbers.get(position));

            }
        });
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder build = new AlertDialog.Builder(parent.getContext());
                build.setTitle("Czy usunąć numer telefonu " + numbers.get(position) + "?");
                build.setPositiveButton("TAK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        numbers.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                build.setNegativeButton("NIE", null);
                AlertDialog alert = build.create();
                alert.show();
                return true;
            }
        });
    }
}