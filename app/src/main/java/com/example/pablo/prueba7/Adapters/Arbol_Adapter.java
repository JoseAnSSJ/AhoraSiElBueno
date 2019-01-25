package com.example.pablo.prueba7.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetMuestraArbolServiciosAparatosPorinstalarListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraMedioPorServicoContratadoListResult;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;
import com.example.pablo.prueba7.asignacion;

import java.util.Iterator;
import java.util.List;

public class Arbol_Adapter extends BaseAdapter {

    LayoutInflater inflater;
    Context mcontext;
    public static int clv_unicaNet, clv_Medio, posi;
    public String dato;
    Array array = new Array();
    Request request = new Request();

    public Arbol_Adapter (Context context){
        mcontext=context;
        inflater = LayoutInflater.from(mcontext);
    }

    public class viewHolder{
        TextView nombre;
        Button medio;


    }

    @Override
    public int getCount() {
        return Array.nombreArbol.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final viewHolder holder;
        if (convertView == null) {
            holder = new viewHolder();

            convertView=inflater.inflate(R.layout.activity_aparato_asignado_medio_list,null);

            holder.nombre=(TextView)convertView.findViewById(R.id.textservicio);
            holder.medio=(Button)convertView.findViewById(R.id.medio);


            convertView.setTag(holder);
        }
        else {
            holder=(viewHolder)convertView.getTag();
        }

        holder.nombre.setText(Array.nombreArbol.get(position));
        ////////////////////
        asignacion.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.nombre.setText(array.nombreArbol.get(position));
                holder.medio.setVisibility(View.VISIBLE);
                clv_Medio = 0;
                clv_unicaNet = 0;
            }
        });

        final int[] m = {1};
        holder.nombre.setText(array.nombreArbol.get(position));


        holder.medio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext, "Bienvenido" + position, Toast.LENGTH_LONG).show();
                /////
                Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData = array.dataArbSer.iterator();
                List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat = (List<GetMuestraArbolServiciosAparatosPorinstalarListResult>) itData.next();
                clv_unicaNet = dat.get(position).getClv_UnicaNet();
                request.getMedSer(mcontext);
                posi = position;
                ////

                asignacion.layoutMedio.setVisibility(View.VISIBLE);
                //      Asignacion.setVisibility(View.GONE);
                asignacion.siguiente.setEnabled(false);


            }
        });
        asignacion.aceptarmedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 /*       if (m[0] == 1) {
                            Toast.makeText(getApplicationContext(), "Debe de llenar el campo 'Medio'", Toast.LENGTH_LONG).show();
                        } else {*/

                Iterator<List<GetMuestraMedioPorServicoContratadoListResult>> itData = array.dataMedSer.iterator();
                List<GetMuestraMedioPorServicoContratadoListResult> dat = (List<GetMuestraMedioPorServicoContratadoListResult>) itData.next();
                clv_Medio = dat.get(position - 1).getIdMedio();
                asignacion.layoutMedio.setVisibility(View.GONE);
                asignacion.Asignacion.setVisibility(View.VISIBLE);
                asignacion.siguiente.setEnabled(true);
                //////
                holder.medio.setVisibility(View.GONE);
                holder.nombre.setText(array.nombreArbol.get(posi) + " (" + dato + ")");


                /////

                //}
            }
        });
        asignacion.cancelarmedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  nombre.setText(array.nombreArbol.get(posi));
                asignacion.layoutMedio.setVisibility(View.GONE);
                asignacion.Asignacion.setVisibility(View.VISIBLE);
                asignacion.siguiente.setEnabled(true);
            }
        });
        asignacion.spinnerMedio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        ////////////////////////
        return convertView;
    }
}
