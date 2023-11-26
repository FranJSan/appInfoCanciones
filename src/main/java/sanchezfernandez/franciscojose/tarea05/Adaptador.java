package sanchezfernandez.franciscojose.tarea05;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Clase que extiende de BaseAdapter.
 *
 */
public class Adaptador extends BaseAdapter {
    private Context context;
    private ArrayList<Cancion> listCanciones;

    public Adaptador(Context context, ArrayList<Cancion> listCanciones) {
        this.context = context;
        this.listCanciones = listCanciones;
    }

    @Override
    public int getCount() {
        return listCanciones.size();
    }

    @Override
    public Object getItem(int position) {
        return listCanciones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listCanciones.get(position).getCodigo();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.item, null);

        ImageView image = (ImageView) convertView.findViewById(R.id.ivItem);
        image.setImageResource(listCanciones.get(position).getFoto());

        return convertView;
    }
}
