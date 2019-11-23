package com.yomia.webform.sessao;

import com.yomia.modulo.atividade.Funcionario;

public class SessaoUsuario {

    public static String SESSAO_RESERVADA ="sessao de usuario reservada";
    
    private boolean estaLogado = false;
    
    public void efetuaLogin(String user,String password){
        estaLogado = true;
    }
    public boolean estaLogadoNoSistema()
    {
        return estaLogado;
    }
    
    public Funcionario funcionarioLogado(){
        Funcionario m = new Funcionario();
        m.pesquisaPorNome("teste");
        return m;
    }

}
