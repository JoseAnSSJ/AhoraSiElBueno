package com.example.pablo.prueba7.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class children {
        @SerializedName("BaseIdUser")
        @Expose
        public Integer baseIdUser;
        @SerializedName("BaseRemoteIp")
        @Expose
        private Integer baseRemoteIp;
        @SerializedName("Clv_Aparato")
        @Expose
        public Integer clv_Aparato;
        @SerializedName("Clv_UnicaNet")
        @Expose
        private Integer clv_UnicaNet;
        @SerializedName("ContratoNet")
        @Expose
        public Integer contratoNet;
        @SerializedName("Detalle")
        @Expose
        private String detalle;
        @SerializedName("Nombre")
        @Expose
        private String nombre;
        @SerializedName("Tipo")
        @Expose
        public String tipo;
        @SerializedName("Type")
        @Expose
        private String type;

        public Integer getBaseIdUser() {
            return baseIdUser;
        }

        public Integer getBaseRemoteIp() {
            return baseRemoteIp;
        }

        public Integer getClv_Aparato() {
            return clv_Aparato;
        }

        public Integer getClv_UnicaNet() {
            return clv_UnicaNet;
        }

        public Integer getContratoNet() {
            return contratoNet;
        }

        public String getDetalle() {
            return detalle;
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

        public void setBaseIdUser(Integer baseIdUser) {
            this.baseIdUser = baseIdUser;
        }

        public void setBaseRemoteIp(Integer baseRemoteIp) {
            this.baseRemoteIp = baseRemoteIp;
        }

        public void setClv_Aparato(Integer clv_Aparato) {
            this.clv_Aparato = clv_Aparato;
        }

        public void setClv_UnicaNet(Integer clv_UnicaNet) {
            this.clv_UnicaNet = clv_UnicaNet;
        }

        public void setContratoNet(Integer contratoNet) {
            this.contratoNet = contratoNet;
        }

        public void setDetalle(String detalle) {
            this.detalle = detalle;
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
