package com.example.pablo.prueba7.Modelos;


public class GetuspBuscaContratoSeparado2ListResult {


    private Integer baseIdUser;
    private Object baseRemoteIp;
    private Integer activo;
    public static String apellidoMaterno;
    public static String apellidoPaterno;
    public static String cALLE;
    public static String cIUDAD;
    public static String cOLONIA;
    private String cONTRATO;
    private Object clvColonia;
    private Integer contratoBueno;
    public static Object  contratoCom;
    private Boolean eSHOTEL;
    private Object idDistribuidor;
    public static Object idUsuario;
    public static String nUMERO;
    public static String nombre;
    public static Object op;
    private Boolean sOLOINTERNET;
    private Object setupBox;
    public static Object tipoSer;

    public GetuspBuscaContratoSeparado2ListResult(String calle, String ciudad, String colonia, String nombre, String numero, String apellidoPaterno, String apellidoMaterno) {

        this.cIUDAD=ciudad;
        this.cOLONIA=colonia;
        this.nombre=nombre;
        this.nUMERO=numero;
        this.apellidoPaterno=apellidoPaterno;
        this.apellidoMaterno=apellidoMaterno;
        this.cALLE=calle;

    }


    public Integer getBaseIdUser() {
        return baseIdUser;
    }

    public void setBaseIdUser(Integer baseIdUser) {



        this.baseIdUser = baseIdUser;
    }

    public Object getBaseRemoteIp() {
        return baseRemoteIp;
    }

    public void setBaseRemoteIp(Object baseRemoteIp) {
        this.baseRemoteIp = baseRemoteIp;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        GetuspBuscaContratoSeparado2ListResult.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        GetuspBuscaContratoSeparado2ListResult.apellidoPaterno = apellidoPaterno;
    }

    public String getCALLE() {
        return cALLE;
    }

    public void setCALLE(String cALLE) {
        GetuspBuscaContratoSeparado2ListResult.cALLE =cALLE;
    }

    public String getCIUDAD() {
        return cIUDAD;
    }

    public void setCIUDAD(String cIUDAD) {
        GetuspBuscaContratoSeparado2ListResult.cIUDAD=cIUDAD;
    }

    public String getCOLONIA() {
        return cOLONIA;
    }

    public void setCOLONIA(String cOLONIA) {
        GetuspBuscaContratoSeparado2ListResult.cOLONIA=cOLONIA;
    }

    public String getCONTRATO() {
        return cONTRATO;
    }

    public void setCONTRATO(String cONTRATO) {
        this.cONTRATO = cONTRATO;
    }

    public Object getClvColonia() {
        return clvColonia;
    }

    public void setClvColonia(Object clvColonia) {
        this.clvColonia = clvColonia;
    }

    public Integer getContratoBueno() {
        return contratoBueno;
    }

    public void setContratoBueno(Integer contratoBueno) {
        this.contratoBueno = contratoBueno;
    }

    public Object getContratoCom() {
        return contratoCom;
    }

    public void setContratoCom(Object contratoCom) {
        this.contratoCom = contratoCom;
    }

    public Boolean getESHOTEL() {
        return eSHOTEL;
    }

    public void setESHOTEL(Boolean eSHOTEL) {
        this.eSHOTEL = eSHOTEL;
    }

    public Object getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(Object idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public Object getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Object idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNUMERO() {
        return nUMERO;
    }

    public void setNUMERO(String nUMERO) {
        GetuspBuscaContratoSeparado2ListResult.nUMERO=nUMERO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        GetuspBuscaContratoSeparado2ListResult.nombre =nombre;
    }

    public Object getOp() {
        return op;
    }

    public void setOp(Object op) {
        this.op = op;
    }

    public Boolean getSOLOINTERNET() {
        return sOLOINTERNET;
    }

    public void setSOLOINTERNET(Boolean sOLOINTERNET) {
        this.sOLOINTERNET = sOLOINTERNET;
    }

    public Object getSetupBox() {
        return setupBox;
    }

    public void setSetupBox(Object setupBox) {
        this.setupBox = setupBox;
    }

    public Object getTipoSer() {
        return tipoSer;
    }

    public void setTipoSer(Object tipoSer) {
        this.tipoSer = tipoSer;
    }

}




