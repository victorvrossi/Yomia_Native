package com.yomia.modulo.atividade;

import com.yomia.jpa.dao.DaoTipoAtividade;
import com.yomia.jpa.entidade.TbFluxoAtividade;
import com.yomia.jpa.entidade.TbTipoAtividade;
import com.yomia.webform.json.JsonResponse;
import com.yomia.webform.json.JsonTipoAtividade;
import java.util.ArrayList;
import java.util.List;

public class TipoAtividade {

    private String titulo;
    
    public void novoTipoAtividade(String tipo){
        validaEntrada(tipo);
        DaoTipoAtividade novo = new DaoTipoAtividade();
        novo.novoTipoAtividade(tipo, new TbFluxoAtividade());
    }

    void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
    
     public TipoAtividade converteTabelaParaObjeto(TbTipoAtividade tb) {
        titulo = tb.getTitulo();
        return this;
    }

    public String carregaLista() {
        ArrayList<JsonResponse> listaDeAtividadeJson = new ArrayList<>();
        DaoTipoAtividade daoAtividade = new DaoTipoAtividade();
        List<TbTipoAtividade> atividadesCarregadasBancoDeDados = daoAtividade.carregaTipoAtividade();
        for (TbTipoAtividade atividade : atividadesCarregadasBancoDeDados) {
            TipoAtividade atv = new TipoAtividade().converteTabelaParaObjeto(atividade);
            JsonResponse converteParaJson = new JsonTipoAtividade().converteParaJson(atv);
            listaDeAtividadeJson.add(converteParaJson);
        }
        return new JsonTipoAtividade().formarJsonComLista(listaDeAtividadeJson);
    }

    private void validaEntrada(String tipo) {
        if(tipo == null || tipo.equals("")){
            throw new NullPointerException("Tipo de Atividada]e NULL");
        }
        
    }
}
