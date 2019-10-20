
package com.yomia.webform.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonClienteLista {
    
    String titulo;
    String descricao;
    String data;
    String status;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }
    
    
    public String json(JsonClienteLista user){
        Gson gson = new Gson();
        String userJSONString = gson.toJson(user);
        return userJSONString;
    }
    public String jsonList(ArrayList<JsonClienteLista> user){
        Gson gson = new Gson();
        Type listType = new TypeToken<List<JsonClienteLista>>() {}.getType();
        String userJSONString = gson.toJson(user,listType);
        return userJSONString;
    }
}
