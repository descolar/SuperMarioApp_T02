package com.example.supermarioapp;

public class Personaje {
    private String nombre;
    private int imagenResId;

    public Personaje(String nombre, int imagenResId) {
        this.nombre = nombre;
        this.imagenResId = imagenResId;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagenResId() {
        return imagenResId;
    }
}

