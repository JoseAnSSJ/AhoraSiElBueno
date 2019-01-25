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

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetMuestraArbolServiciosAparatosPorinstalarListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraMedioPorServicoContratadoListResult;
import com.example.pablo.prueba7.Request.Request;

import java.util.Iterator;
import java.util.List;


public class asignacion extends AppCompatActivity {
Array array = new Array();
Request request = new Request();
    Button siguiente, eliminar;
    public static  Button aceptarmedio,cancelarmedio;
    ListView Asignacion;
    public static Spinner spinnerMedio;
    public static int clv_unicaNet, clv_Medio, posi;
    public String dato;



    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_asignacion);
        siguiente= findViewById(R.id.siguiente);
        Asignacion = findViewById(R.id.Asignacion);
        eliminar = findViewById(R.id.eliminar);




        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento=new Intent(asignacion.this,asignado.class);
                startActivity(intento);
            }
        });


            final AsignacionAdapter adapter = new AsignacionAdapter();
            Asignacion.setAdapter(adapter);
            Asignacion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });



    }
    class AsignacionAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return array.nombreArbol.size();
        }

        @Override
        public Object getItem(int position) {
            return array.nombreArbol.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView==null) {
                convertView = getLayoutInflater().inflate(R.layout.activity_aparato_asignado_medio_list, null);

            }else {

            }

                final TextView nombre = convertView.findViewById(R.id.textservicio);
                final Button medio = convertView.findViewById(R.id.medio);
            Button aceptarmedio = findViewById(R.id.aceptarMedio);
            Button cancelarmedio = findViewById(R.id.cancelarMedio);
                spinnerMedio = findViewById(R.id.spinnerMedio);
                final CheckBox check = convertView.findViewById(R.id.chek);


                eliminar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nombre.setText(array.nombreArbol.get(position));
                        medio.setVisibility(View.VISIBLE);
                        clv_Medio = 0;
                        clv_unicaNet = 0;
                    }
                });

                final int[] m = {1};
                nombre.setText(array.nombreArbol.get(position));

                final RelativeLayout layoutMedio = findViewById(R.id.poiuyt);
                medio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Bienvenido" + position, Toast.LENGTH_LONG).show();
                        /////
                        Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData = array.dataArbSer.iterator();
                        List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat = (List<GetMuestraArbolServiciosAparatosPorinstalarListResult>) itData.next();
                        clv_unicaNet = dat.get(position).getClv_UnicaNet();
                        request.getMedSer(getApplicationContext());
                        posi = position;
                        ////

                        layoutMedio.setVisibility(View.VISIBLE);
                        //      Asignacion.setVisibility(View.GONE);
                        siguiente.setEnabled(false);


                    }
                });
                aceptarmedio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                 /*       if (m[0] == 1) {
                            Toast.makeText(getApplicationContext(), "Debe de llenar el campo 'Medio'", Toast.LENGTH_LONG).show();
                        } else {*/

                            Iterator<List<GetMuestraMedioPorServicoContratadoListResult>> itData = array.dataMedSer.iterator();
                            List<GetMuestraMedioPorServicoContratadoListResult> dat = (List<GetMuestraMedioPorServicoContratadoListResult>) itData.next();
                            clv_Medio = dat.get(position - 1).getIdMedio();
                            layoutMedio.setVisibility(View.GONE);
                            Asignacion.setVisibility(View.VISIBLE);
                            siguiente.setEnabled(true);
                            //////
                            medio.setVisibility(View.GONE);
                            nombre.setText(array.nombreArbol.get(posi) + " (" + dato + ")");


                            /////

                        //}
                    }
                });
                cancelarmedio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //  nombre.setText(array.nombreArbol.get(posi));
                        layoutMedio.setVisibility(View.GONE);
                        Asignacion.setVisibility(View.VISIBLE);
                        siguiente.setEnabled(true);
                    }
                });
                spinnerMedio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position != 0) {
                            m[0] = 2;
                            Iterator<List<GetMuestraMedioPorServicoContratadoListResult>> itdata = array.dataMedSer.iterator();
                            List<GetMuestraMedioPorServicoContratadoListResult> dat = itdata.next();
                            dato = dat.get(position - 1).getDescripcion();

                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });




                return convertView;
            }
        }
    }
