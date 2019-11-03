
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
    
}