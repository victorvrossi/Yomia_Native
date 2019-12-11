package com.yomia.jpa.dao;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.jpa.entidade.TbStatusAtividade;
import com.yomia.modulo.data.DataUtil;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.falhas.FalhaOperacaoDeBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoStatusAtividade extends DaoGenerico<TbStatusAtividade> {

    void consultaPorTitulo(TbAtividade atividade, String aberto) {
        TbStatus statusPesquisado = new DaoStatus().pesquisaPorTitulo(aberto);
        EntityManager manager = getEntityManager();
    }

    TbStatusAtividade novoStatus(TbAtividade idAtividade, TbStatus tbStatus) throws FalhaGenerica {
        TbStatusAtividade tbStatusAtividade = new TbStatusAtividade();
        tbStatusAtividade.setIdAtividade(idAtividade);
        tbStatusAtividade.setIdStatus(tbStatus);
        tbStatusAtividade.setDataEntrada(DataUtil.atual().data());
        salvar(tbStatusAtividade);
        return tbStatusAtividade;
    }

    @Override
    public Class<TbStatusAtividade> getClasseTabela() {
        return TbStatusAtividade.class;
    }
     @Override
    public List<BaseEntidade> carregarListaDoBanco() throws FalhaGenerica {
        EntityManager manager = getEntityManager();
        try {
            Query createNamedQuery = manager.createNamedQuery("TbStatusAtividade.findAll");
            return createNamedQuery.getResultList();
        } catch (Throwable e) {
            throw new FalhaOperacaoDeBD("Falha ao Carregar todas as atividades");
        } finally {
            manager.close();
        }
    }

}
