package com.example.supermarioapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
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
 * En esta clase configuramos la interfaz de usuario, incluyendo una lista de personajes de Mario
 * que se muestra en un RecyclerView y un menú lateral que permite navegar entre opciones.
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ImageView iconFlag;

    /**
     * Método que se ejecuta cuando la actividad se crea. Configura el contenido de la pantalla,
     * incluyendo el toolbar, el drawer y el RecyclerView con los personajes de Mario.
     *
     * @param savedInstanceState guarda el estado de la actividad en caso de ser destruida y recreada.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        // Detectamos el idioma local y configuramos la bandera correspondiente en la interfaz
        iconFlag = findViewById(R.id.icon_flag);
        setFlagIcon();

        // Mostramos un mensaje de bienvenida al cargar la lista de personajes
        Snackbar.make(findViewById(R.id.recyclerView), getString(R.string.welcome_message), Snackbar.LENGTH_LONG).show();

        // Configuramos la lista de personajes de Mario y la mostramos en el RecyclerView
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
     * Crea el menú en la barra de herramientas con la opción "Acerca de...".
     *
     * @param menu el menú de opciones de la actividad.
     * @return boolean true si el menú se ha creado correctamente.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Maneja la selección de ítems en el menú de la barra de herramientas.
     * Si el usuario selecciona "Acerca de...", muestra un cuadro de diálogo con información sobre la app.
     *
     * @param item el ítem del menú que ha sido seleccionado.
     * @return boolean true si la selección se ha manejado correctamente.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.about_dialog_title))
                    .setMessage(getString(R.string.about_dialog_message))
                    .setIcon(R.drawable.ic_launcher_foreground)
                    .setPositiveButton(getString(R.string.ok_button), (dialog, id) -> dialog.dismiss())
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Maneja las selecciones en el menú lateral (Drawer).
     * Las opciones incluyen "Inicio" para cerrar el menú y permanecer en la pantalla principal,
     * "Ajustes" (por implementar), e "Idioma" para cambiar el idioma y la bandera.
     *
     * @param item el ítem del menú seleccionado.
     * @return boolean true si la selección se ha manejado correctamente.
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        String itemName = getResources().getResourceEntryName(itemId);
        Log.d("MenuItem", "ID seleccionado: " + itemId + " (" + itemName + ")");

       /* switch (itemId) {
            case R.id.nav_home:
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_settings:
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_language:
                toggleLanguage();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            default:
                Log.d("MenuItem", "ID no reconocido.");
                break;
        }
        */

        return true;


    }

    /**
     * Alternamos entre los idiomas español e inglés, y actualizamos la bandera en pantalla.
     */
    private void toggleLanguage() {
        String currentLanguage = Locale.getDefault().getLanguage();
        Locale newLocale = currentLanguage.equals("es") ? Locale.ENGLISH : new Locale("es");
        Locale.setDefault(newLocale);
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
