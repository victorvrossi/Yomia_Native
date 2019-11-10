
package com.yomia.webform.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.entidade.TbAtividade;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class JsonResponse {
    public abstract JsonResponse converteParaJson( Object atividade) ;
    
    public String formarJsonComLista(ArrayList<JsonResponse> user){
        validaLista(user);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<JsonResponse>>() {}.getType();
        String userJSONString = gson.toJson(user,listType);
        return userJSONString;
    }

    private void validaLista(ArrayList<JsonResponse> user) {
        if(user == null | user.size()<1){
            throw new NullPointerException("Sem dados para formar JSON");
        }
    }
    
}
