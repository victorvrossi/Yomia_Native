package com.yomia.jpa.dao;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbFuncionario;
import com.yomia.jpa.entidade.TbHistoricoStatusAtv;
import com.yomia.jpa.entidade.TbProjeto;
import com.yomia.jpa.entidade.TbStatus;
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

    public TbAtividade novaAtividade(String titulo, String codigoAtividade,
            String descricao, TbProjeto projeto,TbStatus status,
            TbTipoAtividade novoTipoAtividade,TbFuncionario func) {
        
        TbAtividade nova = new TbAtividade();
        
        nova.setTitulo(titulo);
        nova.setDescricao(descricao);
        nova.setCodigoAtividade(codigoAtividade);

        nova.setIdProjeto(projeto);
        nova.setIdResponsavel(func);
        nova.setIdTipoAtividade(novoTipoAtividade);
        nova.setDataCriacao(DataUtil.atual().data());

        List<TbHistoricoStatusAtv> semHistorico = new ArrayList<>();
        nova.setTbHistoricoStatusAtvList(semHistorico);

        TbStatusAtividade novoStatus = new DaoStatusAtividade().novoStatus(nova, status);
        nova.setTbStatusAtividade(novoStatus);
        
        try {
            salvar(nova);
        } catch (Exception ex) {
            Logger.getLogger(DaoAtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nova;
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

    @Override
    public Class<TbAtividade> getClasseTabela() {
        return TbAtividade.class;
    }

}
