package com.example.pablo.prueba7;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pablo.prueba7.Adapters.Arbol_Adapter;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetMuestraArbolServiciosAparatosPorinstalarListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraMedioPorServicoContratadoListResult;
import com.example.pablo.prueba7.Request.Request;

import java.util.Iterator;
import java.util.List;


public class asignacion extends AppCompatActivity {
Array array = new Array();
Request request = new Request();
    public static Button siguiente, eliminar;
    public static  Button aceptarmedio,cancelarmedio;
    public static ListView Asignacion;
    public static Spinner spinnerMedio;
    public static RelativeLayout layoutMedio;
Arbol_Adapter adapter;


    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_asignacion);
        siguiente= findViewById(R.id.siguiente);
        Asignacion = findViewById(R.id.Asignacion);
        eliminar = findViewById(R.id.eliminar);
        aceptarmedio = findViewById(R.id.aceptarMedio);
        cancelarmedio = findViewById(R.id.cancelarMedio);
        spinnerMedio = findViewById(R.id.spinnerMedio);
        layoutMedio = findViewById(R.id.poiuyt);



        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento=new Intent(asignacion.this,asignado.class);
                startActivity(intento);
            }
        });



         adapter = new Arbol_Adapter(asignacion.this);
        Asignacion.setAdapter(adapter);



    }

    }
