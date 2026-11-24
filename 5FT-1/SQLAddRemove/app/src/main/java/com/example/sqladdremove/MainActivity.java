package com.example.sqladdremove;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText autorEdit, tytulEdit;
    Button btn;
    ListView lista;
    SQLiteDatabase db;
    ArrayList<String> data;
    ArrayList<Integer> dataIDs;
    ArrayAdapter<String> adapter;
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
        autorEdit = findViewById(R.id.autorEdit);
        tytulEdit = findViewById(R.id.tytulEdit);
        btn = findViewById(R.id.btn);
        lista = findViewById(R.id.lista);
        data = new ArrayList<>();
        dataIDs = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        lista.setAdapter(adapter);
        db = openOrCreateDatabase("BIBLIOTEKA", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS KSIAZKI(Id INTEGER PRIMARY KEY AUTOINCREMENT, Tytul TEXT, Autor TEXT)");
        db.execSQL("DELETE FROM KSIAZKI");
        db.execSQL("INSERT INTO KSIAZKI VALUES (1, 'Pan Tadeusz', 'Adam Mickiewicz')");
        db.execSQL("INSERT INTO KSIAZKI VALUES (5, 'Dziady', 'Adam Mickiewicz')");
        db.execSQL("INSERT INTO KSIAZKI VALUES (2, 'Lalka', 'Bolesław Prus')");
        db.execSQL("INSERT INTO KSIAZKI VALUES (3, 'Quo Vadis', 'Henryk Sienkiewicz')");
        db.execSQL("INSERT INTO KSIAZKI VALUES (4, 'Zbrodnia i kara', 'Fiodor Dostojewski')");
        db.execSQL("INSERT INTO KSIAZKI VALUES (6, 'Konrad Walenrod', 'Adam Mickiewicz')");
        updateBooks();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String autor = autorEdit.getText().toString();
                String tytul = tytulEdit.getText().toString();
                db.execSQL("INSERT INTO KSIAZKI(Tytul, Autor) VALUES(?, ?)", new Object[]{tytul, autor});
                autorEdit.setText("");
                tytulEdit.setText("");
                updateBooks();
                Toast.makeText(MainActivity.this, "Dodano nową książkę", Toast.LENGTH_SHORT).show();
            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int itemID = dataIDs.get(i);
                db.delete("KSIAZKI", "Id = ?", new String[]{String.valueOf(itemID)});
                updateBooks();
                Toast.makeText(MainActivity.this, "Usunięto książkę", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void updateBooks(){
        data.clear();
        dataIDs.clear();
        Cursor c = db.rawQuery("SELECT * FROM KSIAZKI", null);
        while(c.moveToNext()) {
            int id = c.getInt(0);
            String tytul = c.getString(1);
            String autor = c.getString(2);
            data.add(tytul + " - " + autor);
            dataIDs.add(id);
        }
        c.close();
        adapter.notifyDataSetChanged();
    }
}