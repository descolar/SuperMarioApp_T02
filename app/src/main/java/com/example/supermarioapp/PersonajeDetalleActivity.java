package com.example.supermarioapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonajeDetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje_detalle);

        ImageView imageViewDetalle = findViewById(R.id.imageViewDetalle);
        TextView textViewNombreDetalle = findViewById(R.id.textViewNombreDetalle);
        TextView textViewDescripcion = findViewById(R.id.textViewDescripcion);
        TextView textViewHabilidades = findViewById(R.id.textViewHabilidades);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        int imagenResId = intent.getIntExtra("imagen", -1);
        String descripcion = intent.getStringExtra("descripcion");
        String habilidades = intent.getStringExtra("habilidades");

        textViewNombreDetalle.setText(nombre);
        imageViewDetalle.setImageResource(imagenResId);
        textViewDescripcion.setText(descripcion);
        textViewHabilidades.setText(habilidades);
    }

}