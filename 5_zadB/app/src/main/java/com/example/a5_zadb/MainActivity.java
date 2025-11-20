package com.example.a5_zadb;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btn;
    TextView txt;
    int win = 0, loss = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.firstFive);
        edit2 = findViewById(R.id.secondTwo);
        btn = findViewById(R.id.btn);
        txt = findViewById(R.id.txt);
        btn.setOnClickListener(v -> {
            try{
                StringBuilder text = new StringBuilder();
                String[] firstFive = edit1.getText().toString().split(" ");
                String[] secondTwo = edit2.getText().toString().split(" ");
                HashSet<Integer> guesses1 = new HashSet<>();
                HashSet<Integer> guesses2 = new HashSet<>();
                HashSet<Integer> gamblings1 = new HashSet<>();
                HashSet<Integer> gamblings2 = new HashSet<>();
                int five = 0, two = 0;
                for(int i = 0; i < firstFive.length; i++) {
                    int number = Integer.parseInt(firstFive[i]);
                    if(number <= 50 && number > 0) guesses1.add(number);
                }
                for(int i = 0; i < secondTwo.length; i++){
                    int number = Integer.parseInt(secondTwo[i]);
                    if(number <= 10 && number > 0) guesses2.add(number);
                }
                Random random = new Random();
                for(int i = 0; i < 5; i++) gamblings1.add(random.nextInt(50)+1);
                for(int i = 0; i < 2; i++) gamblings2.add(random.nextInt(10)+1);
                if ((guesses1.size() + guesses2.size()) != 7) throw new Exception();


                text.append("Wybrane liczby:");
                for(int i:guesses1) text.append(" " + i);
                text.append(" - ");
                for(int i:guesses2) text.append(" " + i);
                text.append("\nWylosowane liczby:");
                for(int i:gamblings1) text.append(" " + i);
                text.append(" - ");
                for(int i:gamblings2) text.append(" " + i);

                for(int i:guesses1) if(gamblings1.contains(i)) five++;
                for(int i:guesses2) if(gamblings2.contains(i)) two++;

                text.append("\nStopień wygranych: ");
                String winLoss = winLevel(five, two);
                text.append(winLoss);

                if (winLoss != "No winnings") win++;
                else loss++;

                text.append("\nWygrane: " + win + "\nPrzegrane: " + loss);

                txt.setText(text);
            }
            catch (Exception e) {Toast.makeText(this, "Niepoprawne dane", Toast.LENGTH_SHORT).show();}
        });
    }
    public String winLevel(int five, int two) {
        switch (five) {
            case 5:
                switch (two) {
                    case 2:
                        return "I";
                    case 1:
                        return "II";
                    case 0:
                        return "III";
                }
            case 4:
                switch (two) {
                    case 2:
                        return "IV";
                    case 1:
                        return "V";
                    case 0:
                        return "VII";
                }
            case 3:
                switch (two) {
                    case 2:
                        return "VI";
                    case 1:
                        return "IX";
                    case 0:
                        return "X";
                }
            case 2:
                switch (two) {
                    case 2:
                        return "VIII";
                    case 1:
                        return "XII";
                    case 0:
                        return "No winnings";
                }
            case 1:
                if (two == 2) return "XI";
                else return "No winnings";
            case 0:
                return "No winnings";
            default:
                return "Error";
        }
    }
}