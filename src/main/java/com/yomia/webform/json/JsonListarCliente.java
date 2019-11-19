
package com.yomia.webform.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class JsonListarCliente {

    
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

    public void setData(Calendar data) {
        this.data = data.toString();
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
    
    
    public String json(JsonListarCliente user){
        Gson gson = new Gson();
        String userJSONString = gson.toJson(user);
        return userJSONString;
    }
    public String jsonList(ArrayList<JsonListarCliente> user){
        Gson gson = new Gson();
        Type listType = new TypeToken<List<JsonListarCliente>>() {}.getType();
        String userJSONString = gson.toJson(user,listType);
        return userJSONString;
    }
}
