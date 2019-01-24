package com.example.pablo.prueba7.Services;



import com.example.pablo.prueba7.CambioAparato;
import com.example.pablo.prueba7.Modelos.DeepConsModel;
import com.example.pablo.prueba7.Login;

import com.example.pablo.prueba7.Modelos.GetMuestraArbolServiciosAparatosPorinstalarListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraMedioPorServicoContratadoListResult;
import com.example.pablo.prueba7.Modelos.UserModel;
import com.example.pablo.prueba7.sampledata.Constants;
import com.example.pablo.prueba7.sampledata.Service;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




public class Services {
    public static int claveTecnico;

    public String abc="Basic: "+Login.enco;

    /////////TOKEN///C////
    public Service getClientService() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {

                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        //Modificacion del Header

                        Request newRequest = chain.request().newBuilder()
                                .addHeader("Authorization", abc)
                                .build();
                        return chain.proceed(newRequest);
                    }
                }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);
    }

    /////////////Servicio Tecnico/////////C////////////
    public Service getTecService() throws JSONException {
        //POST Body Json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Clv_Usuario",Login.cvl_usuario);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        try {
            final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

                @Override
                public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {

                    //Modificacion del Header
                    Request newRequest = chain.request().newBuilder()
                            .addHeader("Authorization", UserModel.Codigo)
                            .addHeader("Content-Type", "application/json")
                            .post(body)
                            .build();


                    return chain.proceed(newRequest);
                }
            }).build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.NEW_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit.create(Service.class);

        }catch (Exception e){
            getTecService();
        }


        return null;
    }

    /////////////Proximo Servicio/////////C////////////
    public Service getProxService() throws JSONException {
        //POST Body Json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clv_tecnico", claveTecnico);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());

        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                //Modificacion del Header
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();


                return chain.proceed(newRequest);
            }
        }).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);
    }

    /////////////Orden de servicio/////////C////////////
    public Service getOrdSerService() throws JSONException {
        //POST Body Json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clv_tecnico", claveTecnico);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());

        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                //Modificacion del Header
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body).build();


                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.NEW_URL)
                .client(client).addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);

    }

    /////////////Lista de ordenes//////////F///////////
    public Service getListOrdService() throws JSONException {
        //POST Body JsonArray
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        jsonObject.put("clv_tecnico",claveTecnico);
        jsonObject.put("op",1);
        jsonObject.put("clv_orden",0);
        jsonObject.put("contratoCom","");
        jsonObject2.put("ObjLista",jsonObject);

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final RequestBody body = RequestBody.create(JSON, String.valueOf(jsonObject2));

        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {

                //Modificacion del Header
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body).build();


                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.NEW_URL)
                .client(client).addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);

    }

    /////////////Servicios Service/////////C////////////
    public Service getServiciosService() throws JSONException {
        //POST Body Json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Contrato",DeepConsModel.Contrato);


        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final RequestBody body = RequestBody.create(JSON, String.valueOf(jsonObject));

        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {

                //Modificacion del Header
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body).build();


                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.NEW_URL)
                .client(client).addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);

    }


    /////////////Informacion pantalla de ordenes//////F///////////////
    public Service getDeepConsService() throws JSONException {
        //POST Body Json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Clv_Orden", 345);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());

        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                //Modificacion del Header
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();


                return chain.proceed(newRequest);
            }
        }).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);
    }

    /////////////Informacion del cliente////////C/////////////
    public Service getInfoClienteService() throws JSONException {
        //POST Body Json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("CONTRATO", DeepConsModel.Contrato);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());

        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                //Modificacion del Header
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();


                return chain.proceed(newRequest);
            }
        }).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);
    }


//////////////Lista de Trabajos/////F///////
    public Service getTrabajoService()throws JSONException{
        JSONObject jsonObject= new JSONObject();
        jsonObject.put( "Clv_Orden",121211);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
                }
        }).build();
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

//////////////Tecnico Secundario/////F//////////
    public Service getTecSecService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ClvOrdSer", 0);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type","application/json" )
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    ////////////// Aparatos Clientes/////F//////////
    public Service getCliApaService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Contrato", 52623);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type","application/json" )
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    //////////////Status Aparato/////C//////////
    public Service getStatusApa() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {

                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        Request newRequest = chain.request().newBuilder()
                                .addHeader("Authorization", UserModel.Codigo)
                                .build();


                        return chain.proceed(newRequest);
                    }
                }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);
    }

    //////////////Tipo de Aparato/////C//////////
    public Service getApaTipoService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ContratoNet", CambioAparato.contrato);
        jsonObject.put("Id_Articulo", CambioAparato.idArticulo);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type","application/json" )
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    //////////////Tipo de Aparato Disponible/////C//////////
    public Service getApaTipDisService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Clv_Tecnico", claveTecnico);
        jsonObject.put("Id_Articulo", CambioAparato.idArticulo2);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type","application/json" )
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    //////////////Cambio de Domicilio/////F//////////
    public Service getCAMODOService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clv_orden", 105);
        jsonObject.put("Clave", 106);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type","application/json" )
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }
    //////////////Arbol Servicios/////F//////////
    public Service getArbolSerService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clv_orden", 121211);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type","application/json" )
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }
    //////////////Medios Servicios/////F//////////
    public Service getMediosSerService() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ClvUnicaNet",102703 );
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type","application/json" )
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }
    public Service getTipoAparatosService() throws JSONException {
        ////////
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Id",0 );
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("obj",jsonObject);
        /////////////
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("Clv_UnicaNet", GetMuestraArbolServiciosAparatosPorinstalarListResult.clv_UnicaNet);
        jsonObject2.put("idMedio", GetMuestraMedioPorServicoContratadoListResult.medio);
        ////////
        JSONArray list = new JSONArray();
        list.put(jsonObject2);
        /////////////
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("obj", jsonObject);
        jsonObject3.put("Lst", list);
        MediaType JSON = MediaType.parse("application/json; charse=utf-8");
        final RequestBody body = RequestBody.create(JSON, String.valueOf(jsonObject3));
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type","application/json" )
                        .post(body)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEW_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }
}
