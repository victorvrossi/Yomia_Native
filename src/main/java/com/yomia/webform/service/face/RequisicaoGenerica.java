package com.yomia.webform.service.face;

import com.yomia.modulo.atividade.Atividade;
import com.yomia.modulo.falhas.FalhaDeIO;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.falhas.SaidaDeError;
import com.yomia.webform.sessao.SessaoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequisicaoGenerica implements InterfaceFormularioHTTP {
    private SaidaDeError saidaDeErro = new SaidaDeError();

    public SaidaDeError saidaDeErro() {
        return saidaDeErro;
    }
    
    public void verificaLoginNoSistema(HttpServletRequest request) throws FalhaGenerica {
        verificaSeExisteSessao(request);
    }

    public boolean verificaDadosDeEntrada(String parametros[]) {
        for (String p : parametros) {
            if (p == null || p.equals("")) {
                return false;
            }
        }
        return true;
    }

    private void verificaSeExisteSessao(HttpServletRequest request) throws FalhaGenerica {
        if (request.getSession().getAttribute(SessaoUsuario.SESSAO_RESERVADA) == null) {
            throw new FalhaSessaoNaoEncontrada("Usuario não possui sessão Ativa no sistema").lancarError("USER", "Falha de Sessao", "Sessao para o usuario não foi encontrada. Faça login novamente.");
        }
    }
    
    public void printSaida(HttpServletResponse response,String texto) throws FalhaGenerica{
        try (PrintWriter out = response.getWriter()) {
            out.println(texto);
        } catch (IOException ex) {
            System.out.println("Falha de IO");
            throw new FalhaDeIO("Problemas na leitura de dados.").setMensagem(ex);
        }
        
    }

}
