package com.example.supermarioapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * MainActivity es la actividad principal de nuestra aplicación de Super Mario.
 * Configura la interfaz, incluyendo un menú lateral y un RecyclerView con personajes de Mario.
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ImageView iconFlag;
    private SharedPreferences sharedPreferences;

    /**
     * Método que se ejecuta cuando la actividad se crea.
     * Configura el contenido de la pantalla, incluyendo el toolbar, el drawer y el RecyclerView
     * con los personajes de Mario.
     *
     * @param savedInstanceState Guarda el estado de la actividad en caso de ser destruida y recreada.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configurar idioma de acuerdo a la preferencia del usuario o el idioma del sistema
        sharedPreferences = getSharedPreferences("app_settings", MODE_PRIVATE);
        String language = sharedPreferences.getString("language_pref", Locale.getDefault().getLanguage());
        setLocale(language);

        setContentView(R.layout.activity_main);

        // Configuramos el Toolbar como la barra de herramientas principal de la app
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Configuramos el DrawerLayout y el NavigationView para el menú lateral
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Añadimos el icono de hamburguesa en el Toolbar para abrir y cerrar el DrawerLayout
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Configuramos la bandera de idioma según el idioma guardado
        iconFlag = findViewById(R.id.icon_flag);
        setFlagIcon();

        // Mostramos un mensaje de bienvenida en la parte inferior de la pantalla
        Snackbar.make(findViewById(R.id.recyclerView), getString(R.string.welcome_message), Snackbar.LENGTH_LONG).show();

        // Configuramos la lista de personajes de Mario en el RecyclerView
        List<Personaje> personajes = Arrays.asList(
                new Personaje("Mario", R.drawable.mario, getString(R.string.mario_description), getString(R.string.mario_abilities)),
                new Personaje("Luigi", R.drawable.luigi, getString(R.string.luigi_description), getString(R.string.luigi_abilities)),
                new Personaje("Peach", R.drawable.peach, getString(R.string.peach_description), getString(R.string.peach_abilities)),
                new Personaje("Toad", R.drawable.toad, getString(R.string.toad_description), getString(R.string.toad_abilities))
        );

        // Configuramos el RecyclerView con un adaptador para mostrar la lista de personajes
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PersonajeAdapter(personajes, this));
    }

    /**
     * Configura el ícono de la bandera en función del idioma actual.
     * Muestra la bandera de España si el idioma es español y la del Reino Unido si es inglés.
     */
    private void setFlagIcon() {
        String language = Locale.getDefault().getLanguage();
        if (language.equals("es")) {
            iconFlag.setImageResource(R.drawable.flag_sp);
        } else {
            iconFlag.setImageResource(R.drawable.flag_uk);
        }
    }

    /**
     * Configura el idioma de la aplicación.
     *
     * @param languageCode Código del idioma (por ejemplo, "es" o "en").
     */
    private void setLocale(String languageCode) {
        Locale newLocale = new Locale(languageCode);
        Locale.setDefault(newLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.setLocale(newLocale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }

    /**
     * Crea el menú en la barra de herramientas con opciones como "Acerca de...".
     *
     * @param menu El menú de opciones de la actividad.
     * @return true si el menú se ha creado correctamente.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            // Crear y mostrar el diálogo de "About"
            new AlertDialog.Builder(this)
                    .setTitle(R.string.about_dialog_title)
                    .setMessage(R.string.about_dialog_message)
                    .setIcon(R.drawable.logo)
                    .setPositiveButton(R.string.ok_button, null)
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Maneja las selecciones en el menú lateral (Drawer).
     * Las opciones incluyen "Inicio" para cerrar el menú y permanecer en la pantalla principal,
     * "Ajustes" para acceder a la pantalla de configuración, y "Idioma" para cambiar el idioma.
     *
     * @param item El ítem del menú lateral seleccionado.
     * @return true si la selección se ha manejado correctamente.
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.action_home) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (itemId == R.id.nav_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);
        }

        return true;
    }

    /**
     * Al volver a la actividad, actualiza el idioma y la bandera.
     */
    @Override
    protected void onResume() {
        super.onResume();
        setFlagIcon();
    }

    /**
     * Al presionar el botón de retroceso, cierra el menú lateral si está abierto.
     * Si no, actúa como el botón de retroceso normal.
     */
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
