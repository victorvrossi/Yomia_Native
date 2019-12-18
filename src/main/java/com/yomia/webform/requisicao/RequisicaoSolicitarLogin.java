package com.yomia.webform.requisicao;

import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.webform.service.face.RequisicaoGenerica;
import com.yomia.webform.sessao.SessaoUsuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequisicaoSolicitarLogin extends RequisicaoGenerica {

    @Override
    public void processaRequest(final HttpServletRequest request) {
        SessaoUsuario usuarioSessao = new SessaoUsuario();
        geraSessaoComLogin(request, usuarioSessao);
        String user = "admin";
        String password = "alfa";

        System.out.println("----------- LOGIN" + usuarioSessao.estaLogadoNoSistema());
        if (!usuarioSessao.efetuaLogin(user, password)) {
            return;
        }

    }

    @Override
    public void processaResponse(HttpServletResponse response) throws FalhaGenerica {
    }

}
