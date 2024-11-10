package com.example.supermarioapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import com.google.android.material.snackbar.Snackbar;

/**
 * MainActivity es la pantalla principal de la aplicación de Super Mario.
 * Muestra una lista de personajes de Mario en un RecyclerView y tiene una barra de herramientas (Toolbar)
 * con un menú que permite mostrar información acerca de la aplicación.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Este método se llama al iniciar la actividad.
     * Configura la interfaz de usuario, incluyendo la barra de herramientas y el RecyclerView para mostrar los personajes.
     *
     * @param savedInstanceState guarda el estado de la actividad si se reinicia después de haber sido detenida.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configuramos el Toolbar como la barra de herramientas principal de la app
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Ajuste de diseño para que la interfaz ocupe toda la pantalla y se adapte a las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Detectamos el idioma local del dispositivo y mostramos la bandera correspondiente en el ícono
        String language = Locale.getDefault().getLanguage();
        ImageView iconFlag = findViewById(R.id.icon_flag);
        if (language.equals("es")) {
            iconFlag.setImageResource(R.drawable.flag_sp); // Bandera de España si el idioma es español
        } else {
            iconFlag.setImageResource(R.drawable.flag_uk); // Bandera de Reino Unido si el idioma es otro
        }

        // Mostrar mensaje de bienvenida con Snackbar
        Snackbar.make(findViewById(R.id.recyclerView), getString(R.string.welcome_message), Snackbar.LENGTH_LONG).show();

        // Configuración de la lista de personajes para mostrar en el RecyclerView
        List<Personaje> personajes = Arrays.asList(
                new Personaje("Mario", R.drawable.mario, getString(R.string.mario_description), getString(R.string.mario_abilities)),
                new Personaje("Luigi", R.drawable.luigi, getString(R.string.luigi_description), getString(R.string.luigi_abilities)),
                new Personaje("Peach", R.drawable.peach, getString(R.string.peach_description), getString(R.string.peach_abilities)),
                new Personaje("Toad", R.drawable.toad, getString(R.string.toad_description), getString(R.string.toad_abilities))
        );

        // Configuramos el RecyclerView para mostrar la lista de personajes de forma vertical
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PersonajeAdapter adapter = new PersonajeAdapter(personajes, this);
        recyclerView.setAdapter(adapter);
    }

    /**
     * Crea el menú de opciones en la barra de herramientas.
     *
     * @param menu El menú de opciones donde se agrega el ítem "Acerca de...".
     * @return boolean Devuelve true para mostrar el menú.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu); // Agregamos el ítem "Acerca de..." al menú
        return true;
    }

    /**
     * Maneja las selecciones en el menú de opciones.
     * Al seleccionar "Acerca de...", se muestra un cuadro de diálogo con información sobre la app.
     *
     * @param item El ítem del menú que ha sido seleccionado.
     * @return boolean Devuelve true si la acción fue manejada.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_about) { // Verificamos si se seleccionó "Acerca de..."
            // Mostramos un cuadro de diálogo con la información "Acerca de..."
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Acerca de...")
                    .setMessage("Aplicación desarrollada por David Escolar Godinez. Versión 1.0")
                    .setIcon(R.drawable.ic_launcher_foreground)
                    .setPositiveButton("OK", (dialog, id) -> dialog.dismiss())
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
