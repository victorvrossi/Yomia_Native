
package com.yomia.jpa.dao;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbTipoAtividade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoTipoAtividade extends DaoGenerico< TbTipoAtividade >{
    //TbTipoAtividade.findByTitulo
    
    public List carregaTipoAtividade(){
        EntityManager manager = getEntityManager();
        try {
             Query createNamedQuery = manager.createNamedQuery("TbTipoAtividade.findAll");
             return createNamedQuery.getResultList();
        } finally {
            manager.close();
        }
    }
    public List carregaTipoAtividadePorTitulo(String titulo){
        EntityManager manager = getEntityManager();
        try {
             Query createNamedQuery = manager.createNamedQuery("TbTipoAtividade.findByTitulo");
             createNamedQuery.setParameter("titulo", titulo);
             return createNamedQuery.getResultList();
        } finally {
            manager.close();
        }
    }
}
