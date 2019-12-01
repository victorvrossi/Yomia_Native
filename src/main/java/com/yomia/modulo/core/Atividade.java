package com.yomia.modulo.core;

import com.yomia.modulo.saida.ModeloParaSaidaEmJson;
import com.yomia.webform.json.model.CarregaListaJson;
import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.dao.DaoAtividade;
import com.yomia.jpa.dao.DaoFuncionario;
import com.yomia.jpa.dao.DaoTipoAtividade;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbFuncionario;
import com.yomia.jpa.entidade.TbProjeto;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.jpa.entidade.TbStatusAtividade;
import com.yomia.jpa.entidade.TbTipoAtividade;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.webform.json.JsonListarAtividades;
import java.util.Date;
import java.util.List;

public class Atividade  extends Entidade{

    String titulo;
    String descricao;
    String codigoAtividade;
    TipoAtividade tipo = new TipoAtividade();
    Funcionario responsavel = new Funcionario();
    Projeto projetoGestor = new Projeto();
    private Date dataCriacao;

    String status = "Nenhum status definido";

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigoAtividade() {
        return codigoAtividade;
    }

    public String getTipo() {
        return tipo.getTitulo();
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public Projeto getProjetoGestor() {
        return projetoGestor;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public String getStatus() {
        return status;
    }

    
    


    public void cadastrarNovaAtividade(String titulo, String descricao, String tipo,Funcionario responsavel) throws FalhaGenerica {
        final TbTipoAtividade tipoAtividade = new DaoTipoAtividade().carregaTipoAtividadePorTitulo(tipo);

        ;
        DaoFuncionario daoFuncionario = new DaoFuncionario();
        List<TbFuncionario>  l = daoFuncionario.pesquisaPorNome(responsavel.getNome());
        if(l.size()<1){
            throw new FalhaGenerica("").lancarError("Falha", "Erro", "Problema de funcionario");
        }
        TbFuncionario funcionario = l.get(0);
        TbStatus status = new TbStatus(1);
        TbProjeto tbProjeto = new TbProjeto(1);
        String codigo = tbProjeto.getSigla();
        new DaoAtividade().novaAtividade(titulo, "PARIO-005", descricao, tbProjeto, status, tipoAtividade, funcionario);
    }

    @Override
    public Entidade converteTabelaParaObjeto(BaseEntidade bt) {
        TbAtividade tb = (TbAtividade) bt;
        if (tb == null) {
            return this;
        }
        try {

            final TbTipoAtividade idTipoAtividade = tb.getIdTipoAtividade();
            final TbStatusAtividade tbStatusAtividade = tb.getTbStatusAtividade();
            if (idTipoAtividade == null || tbStatusAtividade == null) {
                return this;
            }
            titulo = tb.getTitulo();
            descricao = tb.getDescricao();
            codigoAtividade = tb.getCodigoAtividade();

            tipo.setTitulo(idTipoAtividade.getTitulo());
            dataCriacao = tb.getDataCriacao();

            status = tbStatusAtividade.getIdStatus().getTitulo();
            String nomeResponsavel = tb.getIdResponsavel().getNome();
            responsavel.setNome(nomeResponsavel);

            if (status == null || status.equals("")) {
                throw new NullPointerException("Falha ao carregar Status da atividade:" + tb.getId() + " StatusTB:" + tb.getTbStatusAtividade().getId() + ">>" + tb.getTbStatusAtividade().getIdStatus());
            }
        } catch (Exception e) {
            System.out.println("Falhou ao carregar atividade:" + e);
        }

        return this;
    }

}
