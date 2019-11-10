package com.yomia.modulo.atividade;

import com.yomia.webform.json.CarregaListaJson;
import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.dao.DaoAtividade;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbProjeto;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.jpa.entidade.TbStatusAtividade;
import com.yomia.webform.json.JsonAtividade;
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

    public String geraListaJsonDeAtividades() {
        CarregaListaJson json = new CarregaListaJson();
        return json.listaTodosElementoEmJson(DaoAtividade.class, JsonAtividade.class, Atividade.class);

    }

    public void cadastrarNovaAtividade(String titulo, String descricao, String tipo) {
        new DaoAtividade().novaAtividade(titulo, "PARIO-005", descricao,  new TbProjeto(1),null,null,null);
    }

    @Override
    public Entidade converteTabelaParaObjeto(BaseEntidade bt) {
        TbAtividade tb = (TbAtividade) bt;
        titulo = tb.getTitulo();
        descricao = tb.getDescricao();
        codigoAtividade = tb.getCodigoAtividade();
        tipo.setTitulo(tb.getIdTipoAtividade().getTitulo());
        dataCriacao = tb.getDataCriacao();
        status = tb.getTbStatusAtividade().getIdStatus().getTitulo();
        if (status == null || status.equals("")) {
            throw new NullPointerException("Falha ao carregar Status da atividade:" + tb.getId()+" StatusTB:"+tb.getTbStatusAtividade().getId()+">>"+tb.getTbStatusAtividade().getIdStatus());
        }

        String nomeResponsavel = tb.getIdResponsavel().getNome();
        responsavel.setNome(nomeResponsavel);

        return this;
    }

}
