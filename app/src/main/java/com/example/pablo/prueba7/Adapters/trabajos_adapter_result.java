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
import com.example.pablo.prueba7.Trabajos;

import java.util.ArrayList;

import static com.example.pablo.prueba7.Trabajos.trabajos;

public class trabajos_adapter_result extends BaseAdapter {

    LayoutInflater inflatertrab;
    Context Cmcontext;
    ArrayList<String>trabajox;
    ArrayList<String>accionx;

    public trabajos_adapter_result(Context context, ArrayList<String>trabajox, ArrayList<String>accionx){
      this.trabajox=trabajox;
      this.accionx=accionx;
      Cmcontext=context;
      inflatertrab=LayoutInflater.from(Cmcontext);
    }



    public class viewHolder{
        TextView trabajo;
        Button accion;
    }

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
       final viewHolder holder;
        if (convertView == null) {
            holder = new viewHolder();

            convertView=inflatertrab.inflate(R.layout.list_trabajos_items,null);

            holder.trabajo=(TextView)convertView.findViewById(R.id.trabajov);
            holder.accion=(Button)convertView.findViewById(R.id.accionv);

            convertView.setTag(holder);
        }
        else {
            holder=(viewHolder)convertView.getTag();
        }
        holder.trabajo.setText(Array.trabajox.get(position));
        holder.accion.setText(Array.accionx.get(position));

        return convertView;
    }

}
