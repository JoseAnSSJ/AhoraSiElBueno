package com.example.pablo.prueba7.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetMuestraMedioPorServicoContratadoListResult {
    @SerializedName("Descripcion")
    @Expose
    private String descripcion;
    @SerializedName("Medio")
    @Expose
    public static Integer medio;
    @SerializedName("RequiereAcometida")
    @Expose
    private boolean requiereAcometida;

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getMedio() {
        return medio;
    }

    public boolean isRequiereAcometida() {
        return requiereAcometida;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMedio(Integer medio) {
        this.medio = medio;
    }

    public void setRequiereAcometida(boolean requiereAcometida) {
        this.requiereAcometida = requiereAcometida;
    }
}
