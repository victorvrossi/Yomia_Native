package com.yomia.webform.sessao;

import com.yomia.modulo.core.Funcionario;

public class SessaoUsuario {

    public static String SESSAO_RESERVADA = "sessao de usuario reservada";

    private boolean estaLogado = false;
    Funcionario funcionarioLogado = new Funcionario();
    

    public boolean efetuaLogin(String user, String password) {
        estaLogado = true;
        
        Funcionario k = funcionarioLogado.pesquisaPorNome("teste");
        if(k == null){
            System.out.println("Cadastro do nvo Teste");
            funcionarioLogado.novo("teste");    
        }
        return estaLogado;
    }

    public boolean estaLogadoNoSistema() {
        return estaLogado;
    }

    public Funcionario funcionarioLogado() {
        return funcionarioLogado;
    }

}
