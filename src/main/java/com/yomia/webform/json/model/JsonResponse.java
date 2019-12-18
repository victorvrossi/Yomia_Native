package com.yomia.webform.json.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.modulo.falhas.FalhaGenerica;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class JsonResponse {

    public abstract JsonResponse converteParaJson(Object atividade)throws FalhaGenerica;

    public String formarJsonComLista(ArrayList<JsonResponse> user) throws FalhaGenerica {
        String userJSONString = "";
        try {
            validaLista(user);
            Gson gson = new Gson();
            Type listType = new TypeToken<List<JsonResponse>>() {
            }.getType();
            userJSONString = gson.toJson(user, listType);
        } catch (Exception e) {
            throw new FalhaGenerica("Falha ao construir Json").lancarError("Falha", "Falhaou", "Ouhu");
        }

        return userJSONString;
    }

    public String formarJson(JsonResponse json) {
        String userJSONString = "";
        try {
            Gson gson = new Gson();            
            userJSONString = gson.toJson(json);
        } catch (Exception e) {
            System.out.println("Falha ao formar JSON:" + e);
        }

        return userJSONString;
    }
    
    public String formarJsonParaDataTable(ArrayList<String[]>k ){
        String JSONString = "";
        Map<String,ArrayList<String[]>> mapaDeDados = new HashMap<>();
        mapaDeDados.put("data", k);
        try {
            Gson gson = new Gson();
            Type listType = new TypeToken<Map<String,ArrayList<String[]>>>() {
            }.getType();
            JSONString = gson.toJson(mapaDeDados, listType);
        } catch (Exception e) {
            System.out.println("Falha ao formar JSON:" + e);
        }
        System.out.println("com.yomia.webform.json.JsonResponse.formarJsonParaDataTable():"+JSONString);
        return JSONString;
    }

    private void validaLista(ArrayList<JsonResponse> lista) throws FalhaGenerica {
        if (lista == null | lista.size() < 1) {
            throw new FalhaGenerica("Sem dados para formar JSON");
        }
    }

}
