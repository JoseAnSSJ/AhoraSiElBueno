package com.example.pablo.prueba7.Adapters;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
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

import static com.example.pablo.prueba7.Adapters.Arbol_Adapter.viewHolder.medio;
import static com.example.pablo.prueba7.asignacion.Asignacion;
import static com.example.pablo.prueba7.asignacion.aceptarmedio;
import static com.example.pablo.prueba7.asignacion.layoutMedio;
import static com.example.pablo.prueba7.asignacion.siguiente;

public class Arbol_Adapter extends BaseAdapter {
    Request request = new Request();
    LayoutInflater inflater;
    Context mcontext;
    public static int clv_unicaNet, clv_Medio, posi;
    public static String dato;
    Array array = new Array();
    public static int a=0, ciclo;

    Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData = array.dataArbSer.iterator();
    List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat = itData.next();

    public Arbol_Adapter (Context context){
        mcontext=context;
        inflater = LayoutInflater.from(mcontext);
    }

    public static class viewHolder{
        public static TextView nombre, servicio;
        public static Button medio;


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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final viewHolder holder;



            holder = new viewHolder();

            convertView=inflater.inflate(R.layout.activity_aparato_asignado_medio_list,null);

            holder.nombre=convertView.findViewById(R.id.textservicio);
      //  holder.servicio=convertView.findViewById(R.id.textservicioasig);
            holder.medio=convertView.findViewById(R.id.medio);


            convertView.setTag(holder);


        ///////////////

        ///////////////

            if(dat.get(position).getIdMedio()==0){
                holder.nombre.setText(array.nombreArbol.get(position));
            }else{

                holder.nombre.setText(dat.get(position).getNombre()+" ("+dat.get(position).getDetalle()+")");
                holder.medio.setVisibility(View.INVISIBLE);
                a=a+1;
            }if(dat.get(position).children.size()==0){
              //  holder.servicio.setVisibility(View.INVISIBLE);
           }else{
            for(ciclo=0; ciclo<1;ciclo++)
            holder.nombre.setText(holder.nombre.getText()+dat.get(position).children.get(ciclo).getNombre()+"("+dat.get(position).children.get(ciclo).getDetalle()+")");
            if(ciclo==1){
                for(int c=1; c<dat.get(position).children.size();c++){
                    holder.nombre.setText(holder.nombre.getText()+dat.get(position).children.get(c).getNombre()+"("+dat.get(position).children.get(ciclo).getDetalle()+")");
                }
            }
        }
            if(a>=dat.size()){
            asignacion.siguiente.setEnabled(true);
        }else{
            asignacion.siguiente.setEnabled(false);
        }

        ////////////////////
        asignacion.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.medio.setVisibility(View.VISIBLE);
                clv_Medio = 0;
                clv_unicaNet = 0;
            }
        });

        final int[] m = {1};
        ////////////////////////////////

        holder.medio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData1 = array.dataArbSer.iterator();
                List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat1 =  itData1.next();
                clv_unicaNet = dat1.get(position).getClv_UnicaNet();



                request.getMedSer(mcontext);
                posi = position;
                ////
                layoutMedio.setVisibility(View.VISIBLE);
                 Asignacion.setVisibility(View.GONE);
                siguiente.setEnabled(false);


            }
        });
        aceptarmedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (m[0] == 1) {
                    Toast.makeText(mcontext, "Debe de llenar el campo 'Medio'", Toast.LENGTH_LONG).show();
                } else {

                    Iterator<List<GetMuestraMedioPorServicoContratadoListResult>> itData2 = array.dataMedSer.iterator();
                    List<GetMuestraMedioPorServicoContratadoListResult> dat2 = itData2.next();
                    try {
                        clv_Medio = dat2.get(position).getIdMedio();
                    } catch (Exception e) {
                        clv_Medio = dat2.get(position - 1).getIdMedio();
                    }


                    layoutMedio.setVisibility(View.GONE);
                    Asignacion.setVisibility(View.VISIBLE);
                    siguiente.setEnabled(true);
                    //////
                    medio.setVisibility(View.GONE);
                    dat.get(position).setIdMedio(clv_Medio);
                    dat.get(position).setDetalle(dato);
                    a=0;
                    Asignacion.setAdapter(Arbol_Adapter.this);


                }

            }
        });
        asignacion.cancelarmedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutMedio.setVisibility(View.GONE);
                Asignacion.setVisibility(View.VISIBLE);
                siguiente.setEnabled(true);
            }
        });
        asignacion.spinnerMedio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position1, long id) {
                if (position1 != 0) {
                    m[0] = 2;
                    Iterator<List<GetMuestraMedioPorServicoContratadoListResult>> itdata3 = array.dataMedSer.iterator();
                    List<GetMuestraMedioPorServicoContratadoListResult> dat3 = itdata3.next();
                    dato = dat3.get(position1-1).getDescripcion();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return convertView;
    }
}
