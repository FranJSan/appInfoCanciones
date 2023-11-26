package sanchezfernandez.franciscojose.tarea05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Tarea 05.
 *
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener, View.OnCreateContextMenuListener {

    private ListView listView;
    private ArrayList<Cancion> listaCanciones = new ArrayList<>();

    // con este int controlo que item de la ListView es la que está lanzando el menú que será el item
    // sobre el que se mostrará la información.
    private int positionLv;

    /**
     * En el método onCreate inicializo las View y variables que se necesitan.
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lvCanciones);
        crearCanciones();

        Adaptador adaptador = new Adaptador(this, listaCanciones);
        listView.setAdapter(adaptador);

        // Implemento las interfaces para extraer el método.
        listView.setOnItemLongClickListener(this);
        listView.setOnCreateContextMenuListener(this);
    }

    /**
     * Método que se lanza para crear el menú.
     * @param menu The context menu that is being built
     * @param v The view for which the context menu is being built
     * @param menuInfo Extra information about the item for which the
     *            context menu should be shown. This information will vary
     *            depending on the class of v.
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu_item, menu);
    }

    /**
     * Controlador del evento de pulsación larga sobre los items. Muestra el menú contextual sobre
     * el item de la list view y se guarda la referencia del item en positionLv.
     *
     * @param parent The AbsListView where the click happened
     * @param view The view within the AbsListView that was clicked
     * @param position The position of the view in the list
     * @param id The row id of the item that was clicked
     *
     * @return
     */
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        listView.showContextMenu();
        positionLv = position;
        return true;
    }


    /**
     * Este método se le llama al seleccionar un item del menú contextual. Se comprueba que item ha
     * sido pulsado y se ejecuta la acción determinada.
     * @param item The context menu item that was selected.
     * @return true si se gestiona la acción o false si no.
     *
     * @see this.mostrarToastInfo
     * @see this.abrirWeb
     * @see this.abrirYoutube
     */
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.item_info) {
            mostrarToastInfo();
            return true;
        } else if (item.getItemId() == R.id.item_web) {
            abrirWeb();
            return true;
        } else if(item.getItemId() == R.id.item_youtube) {
            abrirYoutube();
            return true;
        } else return super.onContextItemSelected(item);
    }

    /**
     * Método que crea y ejecuta el Intent con la información necesaria para abrir la url dirigida a
     * youtube del item seleccionado
     */
    private void abrirYoutube() {
        Cancion cancion = listaCanciones.get(positionLv);

        Intent intent = new Intent().setClass(this, WebActivity.class);
        intent.putExtra("url", cancion.getUrlYT());
        startActivity(intent);
    }
    /**
     * Método que crea y ejecuta el Intent con la información necesaria para abrir la url del item
     * seleccionado
     */
    private void abrirWeb() {
        Cancion cancion = listaCanciones.get(positionLv);

        Intent intent = new Intent().setClass(this, WebActivity.class);
        intent.putExtra("url", cancion.getUrl());
        startActivity(intent);
    }


    /**
     * Método que configura y muestra un Toast con la información de la canción seleccionada.
     */
    private void mostrarToastInfo() {
        Cancion cancion = listaCanciones.get(positionLv);

        try {
            String text = "Titulo: " + cancion.getTitulo()
                    + "\nAutor: " + cancion.getAutor()
                    + "\nDisco: " + cancion.getDisco()
                    + "\nAño: " + cancion.getYear();

            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para craer el set de 5 canciones y añadirlas a la lista.
     */
    private void crearCanciones() {
        Cancion otherside = new Cancion("Otherside", "Red Hot Chili Peppers", "Californication", "https://es.wikipedia.org/wiki/Otherside", "https://www.youtube.com/watch?v=rn_YodiJO6k", 1999, 1, R.drawable.otherside);
        Cancion antichrist = new Cancion("Antichrist for you", "Kishi Bashi", "151a", "https://en.wikipedia.org/wiki/151a", "https://www.youtube.com/watch?v=l_dGqLzOnhA", 2021, 2, R.drawable.antichrist_to_you);
        Cancion scientist = new Cancion("Scientist", "Coldplay", " A Rush of Blood to the Head", "https://es.wikipedia.org/wiki/The_Scientist", "https://www.youtube.com/watch?v=RB-RcX5DS5A", 2012, 3, R.drawable.scientist);
        Cancion young = new Cancion("We are young", "Fun", "Some Nights", "https://es.wikipedia.org/wiki/We_Are_Young", "https://www.youtube.com/watch?v=Sv6dMFF_yts", 2012, 4, R.drawable.we_are_young);
        Cancion nightrain = new Cancion("Nightrain", "Guns N´ Roses", "Appetite for Destruction", "https://es.wikipedia.org/wiki/Nightrain", "https://www.youtube.com/watch?v=SyhlAjQsRrA", 1987, 5, R.drawable.nightrain);

        listaCanciones.add(otherside);
        listaCanciones.add(antichrist);
        listaCanciones.add(scientist);
        listaCanciones.add(young);
        listaCanciones.add(nightrain);
    }
}