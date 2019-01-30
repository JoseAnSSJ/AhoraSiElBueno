package com.example.pablo.prueba7.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import android.widget.TextView;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.R;

public class Servicios_Adapter extends BaseAdapter {

Array array = new Array();
    LayoutInflater inflater;
    Context mcontext;

    public Servicios_Adapter (Context context){
        mcontext=context;
        inflater = LayoutInflater.from(mcontext);
    }
    public static class viewHolder{
        public static TextView servicio;
        public static Button check;

    }

    @Override
    public int getCount() {
        return array.serviciosAparatos.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        final viewHolder holder;


        if (convertView == null) {
            holder = new viewHolder();

            convertView=inflater.inflate(R.layout.activity_asignados_list,null);

            holder.servicio=convertView.findViewById(R.id.textServicios);
            holder.check=convertView.findViewById(R.id.chekServicios);


            convertView.setTag(holder);
        }
        else {
            holder=(viewHolder)convertView.getTag();
        }

        holder.servicio.setText(array.serviciosAparatos.get(position));
        return convertView;
    }
}
