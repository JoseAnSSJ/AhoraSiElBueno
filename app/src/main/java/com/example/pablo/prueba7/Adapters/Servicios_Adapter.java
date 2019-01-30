package com.example.pablo.prueba7.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.sampledata.SelectedIndex;


public class Servicios_Adapter extends BaseAdapter implements SelectedIndex {

Array array = new Array();
    LayoutInflater inflater;
    Context mcontext;
    private int mSelectedIndex = -1;

    public Servicios_Adapter (Context context){
        mcontext=context;
        inflater = LayoutInflater.from(mcontext);
    }

    @Override
    public void setSelectedIndex(int position) {
       /* if (array.serviciosAparatos.get(position).isSelected()) {
            array.serviciosAparatos.get(position).setSelected(false);
        } else {
            array.serviciosAparatos.get(position).setSelected(true);
        }*/
    }

    public static class viewHolder{
        public static CheckBox check;

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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final viewHolder holder;


        if (convertView == null) {
            holder = new viewHolder();

            convertView=inflater.inflate(R.layout.activity_asignados_list,null);

            holder.check=convertView.findViewById(R.id.chekServicios);


            convertView.setTag(holder);
        }
        else {
            holder=(viewHolder)convertView.getTag();
        }

        holder.check.setText(array.serviciosAparatos.get(position));

      if (mSelectedIndex == position){
          holder.check.setChecked(true);
          Log.d("qwe", holder.check.getText().toString());
      }

        return convertView;
    }
}
