package com.example.pablo.prueba7;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetMuestraMedioPorServicoContratadoListResult;
import com.example.pablo.prueba7.Request.Request;

import java.util.Iterator;
import java.util.List;

public class asignacion extends AppCompatActivity {
Array array = new Array();
Request request = new Request();
    Button siguiente, btnmedio;
    ListView Asignacion;
  //  RelativeLayout layoutMedio;
    public static Spinner spinerMedio;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion);
        siguiente= (Button) findViewById(R.id.siguiente);
        Asignacion = findViewById(R.id.Asignacion);
        btnmedio = (Button) findViewById(R.id.medio);
     //   layoutMedio = findViewById(R.id.layoutmedio);
        spinerMedio = findViewById(R.id.spinnerMedio);
        request.getMedSer(getApplicationContext());
     /*   btnmedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutMedio.setVisibility(View.VISIBLE);
            }
        });*/
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento=new Intent(asignacion.this,asignado.class);
                startActivity(intento);
            }
        });
            AsignacionAdapter adapter = new AsignacionAdapter();
            Asignacion.setAdapter(adapter);

    }
    class AsignacionAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return array.nombreArbol.size();
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
            convertView = getLayoutInflater().inflate(R.layout.activity_aparato_asignado_medio_list, null);

            TextView nombre = convertView.findViewById(R.id.textservicio);
            Spinner medio = convertView.findViewById(R.id.medio);

            nombre.setText(array.nombreArbol.get(position));
            ///////////////////////////////////////////////////////////
            Iterator<List<GetMuestraMedioPorServicoContratadoListResult>> itdata = array.dataMedSer.iterator();
            List<GetMuestraMedioPorServicoContratadoListResult> dat = itdata.next();


            return convertView;
        }
    }

}
