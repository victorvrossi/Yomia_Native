package com.yomia.webform.requisicao;

import com.yomia.modulo.core.Status;
import com.yomia.modulo.core.acoes.GerenciarStatus;
import com.yomia.webform.service.face.RequisicaoGenerica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequisicaoCadastroStatus extends RequisicaoGenerica {

    @Override
    public void processaRequest(HttpServletRequest request) {
        String statusAtividade = request.getParameter("lb_titulo");
        if (verificaDadosDeEntrada(new String[]{statusAtividade})) {
            GerenciarStatus.cadastrar(statusAtividade);
        }
    }

    @Override
    public void processaResponse(HttpServletResponse response) {

    }

}
