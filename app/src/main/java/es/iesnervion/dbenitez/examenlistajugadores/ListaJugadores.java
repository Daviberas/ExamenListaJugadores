package es.iesnervion.dbenitez.examenlistajugadores;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import static java.security.AccessController.getContext;

public class ListaJugadores extends AppCompatActivity implements OnListadoJugadorSelectedListener
{
    private ListView lista;
    private Jugadores arrays;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_jugadores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(arrays == null)
            arrays = new Jugadores();

        lista = (ListView) findViewById(R.id.listaJugadores);

        lista.setAdapter(new AdapterIcono(this,R.layout.row,R.id.nombre,Jugadores.jugadores.toArray()));

        FloatingActionButton nuevoJugador = (FloatingActionButton) findViewById(R.id.nuevoJugador);
        nuevoJugador.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(view.getContext(), NuevoJugador.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_jugadores, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onJugadorSelected(int position)
    {
        //No me da tiempo a hacer el menú ni la edición borrado de elementos
    }
}
