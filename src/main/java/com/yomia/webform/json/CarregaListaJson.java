package com.yomia.webform.json;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.modulo.atividade.Atividade;
import com.yomia.modulo.atividade.Entidade;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarregaListaJson {

    public String listaTodosElementoEmJson(Class<? extends DaoGenerico> daoClass, Class<? extends JsonAtividade> jsonClass, Class<? extends Entidade> entidadeClass) {
        Entidade entidade = (Entidade) geraObjetoApartirDeClasse(entidadeClass);
        DaoGenerico daoObjeto = (DaoGenerico) geraObjetoApartirDeClasse(daoClass);
        JsonAtividade jsonObjeto = (JsonAtividade) geraObjetoApartirDeClasse(jsonClass);
        ArrayList<JsonResponse> listaDeObjetoJson;
        List<BaseEntidade> objetosCarregadosDoBanco = converteParaEntidade(daoObjeto);
        listaDeObjetoJson = carregaListaConverteObjeto(jsonObjeto, entidade, objetosCarregadosDoBanco);
        return jsonObjeto.formarJsonComLista(listaDeObjetoJson);
    }

    private Object geraObjetoApartirDeClasse(Class t) {
        Constructor<?> cons;
        Object objeto = null;
        try {
            cons = t.getConstructor();
            objeto = cons.newInstance();
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
            System.out.println("Erro:"+ex);
        }
        if(objeto == null){
            throw new NullPointerException("Falha na chamada Reflexion");
        }
        return objeto;
    }

    private List<BaseEntidade> converteParaEntidade(DaoGenerico e) {
        List<BaseEntidade> carregarTodasAtividades = e.carregarTodas(e.getClasseTabela(),"findAll");
        if(carregarTodasAtividades == null || carregarTodasAtividades.size()<1){
            throw new NullPointerException("Nenhuma Atividade carregada");
        }
        return carregarTodasAtividades;
    }

    private ArrayList<JsonResponse> carregaListaConverteObjeto(JsonResponse l, Entidade entidade, List<BaseEntidade> atividadesCarregadasBancoDeDados) {
        ArrayList<JsonResponse> listaDeAtividadeJson = new ArrayList<>();
        for (BaseEntidade atividade : atividadesCarregadasBancoDeDados) {
            Entidade atv = entidade.converteTabelaParaObjeto(atividade);
            listaDeAtividadeJson.add(l.converteParaJson(atv));
        }
        return listaDeAtividadeJson;
    }

}
