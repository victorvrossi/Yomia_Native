package com.yomia.jpa.dao;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.modulo.data.DataUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoStatus extends DaoGenerico<TbStatus> {
    
    public TbStatus novoStatus(String aberto) {
        System.out.println("---------------------------------------------------------------------------------------Salvando Status :"+aberto+ ">"+DataUtil.formatarData(DataUtil.atual().data()));
        TbStatus st = new TbStatus();
        st.setTitulo(aberto);
        try {
            salvar(st);
        } catch (Exception ex) {
            System.err.println("Falha----------:"+ex);
        }
        return st;
    }

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
            createNamedQuery.setParameter("titulo", titulo);
            List<TbStatus> resultList = createNamedQuery.getResultList();
            if (resultList == null || resultList.size() != 1) {
                System.out.println("com.yomia.jpa.dao.DaoStatus.pesquisaPorTitulo():"+resultList.toString());
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
