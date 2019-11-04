package com.yomia.modulo.atividade;

import com.yomia.jpa.dao.DaoTipoAtividade;
import com.yomia.jpa.entidade.TbTipoAtividade;
import com.yomia.webform.json.JsonResponse;
import com.yomia.webform.json.JsonTipoAtividade;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class TipoAtividade {

    private String titulo;

    void setTitulo(String titulo) {
        System.out.println("Alterando tipo atividade:"+titulo);
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
    
     public TipoAtividade converteTabelaParaObjeto(TbTipoAtividade tb) {
        titulo = tb.getTitulo();
        return this;
    }

    public String carregaLista(HttpServletResponse response) {
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
}
