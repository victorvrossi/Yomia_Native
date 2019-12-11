package com.yomia.webform.json.model;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.modulo.core.Entidade;
import com.yomia.modulo.falhas.FalhaAoConverterObjeto;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.saida.ModeloParaSaidaEmJson;
import java.util.ArrayList;
import java.util.List;

public class CarregarDadosEmListaJson {

    public String listaTodosElementoEmJson(Entidade entidade,DaoGenerico g,JsonResponse jsonObjeto) throws FalhaGenerica {
        List<BaseEntidade> objetosCarregadosDoBanco = g.carregarListaDoBanco();
        ArrayList<JsonResponse> listaDeObjetoJson = carregaListaConverteObjeto(jsonObjeto, entidade, objetosCarregadosDoBanco);
        return jsonObjeto.formarJsonComLista(listaDeObjetoJson);
    }
    
    public String listaTodosElementoEmJsonParaDataTable(DaoGenerico g,  ModeloParaSaidaEmJson entidadeClass) throws FalhaGenerica {
        ModeloParaSaidaEmJson modeloDataTable = entidadeClass;
        List<BaseEntidade> objetosCarregadosDoBanco = g.carregarListaDoBanco();
        ArrayList<String[]> listaDeObjetoJson = carregaListaConverteArrayString(modeloDataTable, objetosCarregadosDoBanco);
        
        return  new JsonResponse() {
            @Override
            public JsonResponse converteParaJson(Object atividade) throws FalhaGenerica {
                throw new FalhaGenerica("").lancarError("FLG", "Falha ao usar método ruim", "");
            }
        }.formarJsonParaDataTable(listaDeObjetoJson);
    }
    
    private ArrayList<String[]> carregaListaConverteArrayString(ModeloParaSaidaEmJson l,  List<BaseEntidade> objetosCarregadosBancoDeDados) throws FalhaAoConverterObjeto {
        ArrayList<String[]> listaDeAtividadeJson = new ArrayList<>();
        try {
            for (BaseEntidade atividade : objetosCarregadosBancoDeDados) {
                listaDeAtividadeJson.add(l.converteParaArrayDeString(atividade));
            }
        } catch (Exception e) {
            throw new FalhaAoConverterObjeto("Falha ao realizar conversão de objetos");
        }
        return listaDeAtividadeJson;
    }
    private ArrayList<JsonResponse> carregaListaConverteObjeto(JsonResponse l, Entidade entidade, List<BaseEntidade> objetosCarregadosBancoDeDados) throws FalhaGenerica {
        ArrayList<JsonResponse> listaDeAtividadeJson = new ArrayList<>();
        try {
            for (BaseEntidade atividade : objetosCarregadosBancoDeDados) {
                Entidade atv = entidade.converteTabelaParaObjeto(atividade);
                listaDeAtividadeJson.add(l.converteParaJson(atv));
            }
        } catch (Exception e) {
            throw new FalhaAoConverterObjeto("Falha ao realizar conversão de objetos");
        }
        return listaDeAtividadeJson;
    }
    

}
