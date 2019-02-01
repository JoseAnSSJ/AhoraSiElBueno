package com.example.pablo.prueba7.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GetMuestraArbolServiciosAparatosPorinstalarListResult {
    @SerializedName("Clv_TipSer")
    @Expose
    private Integer clv_TipSer;
    @SerializedName("Clv_UnicaNet")
    @Expose
    public Integer clv_UnicaNet;
    @SerializedName("Detalle")
    @Expose
    public String detalle;
    @SerializedName("IdMedio")
    @Expose
    public Integer idMedio;
    @SerializedName("Nombre")
    @Expose
    private String nombre;
    @SerializedName("Tipo")
    @Expose
    private String tipo;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("children")
    @Expose
    public ArrayList<children> children;

    public ArrayList<children> getchildren() {
        return children;
    }

    public void setchildren(ArrayList<children> children) {
        this.children = children;
    }


    public Integer getClv_TipSer() {
        return clv_TipSer;
    }

    public Integer getClv_UnicaNet() {
        return clv_UnicaNet;
    }

    public String getDetalle() {
        return detalle;
    }

    public Integer getIdMedio() {
        return idMedio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getType() {
        return type;
    }

    public void setClv_TipSer(Integer clv_TipSer) {
        this.clv_TipSer = clv_TipSer;
    }

    public void setClv_UnicaNet(Integer clv_UnicaNet) {
        this.clv_UnicaNet = clv_UnicaNet;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setIdMedio(Integer idMedio) {
        this.idMedio = idMedio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setType(String type) {
        this.type = type;
    }


}
