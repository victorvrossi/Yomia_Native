package com.yomia.modulo.atividade;

import com.yomia.jpa.dao.DaoFuncionario;

public class Funcionario {

    private String nome;

    void setNome(String nomeResponsavel) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public void novo(String nome){
        new DaoFuncionario().novoFuncionario(nome);
    }
    

}
