package com.example.supermarioapp;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.app.AppCompatActivity;

/**
 * La clase SplashScreen representa la pantalla de inicio de la aplicación, mostrando un logo de presentación
 * con efecto de desvanecimiento antes de redirigir a la actividad principal (MainActivity).
 */
public class SplashScreen extends AppCompatActivity {

    /**
     * Método que se ejecuta al crear la actividad. Configura la animación de la pantalla de presentación
     * y redirige automáticamente a la actividad principal después de un tiempo definido.
     *
     * @param savedInstanceState guarda el estado de la actividad en caso de ser destruida y recreada.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_splash);

        // Duración de la pantalla de Splash en milisegundos (3000 ms = 3 segundos)
        int splashDuration = 3000;

        // Handler que retrasa la ejecución de la animación y la transición a MainActivity
        new Handler().postDelayed(() -> {
            // Carga la animación de desvanecimiento
            Animation fadeOut = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.fade_out);
            findViewById(R.id.splash_container).startAnimation(fadeOut);

            // Escucha el fin de la animación y lanza MainActivity cuando termina
            fadeOut.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) { }

                @Override
                public void onAnimationEnd(Animation animation) {
                    // Inicia la actividad principal y finaliza SplashScreen
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                }

                @Override
                public void onAnimationRepeat(Animation animation) { }
            });

        }, splashDuration);
    }
}
