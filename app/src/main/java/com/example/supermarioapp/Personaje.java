package com.example.supermarioapp;

/**
 * La clase Personaje representa a un personaje del mundo de Super Mario,
 * incluyendo su nombre, una imagen, una descripción y sus habilidades especiales.
 */
public class Personaje {
    private String nombre;         // Nombre del personaje
    private int imagenResId;       // ID del recurso de la imagen del personaje
    private String descripcion;    // Descripción del personaje
    private String habilidades;    // Habilidades especiales del personaje

    /**
     * Constructor de la clase Personaje.
     *
     * @param nombre      El nombre del personaje.
     * @param imagenResId El ID del recurso de la imagen para mostrar el personaje.
     * @param descripcion Una breve descripción del personaje.
     * @param habilidades Las habilidades o características especiales del personaje.
     */
    public Personaje(String nombre, int imagenResId, String descripcion, String habilidades) {
        this.nombre = nombre;
        this.imagenResId = imagenResId;
        this.descripcion = descripcion;
        this.habilidades = habilidades;
    }

    /**
     * Método para obtener el nombre del personaje.
     *
     * @return El nombre del personaje.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener el ID de la imagen del personaje.
     *
     * @return El ID del recurso de la imagen.
     */
    public int getImagenResId() {
        return imagenResId;
    }

    /**
     * Método para obtener la descripción del personaje.
     *
     * @return La descripción del personaje.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método para obtener las habilidades del personaje.
     *
     * @return Las habilidades especiales del personaje.
     */
    public String getHabilidades() {
        return habilidades;
    }
}
