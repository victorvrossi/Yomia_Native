package com.yomia.webform.requisicao;

import com.yomia.webform.service.face.RequisicaoGenerica;
import com.yomia.webform.sessao.SessaoUsuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequisicaoSolicitarLogin extends RequisicaoGenerica{

    @Override
    public void processaRequest(final HttpServletRequest request) {
        HttpSession session = verificaSeExisteSessao(request);
        SessaoUsuario usuarioSessao = new SessaoUsuario();
        session.setAttribute(SessaoUsuario.SESSAO_RESERVADA,usuarioSessao );
    }

    @Override
    public void processaResponse(HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
    }

    private HttpSession verificaSeExisteSessao(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session == null){
            return request.getSession(true);
        }
        return session;
    }



}
