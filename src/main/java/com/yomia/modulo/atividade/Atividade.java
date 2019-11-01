package com.yomia.modulo.atividade;

import com.yomia.jpa.dao.DaoAtividade;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbProjeto;
import com.yomia.webform.json.JsonAtividade;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class Atividade {

    String titulo;
    String descricao;
    String codigoAtividade;
    TipoAtividade tipo = new TipoAtividade();
    Funcionario responsavel = new Funcionario();
    Projeto projetoGestor = new Projeto();

    public Atividade converteTabelaParaObjeto(TbAtividade tb) {
        titulo = tb.getTitulo();
        descricao = tb.getDescricao();
        codigoAtividade = tb.getCodigoAtividade();
        tipo.setTitulo(tb.getIdTipoAtividade().getTitulo());

        String nomeResponsavel = tb.getIdResponsavel().getNome();

        return this;
    }

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

    public String listaAtividade(HttpServletResponse response) {
        ArrayList<JsonAtividade> listaDeAtividadeJson = new ArrayList<>();
        DaoAtividade daoAtividade = new DaoAtividade();
        List<TbAtividade> atividadesCarregadasBancoDeDados = daoAtividade.carregarTodasAtividades();
        System.out.println("Lista atividade:"+atividadesCarregadasBancoDeDados.toString());
        for (TbAtividade atividade : atividadesCarregadasBancoDeDados) {
            Atividade atv = new Atividade().converteTabelaParaObjeto(atividade);
            listaDeAtividadeJson.add(JsonAtividade.converte(atv));
        }
        return new JsonAtividade().formarJsonComLista(listaDeAtividadeJson);

    }

    public void cadastrarNovaAtividade(String titulo,String descricao,String tipo ) {
        new DaoAtividade().novaAtividade(titulo, "PARIO-005", descricao,tipo, new TbProjeto(1));
    }
}
