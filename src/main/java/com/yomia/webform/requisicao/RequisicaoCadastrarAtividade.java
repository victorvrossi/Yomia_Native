package com.yomia.webform.requisicao;

import com.yomia.modulo.core.Atividade;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.webform.service.face.RequisicaoGenerica;
import com.yomia.webform.sessao.SessaoUsuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequisicaoCadastrarAtividade extends RequisicaoGenerica {

    @Override
    public void processaRequest(final HttpServletRequest request) throws FalhaGenerica {
        acaoCadastroRequest(request);
    }

    @Override
    public void processaResponse(HttpServletResponse response) throws FalhaGenerica {
    }

    private void acaoCadastroRequest(HttpServletRequest request) throws FalhaGenerica {
        final String titulo = request.getParameter("lb_titulo");
        final String descricao = request.getParameter("lb_descricao");
        final String tipo = request.getParameter("selecttipoativi");
        if (verificaDadosDeEntrada(new String[]{tipo, titulo, descricao})) {
            final SessaoUsuario login = resgatarSessaoComLogin(request);
            new Atividade().cadastrarNovaAtividade(titulo, descricao, tipo, login.funcionarioLogado());
        }

    }

}
