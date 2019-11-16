package com.yomia.jpa.dao;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbFluxoAtividade;
import com.yomia.jpa.entidade.TbFluxoSequencia;
import com.yomia.jpa.entidade.TbTipoAtividade;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoFluxoAtividade extends DaoGenerico<TbFluxoAtividade> {

    public TbFluxoAtividade novoFluxo(String titulo, List<TbFluxoSequencia> tbFluxoSequenciaList, List<TbTipoAtividade> tbTipoAtividadeList) {
        TbFluxoAtividade fluxo = new TbFluxoAtividade();
        fluxo.setTitulo(titulo);
        fluxo.setVisibilidadePublica(true);
        fluxo.setTbFluxoSequenciaList(tbFluxoSequenciaList);
        try {
            salvar(fluxo);
        } catch (Exception ex) {
            Logger.getLogger(DaoFluxoAtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fluxo;
    }

    public TbFluxoAtividade novoFluxo(String titulo) {
        List<TbFluxoSequencia> tbFluxoSequenciaList = new ArrayList<>();
        List<TbTipoAtividade> tbTipoAtividadeList = new ArrayList<>();
        return novoFluxo(titulo, tbFluxoSequenciaList, tbTipoAtividadeList);
    }
    
    public void removerFluxo(String titulo){
        EntityManager m = getEntityManager();
        Query query = m.createNamedQuery("TbFluxoAtividade.findByTitulo");
        query.setParameter("titulo", titulo);
        List<TbFluxoAtividade> resultList = query.getResultList();
        try {
            for (TbFluxoAtividade tbFluxoAtividade : resultList) {
                remover(tbFluxoAtividade.getId());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(DaoFluxoAtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Class<TbFluxoAtividade> getClasseTabela() {
        return TbFluxoAtividade.class;
    }

}
