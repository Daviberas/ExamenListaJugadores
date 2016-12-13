package es.iesnervion.dbenitez.examenlistajugadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterIcono<T> extends ArrayAdapter<T>
{
    private Jugadores arrays = new Jugadores();
    public AdapterIcono(Context c, int resourceId, int textId, T[] objects)
    {
        super(c, resourceId, textId, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;
        ViewHolder holder;

        if (row==null)
        {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );

            row = inflater.inflate(R.layout.row, parent, false);

            TextView nombre = (TextView) row.findViewById(R.id.nombre);
            ImageView iv = (ImageView) row.findViewById(R.id.img);
            TextView altura = (TextView) row.findViewById(R.id.alturaJugador);
            TextView peso = (TextView) row.findViewById(R.id.pesoJugador);
            TextView posicion = (TextView) row.findViewById(R.id.posicionJugador);

            holder = new ViewHolder (nombre,iv,altura,peso,posicion);
            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }

        holder.getNombre().setText(arrays.jugadores.get(position).getNombre());
        holder.getIv().setImageResource(arrays.jugadores.get(position).getFoto());
        holder.getAltura().setText(arrays.jugadores.get(position).getAltura());
        holder.getPeso().setText(arrays.jugadores.get(position).getPeso());
        holder.getPoscicion().setText(arrays.jugadores.get(position).getPosicion());

        return (row);
    }
}
