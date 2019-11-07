package com.yomia.modulo.atividade;

import com.yomia.webform.json.CarregaListaJson;
import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.dao.DaoAtividade;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbProjeto;
import com.yomia.jpa.entidade.TbStatusAtividade;
import java.util.Date;

public class Atividade extends Entidade {

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

    public String listaAtividade() {
        return new CarregaListaJson().listaTodosElementoEmJson(new DaoAtividade());

    }

    public void cadastrarNovaAtividade(String titulo, String descricao, String tipo) {
        new DaoAtividade().novaAtividade(titulo, "PARIO-005", descricao, tipo, new TbProjeto(1));
    }

    @Override
    public Atividade converteTabelaParaObjeto(BaseEntidade bt) {
        TbAtividade tb = (TbAtividade) bt;
        titulo = tb.getTitulo();
        descricao = tb.getDescricao();
        codigoAtividade = tb.getCodigoAtividade();
        tipo.setTitulo(tb.getIdTipoAtividade().getTitulo());
        dataCriacao = tb.getDataCriacao();

        TbStatusAtividade statusAtividade = tb.getTbStatusAtividade();

        if (statusAtividade != null) {
            status = statusAtividade.getIdStatus().getTitulo();
        }
        if (status.equals("")) {
            throw new NullPointerException("Falha ao carregar Status da atividade");
        }

        String nomeResponsavel = tb.getIdResponsavel().getNome();
        responsavel.setNome(nomeResponsavel);

        return this;
    }

}
