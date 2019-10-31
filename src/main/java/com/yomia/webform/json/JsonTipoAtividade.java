package com.yomia.webform.json;

import com.yomia.jpa.entidade.TbTipoAtividade;
import com.yomia.modulo.atividade.TipoAtividade;

public class JsonTipoAtividade extends JsonResponse {

    public static JsonResponse converte(TipoAtividade tipo) {
        return new JsonTipoAtividade().converteParaJson(tipo);
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
        TipoAtividade tipoAtividade = (TipoAtividade)tipo;
        JsonTipoAtividade nv = new JsonTipoAtividade();
        nv.titulo = tipoAtividade.getTitulo();
        return nv;
    }

}
