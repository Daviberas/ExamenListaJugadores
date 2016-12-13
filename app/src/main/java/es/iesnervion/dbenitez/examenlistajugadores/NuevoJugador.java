package es.iesnervion.dbenitez.examenlistajugadores;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;

import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;

public class NuevoJugador extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

    private EditText nombre;
    private ImageView foto;
    private RadioButton base;
    private RadioButton escolta;
    private RadioButton alero;
    private RadioButton alaPivot;
    private RadioButton pivot;
    private String posicion;
    private Spinner spinAltura;
    private String altura;
    private Spinner spinPeso;
    private String peso;
    private Jugadores arrays;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_jugador);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(arrays == null)
            arrays = new Jugadores();

        nombre = (EditText) findViewById(R.id.editNombre);
        foto = (ImageView) findViewById(R.id.foto);
        base = (RadioButton) findViewById(R.id.base);
        escolta = (RadioButton) findViewById(R.id.escolta);
        alero = (RadioButton) findViewById(R.id.alero);
        alaPivot = (RadioButton) findViewById(R.id.ala_pivot);
        pivot = (RadioButton) findViewById(R.id.pivot);
        spinAltura = (Spinner) findViewById(R.id.spinnerAltura);
        spinPeso = (Spinner) findViewById(R.id.spinnerPeso);

        if(arrays.contarJugadoresEnPosicion((String)base.getText())>=2)
        {
            base.setClickable(false);
        }

        if(arrays.contarJugadoresEnPosicion((String)escolta.getText())>=2)
        {
            escolta.setClickable(false);
        }

        if(arrays.contarJugadoresEnPosicion((String)alero.getText())>=2)
        {
            alero.setClickable(false);
        }

        if(arrays.contarJugadoresEnPosicion((String)alaPivot.getText())>=2)
        {
            alaPivot.setClickable(false);
        }

        if(arrays.contarJugadoresEnPosicion((String)pivot.getText())>=2)
        {
            pivot.setClickable(false);
        }

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.spinner_item_altura,R.id.altura,arrays.alturas);
        adapter.setDropDownViewResource(R.layout.spinner_item_altura);
        spinAltura.setAdapter(adapter);

        adapter = new ArrayAdapter(this,R.layout.spinner_item_peso,R.id.peso,arrays.pesos);
        adapter.setDropDownViewResource(R.layout.spinner_item_peso);
        spinPeso.setAdapter(adapter);

        foto.setOnClickListener(this);
        base.setOnCheckedChangeListener(this);
        escolta.setOnCheckedChangeListener(this);
        alero.setOnCheckedChangeListener(this);
        alaPivot.setOnCheckedChangeListener(this);
        pivot.setOnCheckedChangeListener(this);

        spinAltura.setOnItemSelectedListener(this);
        spinPeso.setOnItemSelectedListener(this);

        FloatingActionButton guardarJugador = (FloatingActionButton) findViewById(R.id.guardarJugador);
        guardarJugador.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Jugador nuevo = new Jugador(nombre.getText().toString(),peso,altura,R.drawable.silueta,posicion);

                arrays.jugadores.addElement(nuevo);

                Intent intent = new Intent(view.getContext(),ListaJugadores.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v)
    {
        //No me da tiempo a hacer el GridView
        Intent intent = new Intent(v.getContext(), Galeria.class);
        startActivity(intent);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        switch (buttonView.getId())
        {
            case R.id.base:
                if (isChecked==true)
                {
                    posicion = (String) buttonView.getText();
                    escolta.setChecked(false);
                    alero.setChecked(false);
                    alaPivot.setChecked(false);
                    pivot.setChecked(false);
                }
                break;
            case R.id.escolta:
                if (isChecked==true)
                {
                    posicion = (String) buttonView.getText();
                    base.setChecked(false);
                    alero.setChecked(false);
                    alaPivot.setChecked(false);
                    pivot.setChecked(false);
                }
                break;
            case R.id.alero:
                if (isChecked==true)
                {
                    posicion = (String) buttonView.getText();
                    escolta.setChecked(false);
                    base.setChecked(false);
                    alaPivot.setChecked(false);
                    pivot.setChecked(false);
                }
                break;
            case R.id.ala_pivot:
                if (isChecked==true)
                {
                    posicion = (String) buttonView.getText();
                    escolta.setChecked(false);
                    alero.setChecked(false);
                    base.setChecked(false);
                    pivot.setChecked(false);
                }
                break;
            case R.id.pivot:
                if (isChecked==true)
                {
                    posicion = (String) buttonView.getText();
                    escolta.setChecked(false);
                    alero.setChecked(false);
                    alaPivot.setChecked(false);
                    base.setChecked(false);
                }
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        switch (view.getId())
        {
            case R.id.item_altura:
                altura = arrays.alturas.get(position);
                break;
            case R.id.item_peso:
                peso = arrays.pesos.get(position);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
        altura = arrays.alturas.get(0);
        peso = arrays.pesos.get(0);
    }
}
