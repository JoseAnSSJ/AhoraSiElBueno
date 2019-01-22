package com.example.pablo.prueba7.Listas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.example.pablo.prueba7.Modelos.GetMuestraArbolServiciosAparatosPorinstalarListResult;

import java.util.List;

public class JSONArbolServicios {
    @SerializedName("GetMuestraArbolServiciosAparatosPorinstalarListResult")
    @Expose
    private List<GetMuestraArbolServiciosAparatosPorinstalarListResult> GetMuestraArbolServiciosAparatosPorinstalarListResult = null;

    public List<GetMuestraArbolServiciosAparatosPorinstalarListResult> GetMuestraArbolServiciosAparatosPorinstalarListResult() {
        return GetMuestraArbolServiciosAparatosPorinstalarListResult;
    }

    public void setMuestraArbolServiciosAparatosPorinstalarListResult(List<GetMuestraArbolServiciosAparatosPorinstalarListResult> getMuestraArbolServiciosAparatosPorinstalarListResult) {
        this.GetMuestraArbolServiciosAparatosPorinstalarListResult = getMuestraArbolServiciosAparatosPorinstalarListResult;
    }
}
