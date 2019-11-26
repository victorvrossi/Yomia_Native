package com.yomia.webform.requisicao;

import com.yomia.modulo.atividade.Atividade;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.falhas.SaidaDeError;
import com.yomia.webform.json.JsonInformeErro;
import com.yomia.webform.service.face.RequisicaoGenerica;
import com.yomia.webform.sessao.SessaoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequisicaoSolicitarLogin extends RequisicaoGenerica {

    @Override
    public void processaRequest(final HttpServletRequest request) {
        SessaoUsuario usuarioSessao = new SessaoUsuario();
        geraSessaoComLogin(request, usuarioSessao);
        String user = "admin";
        String password = "alfa";

        System.out.println("----------- LOGIN");
        if (!usuarioSessao.efetuaLogin(user, password)) {
            return;
        }

    }

    private void geraSessaoComLogin(final HttpServletRequest request, SessaoUsuario usuarioSessao) {
        HttpSession session = verificaSeExisteSessao(request);
        session.setAttribute(SessaoUsuario.SESSAO_RESERVADA, usuarioSessao);
    }

    @Override
    public void processaResponse(HttpServletResponse response) throws FalhaGenerica {
        //printSaida(response, saidaDeErro().gerarJson());        
    }

    private HttpSession verificaSeExisteSessao(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null) {
            return request.getSession(true);
        }
        return session;
    }

}
