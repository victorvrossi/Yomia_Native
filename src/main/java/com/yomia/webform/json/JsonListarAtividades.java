package com.yomia.webform.json;

import com.yomia.webform.json.model.JsonResponse;
import com.yomia.modulo.core.Atividade;
import com.yomia.modulo.data.DataUtil;

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
