package com.yomia.webform.requisicao;

import com.yomia.modulo.core.TipoAtividade;
import com.yomia.webform.service.face.RequisicaoGenerica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequisicaoCadastroTipoAtividade extends RequisicaoGenerica {

    @Override
    public void processaRequest(HttpServletRequest request) {
        String tipoAtividade = request.getParameter("lb_titulo");
        if (verificaDadosDeEntrada(new String[]{tipoAtividade})) {
            new TipoAtividade().novoTipoAtividade(tipoAtividade);
        }
    }

    @Override
    public void processaResponse(HttpServletResponse response) {

    }

}
