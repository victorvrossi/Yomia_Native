package com.yomia.webform.requisicao;

import com.yomia.webform.service.face.RequisicaoGenerica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequisicaoAvancarStatusAtividade extends RequisicaoGenerica{

    @Override
    public void processaRequest(final HttpServletRequest request) {}

    @Override
    public void processaResponse(HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
    }



}
