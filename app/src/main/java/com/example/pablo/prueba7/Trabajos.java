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
import android.widget.TextView;

import com.example.pablo.prueba7.Listas.Array;


/**
 * A simple {@link Fragment} subclass.
 */
public class Trabajos extends Fragment{
    public static TextView trabajo1;


    public Trabajos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trabajos, container, false);
        Button accion = view.findViewById(R.id.accion);
        ListView trabajos=view.findViewById(R.id.listTrabajos);

        /*trabajo1=view.findViewById(R.id.observacion1);
        accion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(getContext(), asignacion.class);
                startActivity(intento);
            }
        });*/

        ////////////////////////////////////////

        TrabajosAdapter trabadapt=new TrabajosAdapter();
        trabajos.setAdapter(trabadapt);    //Asignacion del adapatador a la listView

        //////////////////////////////////////////
        return view;
    }
    ///////////////////Adaptador Trabajos//////////////////////////
    class TrabajosAdapter extends BaseAdapter{

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

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.list_trabajos_items,null);
            TextView trabajo=(TextView)convertView.findViewById(R.id.trabajov);
            Button accion=(Button)convertView.findViewById(R.id.accionv);
            trabajo.setText(Array.trabajox.get(position));
            accion.setText(Array.accionx.get(position));

            return convertView;
        }
    }
    ///////////////////////////////////////////////


}
