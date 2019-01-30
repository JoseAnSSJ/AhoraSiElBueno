package com.example.pablo.prueba7.Listas;

import com.example.pablo.prueba7.Modelos.GetBUSCADetOrdSerListResult;
import com.example.pablo.prueba7.Modelos.GetDameListadoOrdenesAgendadasResult;
import com.example.pablo.prueba7.Modelos.GetListAparatosDisponiblesByIdArticuloResult;
import com.example.pablo.prueba7.Modelos.GetListClienteAparatosResult;
import com.example.pablo.prueba7.Modelos.GetListTipoAparatosByIdArticuloResult;
import com.example.pablo.prueba7.Modelos.GetMuestraArbolServiciosAparatosPorinstalarListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraMedioPorServicoContratadoListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraRelOrdenesTecnicosListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraServiciosRelTipoAparatoListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraTipoAparatoListResult;
import com.example.pablo.prueba7.Modelos.GetSP_StatusAparatosListResult;
import com.example.pablo.prueba7.Modelos.Get_ClvTecnicoResult;
import com.example.pablo.prueba7.Modelos.GetdameSerDELCliresumenResult;
import com.example.pablo.prueba7.Modelos.OrdSer;
import com.example.pablo.prueba7.Modelos.Queja;
import com.example.pablo.prueba7.Modelos.GetDameDatosCAMDOResult;
import com.example.pablo.prueba7.Modelos.GetMuestraAparatosDisponiblesListResult;
import com.example.pablo.prueba7.Modelos.children;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Array {
   public static ArrayList<List<GetdameSerDELCliresumenResult>> dataclientes;
    public static ArrayList<List<Queja>> dataque;
    public static  ArrayList<List<OrdSer>> dataord;
    //////////////////////ARRAY ORDENES//////////////////////
    public static ArrayList<List<GetDameListadoOrdenesAgendadasResult>> dataagenda;
    public static ArrayList <String>contratox=new ArrayList<>();
    public static ArrayList <String>statusx=new ArrayList<>();
    public static ArrayList <String>nombrex=new ArrayList<>();
    public static ArrayList <String>ordenx=new ArrayList<>();
    //----BUSQUEDA CONTRATO & ORDEN----//
    public static ArrayList<String>contratosrc=new ArrayList<>();
    public static ArrayList<String>ordensrc=new ArrayList<>();
 ///////////////////////ARRAY TRABAJOS///////////////////
    public static ArrayList <String>trabajox=new ArrayList<>();
    public static ArrayList<String>accionx=new ArrayList<>();
    //////////////////////////////////////////////////////

    public static ArrayList <String>nombreArbol=new ArrayList<>();
    public static ArrayList<String>medio=new ArrayList<>();
    public static ArrayList<String>tipoAparato=new ArrayList<>();
    public static ArrayList<String>aparatoDisponibles=new ArrayList<>();
    public static ArrayList<String>serviciosAparatos=new ArrayList<>();
    //////////////////////////////////////////////////////
    public static  ArrayList<List<Get_ClvTecnicoResult>> datatec;
    public static ArrayList<List<GetBUSCADetOrdSerListResult>> dataTrabajos;
    public static ArrayList<List<GetMuestraRelOrdenesTecnicosListResult>> dataTecSec;
    public static ArrayList<List<GetListClienteAparatosResult>> dataCliApa;
    public static ArrayList<List<GetSP_StatusAparatosListResult>> dataStaApa;
    public static  ArrayList<List<GetListTipoAparatosByIdArticuloResult>> dataApaTipo;
    public static  ArrayList<List<GetListAparatosDisponiblesByIdArticuloResult>> dataApaTipDis;
 public static  ArrayList<List<GetDameDatosCAMDOResult>> dataCAMDO;
    public static  ArrayList<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> dataArbSer;
    public static  ArrayList<List<children>> dataChild;
    public static  ArrayList<List<GetMuestraMedioPorServicoContratadoListResult>> dataMedSer;
    public static  ArrayList<List<GetMuestraTipoAparatoListResult>> dataTipoAparatos;
    public static  ArrayList<List<GetMuestraAparatosDisponiblesListResult>> dataAparatosDisponibles;
    public static  ArrayList<List<GetMuestraServiciosRelTipoAparatoListResult>> dataserviciosAparatos;
}
