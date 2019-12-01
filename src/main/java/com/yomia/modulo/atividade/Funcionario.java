package com.yomia.modulo.atividade;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.dao.DaoFuncionario;
import com.yomia.jpa.entidade.TbFuncionario;
import java.util.List;

public class Funcionario extends Entidade {

    private String nome;

    void setNome(String nomeResponsavel) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void novo(String nome) {
        new DaoFuncionario().novoFuncionario(nome);
    }

    public Funcionario pesquisaPorNome(String teste) {
        final List<TbFuncionario> pesquisaPorNome = new DaoFuncionario().pesquisaPorNome(teste);
        if (pesquisaPorNome.size() > 0) {
            return (Funcionario) converteTabelaParaObjeto(pesquisaPorNome.get(0));
        }
        return null;

    }

    @Override
    public Entidade converteTabelaParaObjeto(BaseEntidade tb) {
        TbFuncionario k = (TbFuncionario) tb;
        nome = k.getNome();
        return this;
    }


}
