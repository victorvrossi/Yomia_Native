package com.yomia.jpa.dao;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbHistoricoStatusAtv;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.modulo.data.DataUtil;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.falhas.FalhaOperacaoDeBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoHistoricoAtividade extends DaoGenerico<TbHistoricoStatusAtv> {

    public TbHistoricoStatusAtv registrarHistorico(TbAtividade idAtividade, TbStatus idStatus) throws FalhaGenerica{
        validaAtividade(idAtividade);
        TbHistoricoStatusAtv novo = new TbHistoricoStatusAtv();
        novo.setDataEfetivado(DataUtil.atual().data());        
        novo.setIdAtividade(idAtividade);
        novo.setIdStatus(idAtividade.getTbStatusAtividade().getIdStatus());
        idAtividade.getTbStatusAtividade().setIdStatus(idStatus);
        return salvar(novo);
    }
    @Override
    public Class<TbHistoricoStatusAtv> getClasseTabela() {
        return TbHistoricoStatusAtv.class;
    }

    private void validaAtividade(TbAtividade idAtividade) throws FalhaGenerica {
        if(idAtividade.getTbStatusAtividade() == null){
            throw new FalhaGenerica("StatusAtividadeNull");
        }
        if(idAtividade.getTbStatusAtividade().getIdStatus() == null){
            throw new FalhaGenerica("Status de StatusAtividadeNull");
        }
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
