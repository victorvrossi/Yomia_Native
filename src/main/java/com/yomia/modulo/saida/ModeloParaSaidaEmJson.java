package com.yomia.modulo.saida;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.modulo.core.Entidade;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.webform.json.model.CarregaListaJson;
import com.yomia.webform.json.model.JsonResponse;

public abstract class ModeloParaSaidaEmJson {

    public abstract String[] converteParaArrayDeString(BaseEntidade bt);

    public String geraListaJson(Class<? extends DaoGenerico> daoEntidade, Class<? extends JsonResponse> jsonRespone, Class<? extends Entidade> entidade) throws FalhaGenerica {
        CarregaListaJson json = new CarregaListaJson();
        return json.listaTodosElementoEmJson(daoEntidade, jsonRespone, entidade);
    }

    public String geraListaJsonParaDataTable(Class<? extends DaoGenerico> daoEntidade, Class<? extends ModeloParaSaidaEmJson> entidade) throws FalhaGenerica {
        CarregaListaJson json = new CarregaListaJson();
        return json.listaTodosElementoEmJsonParaDataTable(daoEntidade, entidade);
    }
}
