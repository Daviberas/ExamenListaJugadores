package es.iesnervion.dbenitez.examenlistajugadores;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder
{
    TextView nombre;
    ImageView iv;
    TextView altura;
    TextView peso;
    TextView posicion;

    public ViewHolder (TextView nombre, ImageView iv, TextView altura, TextView peso,TextView posicion)
    {
        this.nombre = nombre;
        this.iv = iv;
        this.altura = altura;
        this.peso = peso;
        this.posicion = posicion;
    }

    public TextView getNombre ()
    {
        return this.nombre;
    }

    public ImageView getIv ()
    {
        return this.iv;
    }

    public TextView getAltura ()
    {
        return this.altura;
    }

    public TextView getPeso ()
    {
        return this.peso;
    }

    public TextView getPoscicion ()
    {
        return this.posicion;
    }
}
