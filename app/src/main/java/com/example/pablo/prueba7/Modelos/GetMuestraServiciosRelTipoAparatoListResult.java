package com.example.pablo.prueba7.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetMuestraServiciosRelTipoAparatoListResult {
    @SerializedName("Clv_UnicaNet")
    @Expose
    public Integer clv_UnicaNet;
    @SerializedName("nombre")
    @Expose
    public String nombre;
    @SerializedName("selected")
    @Expose
    public static boolean selected=false;

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public static boolean isSelected() {
        return selected;
    }

    public Integer getClv_UnicaNet() {
        return clv_UnicaNet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setClv_UnicaNet(Integer clv_UnicaNet) {
        this.clv_UnicaNet = clv_UnicaNet;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
