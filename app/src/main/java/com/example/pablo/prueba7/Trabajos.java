package com.example.pablo.prueba7;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pablo.prueba7.Adapters.ordenes_adapter_result;
import com.example.pablo.prueba7.Adapters.trabajos_adapter_result;
import com.example.pablo.prueba7.Listas.Array;


/**
 * A simple {@link Fragment} subclass.
 */
public class Trabajos extends Fragment{
    public static TextView trabajo1;
    trabajos_adapter_result adaptertrabajos;


    public Trabajos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSaveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trabajos, container, false);

        ListView trabajos=view.findViewById(R.id.listTrabajos);


        ////////////////////////////////////////

        TrabajosAdapter trabadapt=new TrabajosAdapter();
        trabajos.setAdapter(trabadapt);    //Asignacion del adapatador a la listView

        //adaptertrabajos =new trabajos_adapter_result(Trabajos.this,Array.trabajox,Array.accionx);
        //trabajos.setAdapter(adaptertrabajos);    //Asignacion del adapatador a la listView

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
            return position;
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
