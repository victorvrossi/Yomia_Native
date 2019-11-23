package com.yomia.webform.requisicao;

import com.yomia.modulo.atividade.Status;
import com.yomia.webform.service.face.RequisicaoGenerica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequisicaoCadastroStatus extends RequisicaoGenerica {

    @Override
    public void processaRequest(HttpServletRequest request) {
        try {
            String statusAtividade = request.getParameter("lb_titulo");
            System.out.println("Req Status:" + statusAtividade);
            if (verificaDadosDeEntrada(new String[]{statusAtividade})) {
                new Status().novoStatus(statusAtividade);
            }

        } catch (Exception ex) {

        }

    }

    @Override
    public void processaResponse(HttpServletResponse response) {

    }

}
