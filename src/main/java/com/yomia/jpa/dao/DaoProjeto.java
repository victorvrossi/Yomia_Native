
package com.yomia.jpa.dao;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbProjeto;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.falhas.FalhaOperacaoDeBD;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoProjeto extends DaoGenerico<TbProjeto>  {

    public TbProjeto novoProjeto(String titulo,String sigla){
        TbProjeto tbProjeto = new TbProjeto();
        tbProjeto.setSigla(sigla);
        tbProjeto.setTitulo(titulo);
        try {
            salvar(tbProjeto);
        } catch (Exception ex) {
            Logger.getLogger(DaoProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbProjeto;
    }
    @Override
    public Class<TbProjeto> getClasseTabela() {
        return TbProjeto.class;
    }

    @Override
    public List<BaseEntidade> carregarListaDoBanco() throws FalhaGenerica {
        EntityManager manager = getEntityManager();
        try {
            Query createNamedQuery = manager.createNamedQuery("TbProjeto.findAll");
            return createNamedQuery.getResultList();
        } catch (Throwable e) {
            throw new FalhaOperacaoDeBD("Falha ao Carregar todas as atividades");
        } finally {
            manager.close();
        }
    }
    
}
