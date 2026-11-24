package com.example.sql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button search;
    ListView list;
    EditText searchBar;
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
        search = findViewById(R.id.search);
        searchBar = findViewById(R.id.searchBar);
        list = findViewById(R.id.list);
        SQLiteDatabase db = openOrCreateDatabase("biblioteka", MODE_PRIVATE, null);
        String sql = "CREATE TABLE IF NOT EXISTS KSIAZKI(Id INTEGER PRIMARY KEY, Tytul TEXT, Autor TEXT)";
        db.execSQL(sql);
        db.execSQL("DELETE FROM KSIAZKI");
        db.execSQL("INSERT INTO KSIAZKI VALUES (1, 'Pan Tadeusz', 'Adam Mickiewicz')");
        db.execSQL("INSERT INTO KSIAZKI VALUES (5, 'Dziady', 'Adam Mickiewicz')");
        db.execSQL("INSERT INTO KSIAZKI VALUES (2, 'Lalka', 'Bolesław Prus')");
        db.execSQL("INSERT INTO KSIAZKI VALUES (3, 'Quo Vadis', 'Henryk Sienkiewicz')");
        db.execSQL("INSERT INTO KSIAZKI VALUES (4, 'Zbrodnia i kara', 'Fiodor Dostojewski')");
        db.execSQL("INSERT INTO KSIAZKI VALUES (6, 'Konrad Walenrod', 'Adam Mickiewicz')");
        ArrayList<String> wyniki = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT Id, Tytul, Autor FROM KSIAZKI", null);
        if (c.moveToFirst()) {
            do {
                int id = c.getInt(0);
                String tytul = c.getString(1);
                String autor = c.getString(2);
                wyniki.add(id + ". " + tytul + " - " + autor);
            } while (c.moveToNext());
        }
        c.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, wyniki);
        list.setAdapter(adapter);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> wyniki = new ArrayList<>();
                String authorLookup = searchBar.getText().toString();
                Cursor c2 = db.rawQuery("SELECT Id, Tytul, Autor FROM KSIAZKI WHERE Autor LIKE ?", new String[]{"%" + authorLookup + "%"});
                if (c2.moveToFirst()) {
                    do {
                        int id = c2.getInt(0);
                        String tytul = c2.getString(1);
                        String autor = c2.getString(2);
                        wyniki.add(id + ". " + tytul + " - " + autor);
                    } while (c2.moveToNext());
                }
                c2.close();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, wyniki);
                list.setAdapter(adapter);
            }
        });
    }
}