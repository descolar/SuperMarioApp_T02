package com.example.supermarioapp;

public class Personaje {
    private String nombre;
    private int imagenResId;
    private String descripcion;
    private String habilidades;

    public Personaje(String nombre, int imagenResId, String descripcion, String habilidades) {
        this.nombre = nombre;
        this.imagenResId = imagenResId;
        this.descripcion = descripcion;
        this.habilidades = habilidades;
    }

    // Métodos getter para acceder a los atributos
    public String getNombre() {
        return nombre;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getHabilidades() {
        return habilidades;
    }
}

