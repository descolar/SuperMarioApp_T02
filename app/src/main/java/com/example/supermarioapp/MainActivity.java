package com.example.supermarioapp;

import android.os.Bundle;

// Importamos las clases necesarias para trabajar con actividades y configuraciones visuales
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Habilitamos el modo Edge-to-Edge para que la interfaz ocupe toda la pantalla
        EdgeToEdge.enable(this);

        // Configuramos el archivo de diseño que muestra el RecyclerView en pantalla completa
        setContentView(R.layout.activity_main);

        // Ajustamos los márgenes del contenido para adaptarlo a las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Creamos la lista de personajes con nombre e imagen
        List<Personaje> personajes = Arrays.asList(
                new Personaje("Mario", R.drawable.mario),
                new Personaje("Luigi", R.drawable.luigi),
                new Personaje("Peach", R.drawable.peach),
                new Personaje("Toad", R.drawable.toad)
        );

        // Encontramos el RecyclerView en el diseño
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Configuramos el RecyclerView para mostrar los elementos en forma de lista vertical
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Creamos el adapter usando la lista de personajes y lo asignamos al RecyclerView
        PersonajeAdapter adapter = new PersonajeAdapter(personajes, this);
        recyclerView.setAdapter(adapter);
    }
}
