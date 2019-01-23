package com.example.pablo.prueba7;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetListClienteAparatosResult;
import com.example.pablo.prueba7.Modelos.GetMuestraMedioPorServicoContratadoListResult;
import com.example.pablo.prueba7.Request.Request;

import java.util.Iterator;
import java.util.List;

public class asignacion extends AppCompatActivity {
Array array = new Array();
Request request = new Request();
    Button siguiente, btnmedio;
    ListView Asignacion;
    public static Spinner spinnerMedio;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion);
        siguiente= (Button) findViewById(R.id.siguiente);
        Asignacion = findViewById(R.id.Asignacion);
     //   btnmedio = (Button) findViewById(R.id.medio);
       // layoutMedio = findViewById(R.id.layoutmedio);



        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento=new Intent(asignacion.this,asignado.class);
                startActivity(intento);
            }
        });


            AsignacionAdapter adapter = new AsignacionAdapter();
            Asignacion.setAdapter(adapter);

    }
    class AsignacionAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return array.nombreArbol.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView==null) {

                convertView = getLayoutInflater().inflate(R.layout.activity_aparato_asignado_medio_list, null);

                final TextView nombre = convertView.findViewById(R.id.textservicio);
                final Button medio = convertView.findViewById(R.id.medio);
                Button aceptarmedio = convertView.findViewById(R.id.aceptarMedio);
                Button cancelarmedio = convertView.findViewById(R.id.cancelarMedio);
                spinnerMedio = convertView.findViewById(R.id.spinnerMedio);
                final CheckBox check = convertView.findViewById(R.id.chek);
                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, array.medio);
                spinnerMedio.setAdapter(adapter1);
                final int[] m = {1};
                nombre.setText(array.nombreArbol.get(position));
                final RelativeLayout layoutMedio = convertView.findViewById(R.id.poiuyt);
                medio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "seleccionaste" + position, Toast.LENGTH_LONG).show();
                        layoutMedio.setVisibility(View.VISIBLE);
                        medio.setVisibility(View.GONE);
                        nombre.setVisibility(View.GONE);
                        check.setVisibility(View.GONE);
                        siguiente.setEnabled(false);


                    }
                });
            aceptarmedio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (m[0] == 1) {
                        Toast.makeText(getApplicationContext(),"Debe de llenar el campo 'Medio'",Toast.LENGTH_LONG).show();
                    } else {
                        layoutMedio.setVisibility(View.GONE);
                        medio.setVisibility(View.GONE);
                        nombre.setVisibility(View.VISIBLE);
                        check.setVisibility(View.VISIBLE);
                        siguiente.setEnabled(true);

                    }
                }
            });
            cancelarmedio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nombre.setText(array.nombreArbol.get(position));
                    layoutMedio.setVisibility(View.GONE);
                    medio.setVisibility(View.VISIBLE);
                    nombre.setVisibility(View.VISIBLE);
                    check.setVisibility(View.VISIBLE);
                    siguiente.setEnabled(true);
                }
            });
            spinnerMedio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                   if(position!=0){
                       m[0] =2;
                       Iterator<List<GetMuestraMedioPorServicoContratadoListResult>> itdata = array.dataMedSer.iterator();
                    List<GetMuestraMedioPorServicoContratadoListResult> dat = itdata.next();
                       nombre.setText(nombre.getText()+" ("+dat.get(position-1).getDescripcion()+")");

                   }
                   if(position==0){
                       m[0]=1;
                       nombre.setText(array.nombreArbol.get(position));
                   }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });


            return convertView;
            }else{
                return convertView;
            }
        }
    }


}
