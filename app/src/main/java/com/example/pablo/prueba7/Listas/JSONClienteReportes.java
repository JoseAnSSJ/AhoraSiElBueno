package com.example.pablo.prueba7.Listas;
import java.util.List;

import com.example.pablo.prueba7.Modelos.GetuspBuscaContratoSeparado2ListResult;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONClienteReportes {
    @SerializedName("GetuspBuscaContratoSeparado2ListResult")
    @Expose
    private List<GetuspBuscaContratoSeparado2ListResult> getuspBuscaContratoSeparado2ListResult = null;

    public List<GetuspBuscaContratoSeparado2ListResult> getGetuspBuscaContratoSeparado2ListResult() {
        return getuspBuscaContratoSeparado2ListResult;
    }

    public void setGetuspBuscaContratoSeparado2ListResult(List<GetuspBuscaContratoSeparado2ListResult> getuspBuscaContratoSeparado2ListResult) {
        this.getuspBuscaContratoSeparado2ListResult = getuspBuscaContratoSeparado2ListResult;
    }

}
