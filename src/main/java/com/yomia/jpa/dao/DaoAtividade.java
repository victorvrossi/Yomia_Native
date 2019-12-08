package com.yomia.jpa.dao;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbFuncionario;
import com.yomia.jpa.entidade.TbProjeto;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.jpa.entidade.TbStatusAtividade;
import com.yomia.jpa.entidade.TbTipoAtividade;
import com.yomia.modulo.data.DataUtil;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.falhas.FalhaOperacaoDeBD;
import com.yomia.util.Validacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoAtividade extends DaoGenerico<TbAtividade> {

    public TbAtividade novaAtividade(String titulo, String codigoAtividade,
            String descricao, TbProjeto projeto, TbStatus status,
            TbTipoAtividade novoTipoAtividade, TbFuncionario func) throws FalhaGenerica {
        TbAtividade nova = new TbAtividade();
        validaEntrada(titulo, descricao, codigoAtividade, projeto, func, novoTipoAtividade);

        nova.setTitulo(titulo);
        nova.setDescricao(descricao);
        nova.setCodigoAtividade(codigoAtividade);

        nova.setIdProjeto(projeto);
        nova.setIdResponsavel(func);
        nova.setIdTipoAtividade(novoTipoAtividade);
        nova.setDataCriacao(DataUtil.atual().data());

        salvar(nova);

        DaoStatusAtividade l = new DaoStatusAtividade();
        TbStatusAtividade tbStatusAtividade = l.novoStatus(nova, status);

        nova.setTbStatusAtividade(tbStatusAtividade);
        salvar(nova);
        
        return nova;
    }

    public List<TbAtividade> carregarTodasAtividades() throws FalhaOperacaoDeBD {
        EntityManager manager = getEntityManager();
        try {
            Query createNamedQuery = manager.createNamedQuery("TbAtividade.findAll");
            return createNamedQuery.getResultList();
        } catch (Throwable e) {
            throw new FalhaOperacaoDeBD("Falha ao Carregar todas as atividades");
        } finally {
            manager.close();
        }

    }

    @Override
    public Class<TbAtividade> getClasseTabela() {
        return TbAtividade.class;
    }

    private void validaEntrada(String titulo, String descricao, String codigoAtividade, TbProjeto projeto, TbFuncionario func, TbTipoAtividade novoTipoAtividade) throws FalhaGenerica {
        if (Validacao.verificaSeNull(titulo) || Validacao.verificaSeVazio(titulo)) {
            throw new FalhaOperacaoDeBD("Entrada NULL em DataAtividade");
        }
        if (Validacao.verificaSeNull(codigoAtividade) || Validacao.verificaSeVazio(codigoAtividade)) {
            throw new FalhaOperacaoDeBD("Entrada NULL em DataAtividade");
        }
        Validacao.verificaTabela(projeto);
        Validacao.verificaTabela(func);
        Validacao.verificaTabela(novoTipoAtividade);
    }

}
