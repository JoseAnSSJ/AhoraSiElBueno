package com.example.pablo.prueba7.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetMuestraTipoAparatoListResult {
    @SerializedName("Nombre")
    @Expose
    private  String nombre;
    @SerializedName("IdArticulo")
    @Expose
    private  Integer idArticulo;

    public String getNombre() {
        return nombre;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }
}
