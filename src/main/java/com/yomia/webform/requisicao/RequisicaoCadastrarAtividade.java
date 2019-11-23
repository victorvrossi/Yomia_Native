package com.yomia.webform.requisicao;

import com.yomia.modulo.atividade.Atividade;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.webform.service.face.RequisicaoGenerica;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequisicaoCadastrarAtividade extends RequisicaoGenerica {

    @Override
    public void processaRequest(final HttpServletRequest request) {
        acaoCadastroRequest(request);
    }

    @Override
    public void processaResponse(HttpServletResponse response) {
    }

    private void acaoCadastroRequest(HttpServletRequest request) {
        final String titulo = request.getParameter("lb_titulo");
        final String descricao = request.getParameter("lb_descricao");
        final String tipo = request.getParameter("selecttipoativi");
        if (verificaDadosDeEntrada(new String[]{tipo, titulo, descricao})) {
            try {
                new Atividade().cadastrarNovaAtividade(titulo, descricao, tipo);
            } catch (FalhaGenerica ex) {
                Logger.getLogger(RequisicaoCadastrarAtividade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
