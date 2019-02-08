package com.example.pablo.prueba7.Listas;

import com.example.pablo.prueba7.Modelos.GetBUSCADetOrdSerListResult;
import com.example.pablo.prueba7.Modelos.GetConTecnicoAgendaResult;
import com.example.pablo.prueba7.Modelos.GetDameDatosCAMDOResult;
import com.example.pablo.prueba7.Modelos.GetDameListadoOrdenesAgendadasResult;
import com.example.pablo.prueba7.Modelos.GetDameSerDelCliFacListResult;
import com.example.pablo.prueba7.Modelos.GetListAparatosDisponiblesByIdArticuloResult;
import com.example.pablo.prueba7.Modelos.GetListClienteAparatosResult;
import com.example.pablo.prueba7.Modelos.GetListTipoAparatosByIdArticuloResult;
import com.example.pablo.prueba7.Modelos.GetMUESTRATRABAJOSQUEJASListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraArbolServiciosAparatosPorinstalarListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraMedioPorServicoContratadoListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraRelOrdenesTecnicosListResult;
import com.example.pablo.prueba7.Modelos.GetQuejasListResult;
import com.example.pablo.prueba7.Modelos.GetSP_StatusAparatosListResult;
import com.example.pablo.prueba7.Modelos.GetSoftvGetPrioridadQuejaListResult;
import com.example.pablo.prueba7.Modelos.Get_ClvTecnicoResult;
import com.example.pablo.prueba7.Modelos.GetdameSerDELCliresumenResult;
import com.example.pablo.prueba7.Modelos.GetuspConsultaTblClasificacionProblemasListResult;
import com.example.pablo.prueba7.Modelos.OrdSer;
import com.example.pablo.prueba7.Modelos.Queja;

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
 ///////////////////////ARRAY TRABAJOS///////////////////
    public static ArrayList <String>trabajox=new ArrayList<>();
    public static ArrayList<String>accionx=new ArrayList<>();
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
    public static  ArrayList<List<GetMuestraMedioPorServicoContratadoListResult>> dataMedSer;
   /////////////////////////////////Reportes/////////////////////////////////////////////////////////////////////////
   //public static ArrayList<List<InfoReportesModel>> dataRep;
    public static ArrayList<List<GetMUESTRATRABAJOSQUEJASListResult>> dataSOL;
    public static ArrayList<List<GetQuejasListResult>>dataReport;
    public static ArrayList<List<GetSoftvGetPrioridadQuejaListResult>>dataPriori;
    public static ArrayList<List<GetuspConsultaTblClasificacionProblemasListResult>>dataClasf;
    public static ArrayList<List<GetConTecnicoAgendaResult>>dataNom;
    public static ArrayList<List<GetDameSerDelCliFacListResult>>dataServ;


}
