package com.example.pablo.prueba7;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetMUESTRATRABAJOSQUEJASListResult;
import com.example.pablo.prueba7.Request.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Ejecutar1Fragment extends Fragment {
    Array array = new Array();
    Button eject;
    Request request = new Request();
    public static JSONObject jsonObject2 = new JSONObject();
    public static JSONObject jsonObject3 = new JSONObject();
    public Ejecutar1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ejecutar2, container, false);
        eject = view.findViewById(R.id.ejec);

        eject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Iterator<List<GetMUESTRATRABAJOSQUEJASListResult>> itdata = array.dataSOL.iterator();
                List<GetMUESTRATRABAJOSQUEJASListResult> dat = itdata.next();

                for(int b=0; b<dat.size(); b++ ){
                    try {
                        jsonObject2.put("Tipo Solucion", dat.get(b).getDESCRIPCION());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }


                eject.setEnabled(false);
                

            }
        });



        return view;
    }


}
