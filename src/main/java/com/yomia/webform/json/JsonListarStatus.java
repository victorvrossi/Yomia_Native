package com.yomia.webform.json;

import com.yomia.webform.json.model.JsonResponse;
import com.yomia.modulo.core.Status;

public class JsonListarStatus extends JsonResponse {

    public static JsonResponse converte(Object tipo) {
        return new JsonListarStatus().converteParaJson(tipo);
    }
    String titulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public JsonResponse converteParaJson(Object tipo) {
        Status status = (Status)tipo;
        JsonListarStatus nv = new JsonListarStatus();
        nv.titulo = status.getStatus();
        return nv;
    }

}
