package com.example.supermarioapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

/**
 * SettingsActivity permite al usuario cambiar el idioma de la aplicación.
 * Guarda la preferencia en SharedPreferences y actualiza el idioma y la bandera en MainActivity.
 */
public class SettingsActivity extends AppCompatActivity {
    private Switch switchLanguage;
    private SharedPreferences sharedPreferences;
    private static final String LANGUAGE_PREF = "language_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Inicializar Switch y SharedPreferences
        switchLanguage = findViewById(R.id.switch_language);
        sharedPreferences = getSharedPreferences("app_settings", MODE_PRIVATE);

        // Verificar si el idioma está guardado en SharedPreferences
        String language = sharedPreferences.getString(LANGUAGE_PREF, Locale.getDefault().getLanguage());
        setInitialLanguage(language);

        // Configurar Switch según el idioma actual
        switchLanguage.setChecked(language.equals("en"));
        updateSwitchText(language);

        // Cambiar el idioma al activar/desactivar el Switch
        switchLanguage.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String selectedLanguage = isChecked ? "en" : "es";
            setLanguage(selectedLanguage);
            updateSwitchText(selectedLanguage);
            restartApp(); // Reiniciar para aplicar cambios de idioma
        });
    }

    private void setInitialLanguage(String language) {
        if (!language.equals("en") && !language.equals("es")) {
            language = "es"; // Por defecto, usa español si no es inglés
        }
        setLanguage(language);
    }

    private void setLanguage(String languageCode) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LANGUAGE_PREF, languageCode);
        editor.apply();

        Locale newLocale = new Locale(languageCode);
        Locale.setDefault(newLocale);

        android.content.res.Configuration config = new android.content.res.Configuration();
        config.setLocale(newLocale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }

    private void updateSwitchText(String language) {
        if (language.equals("en")) {
            switchLanguage.setText("Switch to Spanish");
        } else {
            switchLanguage.setText("Cambiar a Inglés");
        }
    }

    private void restartApp() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}

