package com.example.supermarioapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

/**
 * SettingsActivity permite al usuario cambiar el idioma de la aplicación.
 * Guarda la preferencia en SharedPreferences y actualiza el idioma en toda la aplicación.
 */
public class SettingsActivity extends AppCompatActivity {

    private Switch switchLanguage;
    private SharedPreferences sharedPreferences;
    private static final String LANGUAGE_PREF = "language_pref"; // Clave para almacenar el idioma

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configurar idioma de acuerdo a la preferencia del usuario o el idioma del sistema
        sharedPreferences = getSharedPreferences("app_settings", MODE_PRIVATE);
        String language = sharedPreferences.getString(LANGUAGE_PREF, Locale.getDefault().getLanguage());
        setLocale(language);

        setContentView(R.layout.activity_settings);

        // Inicializamos el Switch y actualizamos el texto en función del idioma
        switchLanguage = findViewById(R.id.switch_language);
        switchLanguage.setChecked(language.equals("en"));
        switchLanguage.setText(getString(R.string.change_language));

        // Cambiamos el idioma cuando el usuario active/desactive el Switch
        switchLanguage.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String selectedLanguage = isChecked ? "en" : "es";
            setLanguage(selectedLanguage);

            // Actualizar el texto del switch después de cambiar el idioma
            switchLanguage.setText(getString(R.string.change_language));

            // Reiniciar la actividad principal para aplicar el cambio en toda la aplicación
            restartMainActivity();
        });
    }

    /**
     * Cambia el idioma de la aplicación y guarda la preferencia en SharedPreferences.
     *
     * @param languageCode Código del idioma ("en" o "es").
     */
    private void setLanguage(String languageCode) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LANGUAGE_PREF, languageCode);
        editor.apply();
        setLocale(languageCode);
    }

    /**
     * Configura el idioma en la aplicación.
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
     * Reinicia la actividad principal para aplicar el nuevo idioma en toda la aplicación.
     */
    private void restartMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); // Finaliza SettingsActivity para regresar a MainActivity
    }
}
