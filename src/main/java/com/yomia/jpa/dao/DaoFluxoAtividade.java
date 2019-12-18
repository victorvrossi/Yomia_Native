package com.yomia.jpa.dao;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbFluxoAtividade;
import com.yomia.jpa.entidade.TbFluxoSequencia;
import com.yomia.jpa.entidade.TbTipoAtividade;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.falhas.FalhaOperacaoDeBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoFluxoAtividade extends DaoGenerico<TbFluxoAtividade> {

    public TbFluxoAtividade cadastrarNovoFluxo(String titulo, TbTipoAtividade idTipoAtv, List<TbFluxoSequencia> tbFluxoSequenciaList) throws FalhaOperacaoDeBD {
        TbFluxoAtividade fluxo = new TbFluxoAtividade();
        fluxo.setTitulo(titulo);
        fluxo.setIdTipoAtv(idTipoAtv);
        fluxo.setTbFluxoSequenciaList(tbFluxoSequenciaList);
        salvar(fluxo);
        return fluxo;
    }

    @Override
    public Class<TbFluxoAtividade> getClasseTabela() {
        return TbFluxoAtividade.class;
    }

    @Override
    public List<BaseEntidade> carregarListaDoBanco() throws FalhaGenerica {
        EntityManager manager = getEntityManager();
        try {
            Query createNamedQuery = manager.createNamedQuery("TbFluxoAtividade.findAll");
            return createNamedQuery.getResultList();
        } catch (Throwable e) {
            throw new FalhaOperacaoDeBD("Falha ao Carregar todas as atividades:"+e.toString());
        } finally {
            manager.close();
        }
    }

}
