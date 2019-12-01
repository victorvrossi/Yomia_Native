package com.yomia.webform.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.modulo.atividade.Atividade;
import com.yomia.modulo.data.DataUtil;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JsonListarAtividades extends JsonResponse {

    public static JsonListarAtividades converte(Atividade atividade) {
        return (JsonListarAtividades) new JsonListarAtividades().converteParaJson(atividade);
    }

    public String getCodigoAtividade() {
        return codigoAtividade;
    }

    public void setCodigoAtividade(String codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public JsonResponse converteParaJson(Object atv) {
        Atividade atividade = (Atividade) atv;
        JsonListarAtividades nv = new JsonListarAtividades();
        nv.titulo = atividade.getTitulo();
        nv.codigoAtividade = atividade.getCodigoAtividade();
        nv.descricao = atividade.getDescricao();
        nv.tipo = atividade.getTipo();
        nv.status = atividade.getStatus();
        nv.dataCriacao = DataUtil.formatarData(atividade.getDataCriacao());
        return nv;
    }
    
    String codigoAtividade;
    String titulo;
    String descricao;
    String status = "aberto";
    String tipo;
    String dataCriacao = "";

}
