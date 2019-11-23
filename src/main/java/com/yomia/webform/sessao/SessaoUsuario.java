package com.yomia.webform.sessao;

import com.yomia.modulo.atividade.Funcionario;

public class SessaoUsuario {
    
    public Funcionario funcionarioLogado(){
        Funcionario m = new Funcionario();
        m.pesquisaPorNome("teste");
        return m;
    }

}
