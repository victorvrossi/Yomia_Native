package com.yomia.jpa.dao;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbFluxoAtividade;
import com.yomia.jpa.entidade.TbTipoAtividade;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoTipoAtividade extends DaoGenerico<TbTipoAtividade> {

    public TbTipoAtividade novoTipoAtividade(String titulo,TbFluxoAtividade idFluxoAtividade) {
        TbTipoAtividade n = new TbTipoAtividade();
        n.setTitulo(titulo);
        List<TbAtividade> tbAtividadeList = new ArrayList<>();
        n.setTbAtividadeList(tbAtividadeList);
        try {
            salvar(n);
        } catch (Exception ex) {
            Logger.getLogger(DaoAtividade.class.getName()).log(Level.SEVERE, null, ex);
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
            if(resultList.size()>0){
                return (TbTipoAtividade)resultList.get(0);
            }
        } finally {
            manager.close();
        }
        return null;
    }

    @Override
    public Class<TbTipoAtividade> getClasseTabela() {
        return TbTipoAtividade.class;
    }
}
