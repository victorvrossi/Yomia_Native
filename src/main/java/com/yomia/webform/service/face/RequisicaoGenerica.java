package com.yomia.webform.service.face;

import com.yomia.modulo.falhas.FalhaSessaoNaoEncontrada;
import com.yomia.modulo.core.Atividade;
import com.yomia.modulo.falhas.FalhaDeIO;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.falhas.SaidaDeError;
import com.yomia.webform.sessao.SessaoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    public void printSaida(HttpServletResponse response, String texto) throws FalhaGenerica {
        try (PrintWriter out = response.getWriter()) {
            out.println(texto);
        } catch (IOException ex) {
            System.out.println("Falha de IO");
            throw new FalhaDeIO("Problemas na leitura de dados.").setMensagem(ex);
        }

    }

    public void geraSessaoComLogin(final HttpServletRequest request, SessaoUsuario usuarioSessao) {
        HttpSession session = verificaSeExisteSessao(request);
        Object n = session.getAttribute(SessaoUsuario.SESSAO_RESERVADA);
        if (n == null) {
            session.setAttribute(SessaoUsuario.SESSAO_RESERVADA, usuarioSessao);
            n = session.getAttribute(SessaoUsuario.SESSAO_RESERVADA);
        }
        System.out.println("geraSessaoComLogin>>" + ((SessaoUsuario) n).estaLogadoNoSistema());
    }
    
    public SessaoUsuario resgatarSessaoComLogin(final HttpServletRequest request) throws FalhaGenerica {
        HttpSession session = verificaSeExisteSessao(request);
        Object n = session.getAttribute(SessaoUsuario.SESSAO_RESERVADA);
        if (n == null) {
            throw new FalhaSessaoNaoEncontrada("Usuario não possui sessão Ativa no sistema").lancarError("USER", "Falha de Sessao", "Sessao para o usuario não foi encontrada. Faça login novamente.");
        }
        return (SessaoUsuario) n;
    }

    private HttpSession verificaSeExisteSessao(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null) {
            return request.getSession(true);
        }
//         if (request.getSession().getAttribute(SessaoUsuario.SESSAO_RESERVADA) == null) {
//            throw new FalhaSessaoNaoEncontrada("Usuario não possui sessão Ativa no sistema").lancarError("USER", "Falha de Sessao", "Sessao para o usuario não foi encontrada. Faça login novamente.");
//        }
        return session;
    }

}
