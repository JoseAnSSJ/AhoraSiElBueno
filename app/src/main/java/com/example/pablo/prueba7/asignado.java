package com.example.pablo.prueba7;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.pablo.prueba7.Adapters.Servicios_Adapter;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetMuestraAparatosDisponiblesListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraTipoAparatoListResult;
import com.example.pablo.prueba7.Request.Request;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;

import static com.example.pablo.prueba7.Adapters.Arbol_Adapter.clv_Medio;
import static com.example.pablo.prueba7.Adapters.Arbol_Adapter.clv_unicaNet;

public class asignado extends AppCompatActivity {
    Button escanear, agragar;
    TextView codigo;
    String contents;
    public static ListView serviciosAparato;
    public static Spinner spinnerAparato, spinneraparatoDisponible;
    Request request = new Request();
    Array array = new Array();
    public static int idArticuloasignado;
    public static Servicios_Adapter adapter;


    @Override
    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_asignado);
        escanear = (Button) findViewById(R.id.escanear);
        codigo = (TextView) findViewById(R.id.codigo);
        spinnerAparato=findViewById(R.id.tipo_aparato);
        spinneraparatoDisponible=findViewById(R.id.aparatoDisponible);
        serviciosAparato = findViewById(R.id.Servicios123);
        agragar=findViewById(R.id.agregar);
        request.getTipoAparatos(getApplicationContext());


        agragar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento=new Intent(asignado.this,asignacion.class);
                startActivity(intento);

            }
        });


        escanear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator scanIntegrator = new IntentIntegrator(asignado.this);
                scanIntegrator.initiateScan();
            }
        });

        spinnerAparato.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    Iterator<List<GetMuestraTipoAparatoListResult>> itdata = array.dataTipoAparatos.iterator();
                    List<GetMuestraTipoAparatoListResult> dat = itdata.next();
                    idArticuloasignado = dat.get(position-1).getIdArticulo();
                    request.getAparatosDisponibles(getApplicationContext());
                    request.getServiciosAparatos(getApplicationContext());
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinneraparatoDisponible.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position1, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (scanningResult != null){
            contents = data.getStringExtra("SCAN_RESULT");
            codigo.setText(contents);
            codigo.setVisibility(TextView.VISIBLE);


        }
    }



}