package com.example.pablo.prueba7;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;


import com.example.pablo.prueba7.Adapters.Arbol_Adapter;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetMuestraArbolServiciosAparatosPorinstalarListResult;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;



public class asignacion extends AppCompatActivity {
Array array = new Array();
    public static Button siguiente, eliminar;
    public static  Button aceptarmedio,cancelarmedio;
    public static ListView Asignacion;
    public static Spinner spinnerMedio;
    public static RelativeLayout layoutMedio;


    public static JSONArray jsonArray = new JSONArray();
    public static JSONObject jsonObject2 = new JSONObject();
    Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData = array.dataArbSer.iterator();
    List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat = itData.next();

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
                for(int a=0; a<dat.size(); a++ ){
                    try {
                        jsonObject2 = new JSONObject();
                        jsonObject2.put("Clv_UnicaNet", dat.get(a).clv_UnicaNet);
                        jsonObject2.put("idMedio", dat.get(a).idMedio);
                        jsonArray.put(a,jsonObject2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                Intent intento=new Intent(asignacion.this,asignado.class);
                startActivity(intento);
            }
        });
        Asignacion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("posision", String.valueOf(position));
            }
        });
        adapter = new Arbol_Adapter(asignacion.this);
        Asignacion.setAdapter(adapter);




    }

    }
