package com.example.pablo.prueba7;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.DeepConsModel;
import com.example.pablo.prueba7.Modelos.GetBUSCADetOrdSerListResult;
import com.example.pablo.prueba7.Request.Request;


/**
 * A simple {@link Fragment} subclass.
 */
public class Trabajos extends Fragment {

    Request request = new Request();
    public Trabajos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trabajos, container, false);

        ListView trabajos = view.findViewById(R.id.listTrabajos);


        TrabajosAdapter trabadapt = new TrabajosAdapter();
        trabajos.setAdapter(trabadapt);    //Asignacion del adapatador a la listView

        return view;
    }

    ///////////////////Adaptador Trabajos//////////////////////////
    class TrabajosAdapter extends BaseAdapter {


        @Override
        public int getCount() {

            return Array.trabajox.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        public class Holder {
            TextView trabajo;
            Button accion;

        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final Holder holder = new Holder();

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_trabajos_items, null);
                holder.trabajo = convertView.findViewById(R.id.trabajov);
                holder.accion = (Button) convertView.findViewById(R.id.accionv);
            }


            holder.trabajo.setText(Array.trabajox.get(position));
            holder.accion.setText(Array.accionx.get(position));

                holder.accion.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("DESCO - Desconexión Del Servicio Principal")) {
                            Intent intento1 = new Intent(getContext(), Inicio.class);
                            startActivity(intento1);
                        }
                        if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("ISNET - Instalación de Servicio de Internet")) {
                            Intent intento = new Intent(getContext(), CambioAparato.class);
                            startActivity(intento);

                        }
                        if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("ISTVA - Instalación de Servicio de TV")) {
                            Intent intento = new Intent(getContext(), asignacion.class);
                            startActivity(intento);
                        }
                        if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("CAPAG - Cambio de tipo de aparato  FTTH")) {
                            Intent intento = new Intent(getActivity(), CambioAparato.class);
                            startActivity(intento);
                        }
                        if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("CAMDO - Cambio De Domicilio")) {
                            request.getCAMDO();
                            Intent intento = new Intent(getActivity(), CambioDom.class);
                            startActivity(intento);
                            }
                           if ((holder.trabajo.getText().toString().trim()).equalsIgnoreCase("CAPAT - Cambio De Tipo De Aparato")){
                               Intent intento = new Intent(getActivity(), CambioAparato.class);
                               startActivity(intento);

                        }
                    }



                });

                return convertView;
        }
    }
}



