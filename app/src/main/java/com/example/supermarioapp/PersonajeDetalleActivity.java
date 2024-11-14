package com.example.supermarioapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

/**
 * Actividad para mostrar los detalles de un personaje seleccionado.
 * Se accede a ella al hacer clic en un personaje en la lista de la pantalla principal.
 */
public class PersonajeDetalleActivity extends AppCompatActivity {

    /**
     * Método que se ejecuta cuando la actividad se crea.
     * Configura el idioma, asigna las vistas de la interfaz y recibe los datos
     * del personaje seleccionado para mostrarlos.
     *
     * @param savedInstanceState Guarda el estado de la actividad en caso de ser destruida y recreada.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Configuramos el idioma de acuerdo a las preferencias guardadas
        SharedPreferences sharedPreferences = getSharedPreferences("app_settings", MODE_PRIVATE);
        String language = sharedPreferences.getString("language_pref", Locale.getDefault().getLanguage());
        setLocale(language);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje_detalle);

        // Configuramos el botón de retroceso para cerrar la actividad
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish());

        // Asignamos las vistas de la interfaz a variables
        ImageView imageViewDetalle = findViewById(R.id.imageViewDetalle);
        TextView textViewNombreDetalle = findViewById(R.id.textViewNombreDetalle);
        TextView textViewDescripcion = findViewById(R.id.textViewDescripcion);
        TextView textViewHabilidades = findViewById(R.id.textViewHabilidades);

        // Obtenemos el Intent con los datos del personaje
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        int imagenResId = intent.getIntExtra("imagen", -1);
        String descripcion = intent.getStringExtra("descripcion");
        String habilidades = intent.getStringExtra("habilidades");

        // Asignamos los datos del personaje a las vistas
        textViewNombreDetalle.setText(nombre);
        imageViewDetalle.setImageResource(imagenResId);
        textViewDescripcion.setText(descripcion);
        textViewHabilidades.setText(habilidades);
    }

    /**
     * Cambia el idioma de la aplicación según la configuración de preferencias.
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
}
