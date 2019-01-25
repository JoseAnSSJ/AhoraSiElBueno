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

public class ordenes_adapter_result extends BaseAdapter {


    LayoutInflater inflater;
    Context mContext;

    public ordenes_adapter_result(Context context){
        mContext=context;
        inflater=LayoutInflater.from(mContext);

    }
    public class viewHolder{
        TextView status,contrato,nombre;
        Button orden;
    }

    @Override
    public int getCount() {
        return Array.ordensrc.size();
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

            convertView=inflater.inflate(R.layout.ordenes_list_items,null);

            holder.status=(TextView)convertView.findViewById(R.id.statusv);
            holder.orden=(Button)convertView.findViewById(R.id.ordenv);
            holder.contrato=(TextView)convertView.findViewById(R.id.contratov);
            holder.nombre=(TextView)convertView.findViewById(R.id.nombrev);


            convertView.setTag(holder);
        }
        else {
            holder=(viewHolder)convertView.getTag();
        }

        holder.contrato.setText(Array.contratosrc.get(position));
        holder.nombre.setText(Array.nombrex.get(position));
        holder.orden.setText(Array.ordensrc.get(position));
        holder.status.setText(Array.statusx.get(position));

        return convertView;

    }
}