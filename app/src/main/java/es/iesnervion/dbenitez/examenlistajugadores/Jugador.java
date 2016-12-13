package es.iesnervion.dbenitez.examenlistajugadores;

import android.os.Parcel;
import android.os.Parcelable;

public class Jugador implements Parcelable
{
    private String nombre;
    private String peso;
    private String altura;
    private int foto;
    private String posicion;

    public Jugador(String nombre, String peso, String altura, int foto, String posicion)
    {
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
        this.foto = foto;
        this.posicion = posicion;
    }

    protected Jugador(Parcel in)
    {
        nombre = in.readString();
        peso = in.readString();
        altura = in.readString();
        foto = in.readInt();
        posicion = in.readString();
    }

    public static final Creator<Jugador> CREATOR = new Creator<Jugador>()
    {
        @Override
        public Jugador createFromParcel(Parcel in)
        {
            return new Jugador(in);
        }

        @Override
        public Jugador[] newArray(int size)
        {
            return new Jugador[size];
        }
    };

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getPeso()
    {
        return peso;
    }

    public void setPeso(String peso)
    {
        this.peso = peso;
    }

    public String getAltura()
    {
        return altura;
    }

    public void setAltura(String altura)
    {
        this.altura = altura;
    }

    public int getFoto()
    {
        return foto;
    }

    public void setFoto(int foto)
    {
        this.foto = foto;
    }

    public String getPosicion()
    {
        return posicion;
    }

    public void setPosicion(String posicion)
    {
        this.posicion = posicion;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(nombre);
        dest.writeString(peso);
        dest.writeString(altura);
        dest.writeInt(foto);
        dest.writeString(posicion);
    }
}
