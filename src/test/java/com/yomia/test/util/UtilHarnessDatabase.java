package com.yomia.test.util;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.controler.Persistencia;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbFuncionario;
import com.yomia.jpa.entidade.TbHistoricoStatusAtv;
import com.yomia.jpa.entidade.TbProjeto;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.jpa.entidade.TbStatusAtividade;
import com.yomia.jpa.entidade.TbTipoAtividade;
import com.yomia.resource.YomiaResource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

public class UtilHarnessDatabase {

    protected EntityManager getEntityManager() {
         EntityManagerFactory factory = Persistence.createEntityManagerFactory(new YomiaResource().devolveAmbienteQueEstaEmExecucao().getNome());
        return factory.createEntityManager();
    }

    public void limpaTodasOsDados() {
        EntityManager manager = getEntityManager();

        try {
            manager.getTransaction().begin();
            truncateTabela(manager, nomeDaTabela(TbAtividade.class));
            truncateTabela(manager, nomeDaTabela(TbFuncionario.class));
            truncateTabela(manager, nomeDaTabela(TbHistoricoStatusAtv.class));
            truncateTabela(manager, nomeDaTabela(TbProjeto.class));
            truncateTabela(manager, nomeDaTabela(TbStatus.class));
            truncateTabela(manager, nomeDaTabela(TbStatusAtividade.class));
            truncateTabela(manager, nomeDaTabela(TbTipoAtividade.class));
            
            manager.getTransaction().commit();
        } finally {
            manager.close();
        }
    }

    private void truncateTabela(EntityManager manager, final String nomeDaTabela) {
        manager.createQuery("DELETE FROM "+nomeDaTabela+"").executeUpdate();
    }
    
    public String nomeDaTabela(Class<? extends BaseEntidade> classe){
        return classe.getSimpleName();
    }

}
