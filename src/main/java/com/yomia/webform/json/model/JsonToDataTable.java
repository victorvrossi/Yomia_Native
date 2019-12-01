package com.yomia.webform.json.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonToDataTable extends JsonResponse{

    @Override
    public JsonResponse converteParaJson(Object atividade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public String formarJsonComLista(ArrayList<JsonResponse> user) {
        String userJSONString = "";
        
        Map<String,ArrayList<String[]>> s = new HashMap<>();
        ArrayList<String[]>k = new ArrayList<>();
        k.add(new String[]{"teste","10"});
        k.add(new String[]{"sfgw4 we","1s"});
        k.add(new String[]{"teasdasste","10"});
        k.add(new String[]{"teasdasste","10"});
        k.add(new String[]{"teasdasste","10"});
        k.add(new String[]{"teasdasste","10"});
        k.add(new String[]{"teasdasste","99"});
        k.add(new String[]{"teasdasste","99"});
        k.add(new String[]{"teasdasste","99"});
        k.add(new String[]{"teasdasste","99"});
        k.add(new String[]{"teasdasste","99"});
        k.add(new String[]{"teasdasste","99"});
        k.add(new String[]{"aiusydi ausyd","848"});
        k.add(new String[]{"aiusydi ausyd","848"});
        k.add(new String[]{"aiusydi ausyd","848"});
        k.add(new String[]{"aiusydi ausyd","848"});
        k.add(new String[]{"aiusydi ausyd","848"});
        k.add(new String[]{"aiusydi ausyd","848"});
        k.add(new String[]{"aiusydi ausyd","848"});
        k.add(new String[]{"aiusydi ausyd","848"});
        k.add(new String[]{"aiusydi ausyd","848"});
        k.add(new String[]{"euaiusia su","8987"});
        k.add(new String[]{"euaiusia su","8987"});
        k.add(new String[]{"euaiusia su","8987"});
        k.add(new String[]{"euaiusia su","8987"});
        k.add(new String[]{"euaiusia su","8987"});
        k.add(new String[]{"euaiusia su","8987"});
        k.add(new String[]{"euaiusia su","8987"});
        k.add(new String[]{"euaiusia su","8987"});
        k.add(new String[]{"euaiusia su","8987"});
        s.put("data", k);
        try {
            validaLista(user);
            Gson gson = new Gson();
            Type listType = new TypeToken<Map<String,ArrayList<String[]>>>() {
            }.getType();
            userJSONString = gson.toJson(s, listType);
        } catch (Exception e) {
            System.out.println("Falha ao formar JSON:" + e);
        }
        
        System.out.println("********** JSON LISTA ativ: "+userJSONString);
        //userJSONString = "{\"data\":[\"titulo\"]}";
        //userJSONString = "{\"data\": [{\"titulo\":\"Ttitulo\"}]}";
        return userJSONString;
    }
     private void validaLista(ArrayList<JsonResponse> user) {
        if (user == null | user.size() < 1) {
            throw new NullPointerException("Sem dados para formar JSON");
        }
    }

}
