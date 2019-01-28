package com.example.pablo.prueba7;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.pablo.prueba7.Adapters.ordenes_adapter_result;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Request.Request;

public class Orden extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    Request request = new Request();
    Button orden1, cambiodom, cambioapa;
    ListView ordenes;
    EditText ordsearch,contsearch;
    ordenes_adapter_result adapterord;
    int textlength = 0;

    @Override


    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_orden);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        orden1 =  findViewById(R.id.orden);
        cambiodom = findViewById(R.id.cambiodom);
        cambioapa = findViewById(R.id.cambioapa);
        ordenes=findViewById(R.id.listorden);
        ordsearch=findViewById(R.id.ordsearch);
        contsearch=findViewById(R.id.contsearch);
        Error.Errores(this);
        request.getArbSer(getApplicationContext());
        ////////////////////////////////////////

        adapterord=new ordenes_adapter_result(Orden.this,Array.ordensrc,Array.nombresrc,Array.statusrc,Array.contratosrc);
        ordenes.setAdapter(adapterord);    //Asignacion del adapatador a la listView

        //////////////////////////////////////////

        //* Boton para ir a menu principal
        orden1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento1 = new Intent(Orden.this, MainActivity.class);

                startActivity(intento1);
                   request.getDeepCons();
            }
        });
        cambiodom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request.getCAMDO();
                Intent intent = new Intent(Orden.this, CambioDom.class);
                startActivity(intent);
            }
        });

        cambioapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Orden.this, CambioAparato.class);
                startActivity(intent);
            }
        });

        /////////BUSCA ORDEN//////////////
        ordsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                textlength = ordsearch.getText().length();
                Array.ordensrc.clear();
                Array.nombresrc.clear();
                Array.statusrc.clear();
                Array.contratosrc.clear();
                for (int i = 0; i < Array.ordenx.size(); i++) {
                    if (textlength <= Array.ordenx.get(i).length()) {
                        if (Array.ordenx.get(i).toLowerCase().contains(ordsearch.getText().toString().toLowerCase().trim())){
                            Array.ordensrc.add(Array.ordenx.get(i));
                            Array.nombresrc.add(Array.nombrex.get(i));
                            Array.contratosrc.add(Array.contratox.get(i));
                            Array.statusrc.add((Array.statusx.get(i)));

                        }
                    }
                }

                adapterord=new ordenes_adapter_result(Orden.this,Array.ordensrc,Array.nombresrc,Array.statusrc,Array.contratosrc);
                ordenes.setAdapter(adapterord);   //Asignacion del adapatador a la listView

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        //////////////////BUSCA CONTRATO////////////////////////////

        contsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                textlength = contsearch.getText().length();
                Array.ordensrc.clear();
                Array.nombresrc.clear();
                Array.statusrc.clear();
                Array.contratosrc.clear();
                for (int i = 0; i < Array.contratox.size(); i++) {
                    if (textlength <= Array.contratox.get(i).length()) {
                        if (Array.contratox.get(i).toLowerCase().contains(contsearch.getText().toString().toLowerCase().trim())){
                            Array.ordensrc.add(Array.ordenx.get(i));
                            Array.nombresrc.add(Array.nombrex.get(i));
                            Array.contratosrc.add(Array.contratox.get(i));
                            Array.statusrc.add((Array.statusx.get(i)));

                        }
                    }
                }
                adapterord=new ordenes_adapter_result(Orden.this,Array.ordensrc,Array.nombresrc,Array.statusrc,Array.contratosrc);
                ordenes.setAdapter(adapterord);   //Asignacion del adapatador a la listView

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //////////////////////////////////////////////

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Inicio) {
            Intent intent1 = new Intent(Orden.this, Inicio.class);
            startActivity(intent1);
            //Actualizar la siguente cita y la grafica
           request.getProximaCita();

                request.getOrdenes();

        } else if (id == R.id.Ordenes) {
            Intent intent1 = new Intent(Orden.this, Orden.class);
            startActivity(intent1);


        } else if (id == R.id.Reportes) {
            Intent intent1 = new Intent(Orden.this, Reportes.class);
            startActivity(intent1);

        } else if (id == R.id.Configuraciones) {
            Intent intent1 = new Intent(Orden.this, Configuracion.class);
            startActivity(intent1);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //Bloquear el boton de atras
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
        }
        return false;
    }
}
