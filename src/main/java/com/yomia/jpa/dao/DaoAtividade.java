
package com.yomia.jpa.dao;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbFuncionario;
import com.yomia.jpa.entidade.TbHistoricoStatusAtv;
import com.yomia.jpa.entidade.TbProjeto;
import com.yomia.jpa.entidade.TbStatusAtividade;
import com.yomia.jpa.entidade.TbTipoAtividade;
import com.yomia.modulo.data.DataUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoAtividade extends DaoGenerico<TbAtividade> {

    public void novaAtividade( String titulo,String codigoAtividade,
            String descricao,String tipo, TbProjeto projeto){
        
        new DaoTipoAtividade().carregaTipoAtividade();
        TbAtividade nova = new TbAtividade();
        
        nova.setTitulo(titulo);
        nova.setDescricao(descricao);        
        nova.setCodigoAtividade(codigoAtividade);
        
        nova.setIdProjeto(projeto);
        nova.setIdResponsavel(new TbFuncionario(1));
        nova.setIdTipoAtividade(new TbTipoAtividade(1));
        nova.setDataCriacao(DataUtil.atual().data());
        
        List<TbHistoricoStatusAtv> semHistorico = new ArrayList<>();
        nova.setTbHistoricoStatusAtvList(semHistorico);
        
        
        try {
            salvar(nova);
        } catch (Exception ex) {
            Logger.getLogger(DaoAtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
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
