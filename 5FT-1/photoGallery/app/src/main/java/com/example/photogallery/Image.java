package com.example.photogallery;

public class Image {
    int id;
    String alt;
    String plik;
    int category;
    public Image(int id, String alt, String plik, int category){
        this.id = id;
        this.alt = alt;
        this.plik = plik;
        this.category = category;
    }
}
