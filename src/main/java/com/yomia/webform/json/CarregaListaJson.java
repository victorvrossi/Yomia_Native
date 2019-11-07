package com.yomia.webform.json;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.modulo.atividade.Atividade;
import com.yomia.modulo.atividade.Entidade;
import java.util.ArrayList;
import java.util.List;

public class CarregaListaJson {

    
    public String listaTodosElementoEmJson(DaoGenerico e) {
        ArrayList<JsonResponse> listaDeAtividadeJson = new ArrayList<>();
        List<BaseEntidade> atividadesCarregadasBancoDeDados = converteParaEntidade(e);
        carregaListaConverteObjeto(new JsonAtividade(), atividadesCarregadasBancoDeDados, listaDeAtividadeJson);
        return new JsonAtividade().formarJsonComLista(listaDeAtividadeJson);
    }

    private List<BaseEntidade> converteParaEntidade(DaoGenerico e) {
        List<BaseEntidade> carregarTodasAtividades = e.carregarTodas(e.getClasseTabela());
        return carregarTodasAtividades;
    }

    private void carregaListaConverteObjeto(JsonResponse l,
            List<BaseEntidade> atividadesCarregadasBancoDeDados, ArrayList<JsonResponse> listaDeAtividadeJson) {
        for (BaseEntidade atividade : atividadesCarregadasBancoDeDados) {
            Entidade atv = new Atividade().converteTabelaParaObjeto(atividade);
            listaDeAtividadeJson.add(l.converteParaJson(atv));
        }
    }

}
