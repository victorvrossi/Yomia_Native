package com.yomia.webform.json;

import com.yomia.modulo.falhas.FalhaAoConverterObjeto;
import com.yomia.modulo.falhas.FalhaAoGerarObjetoPorReflexion;
import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.modulo.atividade.Entidade;
import com.yomia.modulo.atividade.ModeloDataTable;
import com.yomia.modulo.falhas.FalhaGenerica;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class CarregaListaJson {

    public String listaTodosElementoEmJson(Class<? extends DaoGenerico> daoClass, Class<? extends JsonResponse> jsonClass, Class<? extends Entidade> entidadeClass) throws FalhaGenerica {
        Entidade entidade = (Entidade) geraObjetoApartirDeClasse(entidadeClass);
        DaoGenerico daoObjeto = (DaoGenerico) geraObjetoApartirDeClasse(daoClass);
        JsonResponse jsonObjeto = (JsonResponse) geraObjetoApartirDeClasse(jsonClass);
        List<BaseEntidade> objetosCarregadosDoBanco = converteParaEntidade(daoObjeto);
        ArrayList<JsonResponse> listaDeObjetoJson = carregaListaConverteObjeto(jsonObjeto, entidade, objetosCarregadosDoBanco);
        return jsonObjeto.formarJsonComLista(listaDeObjetoJson);
    }
    
    public String listaTodosElementoEmJsonParaDataTable(Class<? extends DaoGenerico> daoClass,  Class<? extends ModeloDataTable> entidadeClass) throws FalhaGenerica {
        ModeloDataTable modeloDataTable = (ModeloDataTable) geraObjetoApartirDeClasse(entidadeClass);
        DaoGenerico daoObjeto = (DaoGenerico) geraObjetoApartirDeClasse(daoClass);
        List<BaseEntidade> objetosCarregadosDoBanco = converteParaEntidade(daoObjeto);
        ArrayList<String[]> listaDeObjetoJson = carregaListaConverteArrayString(modeloDataTable, objetosCarregadosDoBanco);
        
        return  new JsonResponse() {
            @Override
            public JsonResponse converteParaJson(Object atividade) throws FalhaGenerica {
                throw new FalhaGenerica("").lancarError("FLG", "Falha ao usar método ruim", "");
            }
        }.formarJsonParaDataTable(listaDeObjetoJson);
    }

    private Object geraObjetoApartirDeClasse(Class t) throws FalhaGenerica {
        Constructor<?> cons;
        Object objeto = null;
        try {
            cons = t.getConstructor();
            objeto = cons.newInstance();
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
            ex.printStackTrace();
            throw new FalhaAoGerarObjetoPorReflexion("Falha ao gerar Objeto por Reflexion").lancarError("RFL-001", "Falha Ao listar Objetos", "Houve um problema ao gerar a lista de Objetos. Favor Entra em contato com suporte");
        }
        if (objeto == null) {
            throw new FalhaGenerica("Falha na chamada Reflexion");
        }
        return objeto;
    }

    private List<BaseEntidade> converteParaEntidade(DaoGenerico e) throws FalhaGenerica {
        List<BaseEntidade> carregarTodasAtividades = e.carregarTodas("findAll");
        if (carregarTodasAtividades == null || carregarTodasAtividades.size() < 1) {
            throw new FalhaGenerica("Falha ao carregar dados do Banco").lancarError("EBD-001", "Falha ao acessar dados", "Não existe atividades cadastradas ainda");
        }
        return carregarTodasAtividades;
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
    
    private ArrayList<String[]> carregaListaConverteArrayString(ModeloDataTable l,  List<BaseEntidade> objetosCarregadosBancoDeDados) throws FalhaAoConverterObjeto {
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

}
