package com.example.supermarioapp;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

/**
 * La clase SplashScreen representa la pantalla de inicio de la aplicación, que muestra un logo de presentación
 * y luego redirige automáticamente a la actividad principal (MainActivity) después de 2 segundos.
 */
public class SplashScreen extends AppCompatActivity {

    /**
     * Método que se ejecuta al crear la actividad. Muestra la pantalla de Splash durante un tiempo definido
     * y luego redirige automáticamente a la actividad principal.
     *
     * @param savedInstanceState Guarda el estado de la actividad en caso de ser destruida y recreada.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_splash);

        // Duración de la pantalla de Splash en milisegundos (2000 ms = 2 segundos)
        int splashDuration = 2000;

        // Inicia un Handler para retrasar la transición a MainActivity
        new Handler().postDelayed(() -> {
            // Inicia la actividad principal y finaliza la actividad SplashScreen
            startActivity(new Intent(SplashScreen.this, MainActivity.class));
            finish(); // Termina SplashScreen para que no vuelva al presionar "atrás"
        }, splashDuration); // Tiempo de espera antes de lanzar MainActivity
    }
}
