
package com.yomia.jpa.dao;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbStatusAtividade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoStatusAtividade extends DaoGenerico<TbStatusAtividade> {

    public List<TbStatusAtividade> carregarTodosStatus() {        
         EntityManager manager = getEntityManager();
        try {
             Query createNamedQuery = manager.createNamedQuery("TbStatusAtividade.findAll");
             return createNamedQuery.getResultList();
        } finally {
            manager.close();
        }
    }
    
}