package com.yomia.jpa.dao;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbStatus;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoStatus extends DaoGenerico<TbStatus> {

    public List<TbStatus> carregarTodosStatus() {
        EntityManager manager = getEntityManager();
        try {
            Query createNamedQuery = manager.createNamedQuery("TbStatus.findAll");
            return createNamedQuery.getResultList();
        } finally {
            manager.close();
        }
    }

    public TbStatus pesquisaPorTitulo(String titulo) {
        EntityManager manager = getEntityManager();
        try {
            Query createNamedQuery = manager.createNamedQuery("TbStatus.findByTitulo");
            manager.setProperty("", titulo);
            List<TbStatus> resultList = createNamedQuery.getResultList();
            if (resultList == null || resultList.size() != 1) {
                throw new NullPointerException("Falha ao carregar apenas um status");
            }
            return resultList.get(0);
        } finally {
            manager.close();
        }
    }

    @Override
    public Class<TbStatus> getClasseTabela() {
        return TbStatus.class;
    }

}
