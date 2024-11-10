package com.example.supermarioapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configura el Toolbar como ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Ajusta el diseño a las barras del sistema (modo Edge-to-Edge)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Detecta el idioma local y muestra la bandera correspondiente
        String language = Locale.getDefault().getLanguage();
        ImageView iconFlag = findViewById(R.id.icon_flag);
        if (language.equals("es")) {
            iconFlag.setImageResource(R.drawable.sp); // Muestra bandera de España si el idioma es español
        } else {
            iconFlag.setImageResource(R.drawable.uk); // Muestra bandera de Reino Unido si el idioma no es español
        }

        // Configuración de lista de personajes
        List<Personaje> personajes = Arrays.asList(
                new Personaje("Mario", R.drawable.mario, getString(R.string.mario_description), getString(R.string.mario_abilities)),
                new Personaje("Luigi", R.drawable.luigi, getString(R.string.luigi_description), getString(R.string.luigi_abilities)),
                new Personaje("Peach", R.drawable.peach, getString(R.string.peach_description), getString(R.string.peach_abilities)),
                new Personaje("Toad", R.drawable.toad, getString(R.string.toad_description), getString(R.string.toad_abilities))
        );


        // RecyclerView con configuración de Layout y Adapter
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PersonajeAdapter adapter = new PersonajeAdapter(personajes, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu); // Infla el menú con la opción "Acerca de..."
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Acerca de...")
                    .setMessage("Aplicación desarrollada por [tu nombre]. Versión 1.0")
                    .setIcon(R.drawable.ic_launcher_foreground)
                    .setPositiveButton("OK", (dialog, id) -> dialog.dismiss())
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
