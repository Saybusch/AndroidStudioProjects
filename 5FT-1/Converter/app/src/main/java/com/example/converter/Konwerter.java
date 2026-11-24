package com.example.converter;

import kotlin.text.UStringsKt;

public class Konwerter {
    String dziesietnyNaCzworkowy(long liczba){
        if(liczba == 0) return "0";
        StringBuilder ans = new StringBuilder();
        while (liczba > 0) {
            ans.insert(0, String.valueOf(liczba % 4));
            liczba /= 4;
        }
    return ans.toString();
    }
    long czworkowyNaDziesietny(String liczba){
        long ans = 0;
        for(int i = liczba.length() - 1; i >= 0; i--){
            ans = (long) (ans + (liczba.charAt(i) - '0') * (Math.pow(4, liczba.length() - 1 - i)));
        }
        return ans;
    }
}
