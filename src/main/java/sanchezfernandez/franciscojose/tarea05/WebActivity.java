package sanchezfernandez.franciscojose.tarea05;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Clase de activity_web. Únicamente carga la url en el WebView.
 *
 * Me ha surgido que al probarlo en mi movil, al abrir el enlace se ejecuta en mi navegador por
 * defecto, quedando una activity en negro abiera en mi aplicación, teniendo que dar atrás para
 * cerrarla. No he sido capaz de averiguar como cerrar la activity si se está usando una aplicación
 * externa.
 */
public class WebActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebView wvWiki = findViewById(R.id.wvWiki);
        String url = getIntent().getStringExtra("url");
        assert url != null;
        wvWiki.loadUrl(url);
    }
}
