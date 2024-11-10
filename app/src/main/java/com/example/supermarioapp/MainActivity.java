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
                new Personaje("Mario", R.drawable.mario, "El héroe principal del Reino Champiñón. Mario es muy positivo y siempre está alegre. Lo podrás reconocer por sus overoles de color azul, su gorra roja y su característico bigote.\n" +
                        "\n" +
                        "La princesa Peach lo considera su amigo de confianza, y todo el mundo los conoce a él y a su hermano Luigi por sus actos de valentía.\n" +
                        "\n" +
                        "Mario se destaca en deportes como tenis, golf, béisbol, fútbol y hasta en las carreras de karts. ¡Es bueno en todos los deportes! Es plomero de profesión, pero la verdad es que es un experto en todos los oficios.\n" +
                        "\n" +
                        "Mario utiliza su poderosa habilidad para saltar y una gran cantidad de mejoras para enfrentarse a su archienemigo, Bowser.", "Salta alto, valiente"),
                new Personaje("Luigi", R.drawable.luigi, "Hermano de Mario y héroe del Reino Champiñón. Luigi es reconocido instantáneamente por su gorra y camisa de color verde.\n" +
                        "\n" +
                        "Luigi es amable, pero un poco de nervioso, especialmente si hay fantasmas por ahí. Sin embargo, sus habilidades igualan las habilidades de Mario, así que cuando estos hermanos se unen, no hay nada que no puedan lograr.\n" +
                        "\n" +
                        "Luigi es más alto y puede saltar más alto que Mario. Si pones atención, también podrás notar que la forma de su bigote también es un poco diferente.", "Saltador y rápido"),
                new Personaje("Peach", R.drawable.peach, "La querida princesa del Reino Champiñón. Es extremadamente amable y siempre está trabajando para crear un mundo en el que todos puedan convivir juntos y felices. Su famoso vestido color rosa es encantador.\n" +
                        "\n" +
                        "La princesa Peach siempre está lista para participar en una gran variedad de deportes, y también le encanta hornear y cocinar.\n" +
                        "\n" +
                        "Ella y Mario son muy buenos amigos y siempre están dispuestos a ayudarse mutuamente cuando pueden.", "Puede flotar en el aire"),
                new Personaje("Toad", R.drawable.toad, "Residente del Reino Champiñón, trabaja al servicio de la Princesa Peach. Toad tiene manchas rojas en la cabeza, aunque otros de su especie vienen en una variedad de colores.\n" +
                        "\n" +
                        "Toad es muy alegre y leal. Hace todo lo posible por ayudar a Mario y a Luigi en sus esfuerzos por proteger el Reino Champiñón de Bowser, incluso si eso significa enfrentarse al peligro durante en el proceso.", "Rápido y ágil")
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
