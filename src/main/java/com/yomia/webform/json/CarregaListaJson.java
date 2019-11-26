package com.yomia.webform.json;

import com.yomia.modulo.falhas.FalhaAoConverterObjeto;
import com.yomia.modulo.falhas.FalhaAoGerarObjetoPorReflexion;
import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.modulo.atividade.Atividade;
import com.yomia.modulo.atividade.Entidade;
import com.yomia.modulo.falhas.FalhaGenerica;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarregaListaJson {

    public String listaTodosElementoEmJson(Class<? extends DaoGenerico> daoClass, Class<? extends JsonListarAtividades> jsonClass, Class<? extends Entidade> entidadeClass) throws FalhaGenerica {
        Entidade entidade = (Entidade) geraObjetoApartirDeClasse(entidadeClass);
        DaoGenerico daoObjeto = (DaoGenerico) geraObjetoApartirDeClasse(daoClass);
        JsonListarAtividades jsonObjeto = (JsonListarAtividades) geraObjetoApartirDeClasse(jsonClass);
        
        ArrayList<JsonResponse> listaDeObjetoJson;
        List<BaseEntidade> objetosCarregadosDoBanco = converteParaEntidade(daoObjeto);
        if(objetosCarregadosDoBanco.size()<1){
            throw new FalhaGenerica("Falha ao carregar dados do Banco").lancarError("EBD-001", "Falha ao acessar dados", "Não existe atividades cadastradas ainda");
        }
        listaDeObjetoJson = carregaListaConverteObjeto(jsonObjeto, entidade, objetosCarregadosDoBanco);
        return jsonObjeto.formarJsonComLista(listaDeObjetoJson);
    }

    private Object geraObjetoApartirDeClasse(Class t) throws FalhaAoGerarObjetoPorReflexion {
        Constructor<?> cons;
        Object objeto = null;
        try {
            cons = t.getConstructor();
            objeto = cons.newInstance();
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
            throw new FalhaAoGerarObjetoPorReflexion("Falha ao gerar Objeto por Reflexion");
        }
        if(objeto == null){
            throw new NullPointerException("Falha na chamada Reflexion");
        }
        return objeto;
    }

    private List<BaseEntidade> converteParaEntidade(DaoGenerico e) {
        List<BaseEntidade> carregarTodasAtividades = e.carregarTodas("findAll");
        if(carregarTodasAtividades == null || carregarTodasAtividades.size()<1){
           return new ArrayList<BaseEntidade>();
        }
        return carregarTodasAtividades;
    }

    private ArrayList<JsonResponse> carregaListaConverteObjeto(JsonResponse l, Entidade entidade, List<BaseEntidade> atividadesCarregadasBancoDeDados) throws FalhaAoConverterObjeto {
        ArrayList<JsonResponse> listaDeAtividadeJson = new ArrayList<>();
        try{
        for (BaseEntidade atividade : atividadesCarregadasBancoDeDados) {
            Entidade atv = entidade.converteTabelaParaObjeto(atividade);
            listaDeAtividadeJson.add(l.converteParaJson(atv));
        }
        }catch(Exception e){
            throw new FalhaAoConverterObjeto("Falha ao realizar conversão de objetos");
        }
        return listaDeAtividadeJson;
    }

}
