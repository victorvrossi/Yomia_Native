
package com.yomia.jpa.dao;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbHistoricoStatusAtv;
import com.yomia.jpa.entidade.TbProjeto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoAtividade extends DaoGenerico<TbAtividade> {

    public void novaAtividade( String titulo,String codigoAtividade,
            String descricao, TbProjeto projeto, TbHistoricoStatusAtv statusAtual){
        TbAtividade nova = new TbAtividade();
        nova.setCodigoAtividade(codigoAtividade);
        nova.setDescricao(descricao);
        nova.setIdProjeto(projeto);
        List<TbHistoricoStatusAtv> tbHistoricoStatusAtvList = new ArrayList<>();
        tbHistoricoStatusAtvList.add(statusAtual);
        nova.setTitulo(titulo);
        nova.setTbHistoricoStatusAtvList(tbHistoricoStatusAtvList);
        
    }
    public List<TbAtividade> carregarTodasAtividades() {        
         EntityManager manager = getEntityManager();
        try {
             Query createNamedQuery = manager.createNamedQuery("TbAtividade.findAll");
             return createNamedQuery.getResultList();
        } finally {
            manager.close();
        }
        
    }
    
}
