package com.yomia.jpa.dao;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbFluxoAtividade;
import com.yomia.jpa.entidade.TbTipoAtividade;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.falhas.FalhaOperacaoDeBD;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoTipoAtividade extends DaoGenerico<TbTipoAtividade> {

    public TbTipoAtividade novoTipoAtividade(String titulo) throws FalhaGenerica {
        TbTipoAtividade n = new TbTipoAtividade();
        n.setTitulo(titulo);
        n.setTbAtividadeList(null);
        n.setTbFluxoAtividade(null);
        try {
            salvar(n);
        } catch (Exception ex) {
            ex.printStackTrace();
            //throw new FalhaGenerica("Falha:"+ex.toString());
        }
        return n;
    }

    public List carregaTipoAtividade() {
        EntityManager manager = getEntityManager();
        try {
            Query createNamedQuery = manager.createNamedQuery("TbTipoAtividade.findAll");
            return createNamedQuery.getResultList();
        } finally {
            manager.close();
        }
    }

    public TbTipoAtividade carregaTipoAtividadePorTitulo(String titulo) {
        EntityManager manager = getEntityManager();
        try {
            Query createNamedQuery = manager.createNamedQuery("TbTipoAtividade.findByTitulo");
            createNamedQuery.setParameter("titulo", titulo);
            final List resultList = createNamedQuery.getResultList();
            if (resultList.size() > 0) {
                return (TbTipoAtividade) resultList.get(0);
            }
        } finally {
            manager.close();
        }
        return null;
    }

    @Override
    public List<BaseEntidade> carregarListaDoBanco() throws FalhaGenerica {
        EntityManager manager = getEntityManager();
        try {
            Query createNamedQuery = manager.createNamedQuery("TbTipoAtividade.findAll");
            return createNamedQuery.getResultList();
        } catch (Throwable e) {
            throw new FalhaOperacaoDeBD("Falha ao Carregar todas as atividades");
        } finally {
            manager.close();
        }
    }

    @Override
    public Class<TbTipoAtividade> getClasseTabela() {
        return TbTipoAtividade.class;
    }

    public void novoTipoAtividade(String tipo, TbFluxoAtividade tbFluxoAtividade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
