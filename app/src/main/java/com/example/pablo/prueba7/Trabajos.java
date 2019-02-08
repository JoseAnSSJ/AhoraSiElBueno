package com.example.pablo.prueba7;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pablo.prueba7.Adapters.trabajos_adapter_result;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Request.Request;


/**
 * A simple {@link Fragment} subclass.
 */
public class Trabajos extends Fragment{
    RelativeLayout layoutAnimado;
    Request request = new Request();
    public static TextView trabajo;
    public static Button accion;
    public static trabajos_adapter_result adaptertrabajos;
    public static ListView trabajos;
    public Trabajos() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSaveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trabajos, container, false);

       trabajos=view.findViewById(R.id.listTrabajos);


        ////////////////////////////////////////

        adaptertrabajos =new trabajos_adapter_result(getActivity().getApplicationContext(),Array.trabajox,Array.accionx);
        //trabajos.setAdapter(adaptertrabajos);    //Asignacion del adapatador a la listView

        //////////////////////////////////////////

        return view;
    }
    ///////////////////Adaptador Trabajos//////////////////////////
    public class TrabajosAdapter extends BaseAdapter{

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
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.list_trabajos_items,null);
             trabajo=(TextView)convertView.findViewById(R.id.trabajov);
            accion=(Button)convertView.findViewById(R.id.accionv);


            trabajo.setText(Array.trabajox.get(position));
            accion.setText(Array.accionx.get(position));

            accion.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if ((trabajo.getText().toString().trim()).equalsIgnoreCase("ISTVA - Instalación de Servicio de TV")) {
                        Intent intento25 = new Intent(getActivity(), asignacion.class);
                        startActivity(intento25);
                    }

                    if ((trabajo.getText().toString().trim()).equalsIgnoreCase("ISNET - Instalación de Servicio de Internet")) {
                        Intent intento = new Intent(getContext(), asignacion.class);
                        startActivity(intento);
                    }
                    if ((trabajo.getText().toString().trim()).equalsIgnoreCase("CAPAG - Cambio de tipo de aparato  FTTH")) {
                        Intent intento = new Intent(getActivity(), CambioAparato.class);
                        startActivity(intento);
                    }
                    if ((trabajo.getText().toString().trim()).equalsIgnoreCase("CAMDO - Cambio De Domicilio")) {

                        Intent intento = new Intent(getActivity(), CambioDom.class);
                        request.getCAMDO();
                        startActivity(intento);
                    }
                    if ((trabajo.getText().toString().trim()).equalsIgnoreCase("CAPAT - Cambio De Tipo De Aparato")) {
                        Intent intento = new Intent(getActivity(), CambioAparato.class);
                        startActivity(intento);

                    }
                    if ((trabajo.getText().toString().trim()).equalsIgnoreCase("CONEX - Contratación De Extensión")) {
                        Intent intento = new Intent(getActivity(), asignacion.class);
                        accion.setEnabled(false);
                        accion.setText("---");
                        startActivity(intento);

                    }


                    if ((accion.getText().toString().trim().equalsIgnoreCase("null"))){
                        accion.setEnabled(false);
                        accion.setText("---");
                    }

                }
            });

            return convertView;
        }
    }
}
    ///////////////////////////////////////////////

