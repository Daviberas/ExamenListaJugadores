package es.iesnervion.dbenitez.examenlistajugadores;


import java.util.Vector;

public class Jugadores
{
    public static Vector<Jugador> jugadores =new Vector<Jugador>(0,1);

    public Vector<String> alturas;

    public Vector<String> pesos;

    public int[] imagenes = {R.drawable.jugador00, R.drawable.jugador01, R.drawable.jugador02,
            R.drawable.jugador03,R.drawable.jugador04,R.drawable.jugador05,R.drawable.jugador06,
            R.drawable.jugador07,R.drawable.jugador08,R.drawable.jugador09,R.drawable.jugador10,
            R.drawable.jugador11,R.drawable.jugador12,R.drawable.jugador13,R.drawable.jugador14,
            R.drawable.jugador15,R.drawable.jugador16,R.drawable.jugador17,R.drawable.jugador18,
            R.drawable.jugador19,R.drawable.jugador20,R.drawable.jugador21,R.drawable.jugador22,
            R.drawable.jugador23,R.drawable.jugador24};

    public Jugadores()
    {
        alturas = new Vector<String>(0,1);
        pesos = new Vector<String>(0,1);

        for(int i = 45; i<=250; i++)
        {
            if(i>=150 && i<=250)
            {
                alturas.add(i+" cms");
            }
            pesos.add(i+" Kgs");
        }
    }

    public int contarJugadoresEnPosicion(String posicion)
    {
        int contador = 0;
        for(int i = 0; i<jugadores.size();i++)
        {
            if (jugadores.get(i).getPosicion().equals(posicion))
            {
                contador++;
            }
        }
        return contador;
    }
}
