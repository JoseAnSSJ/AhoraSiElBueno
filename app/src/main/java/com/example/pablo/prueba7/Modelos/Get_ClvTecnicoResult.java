package com.example.pablo.prueba7.Modelos;


public class Get_ClvTecnicoResult {
    public String clv_tecnico;
    public String nombre_tec;



    public Get_ClvTecnicoResult(String clv_tecnico,String nombre_tec) {
        this.clv_tecnico = clv_tecnico;
        this.nombre_tec=nombre_tec;

    }

    public  String getClv_tecnico() {
        return clv_tecnico;
    }
    public  String getNombre_tec() {
        return nombre_tec;
    }
    public void setClv_tecnico(String clv_tecnico) {
        this.clv_tecnico = clv_tecnico;
    }

}