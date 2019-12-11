package com.yomia.jpa.dao;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.modulo.data.DataUtil;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.falhas.FalhaOperacaoDeBD;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoStatus extends DaoGenerico<TbStatus> {

    public DaoStatus() {
        
    }
    
    public TbStatus novoStatus(String aberto) {        
        TbStatus st = new TbStatus();
        st.setTitulo(aberto);
        try {
            salvar(st);
        } catch (Exception ex) {
            System.err.println("Falha----------:"+ex);
        }
        return st;
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

    @Override
    public List<BaseEntidade> carregarListaDoBanco() throws FalhaGenerica {
        EntityManager manager = getEntityManager();
        try {
            Query createNamedQuery = manager.createNamedQuery("TbStatus.findAll");
            return createNamedQuery.getResultList();
        } catch (Throwable e) {
            throw new FalhaOperacaoDeBD("Falha ao Carregar todas as atividades");
        } finally {
            manager.close();
        }
    }
    

}
