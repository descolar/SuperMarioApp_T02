package com.example.supermarioapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Actividad para mostrar los detalles de un personaje seleccionado.
 * Se accede a ella al hacer clic en un personaje en la lista de la pantalla principal.
 */
public class PersonajeDetalleActivity extends AppCompatActivity {

    /**
     * Método llamado cuando se crea la actividad. Configura la vista y muestra los detalles
     * del personaje que se seleccionó en la lista.
     *
     * @param savedInstanceState Si la actividad se está recreando después de haber sido destruida,
     *                           este parámetro contiene los datos que previamente guardamos en onSaveInstanceState.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje_detalle);

        // Configuramos el botón de retroceso
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish()); // Termina la actividad y vuelve a la anterior

        // Asignación de vistas de la interfaz
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

        // Mensaje Toast al seleccionar personaje
        String mensaje = getString(R.string.character_selected, nombre);
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();

        // Asignación de datos a vistas
        textViewNombreDetalle.setText(nombre);
        imageViewDetalle.setImageResource(imagenResId);
        textViewDescripcion.setText(descripcion);
        textViewHabilidades.setText(habilidades);
    }

}
