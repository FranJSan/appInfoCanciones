package sanchezfernandez.franciscojose.tarea05;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Clase de activity_web. Únicamente carga la url en el WebView.
 *
 * Me ha surgido que al probarlo, al abrir el enlace se ejecuta en el navegador por defecto,
 * quedando una activity en negro (o blanca en el movil fisico) abiera en la aplicación, teniendo
 * que cerrarla manualmente. De momento, no he sido capaz de implementar como cerrar eso.
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
