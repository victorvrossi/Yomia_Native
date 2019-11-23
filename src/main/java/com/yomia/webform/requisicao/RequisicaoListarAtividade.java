package com.yomia.webform.requisicao;

import com.yomia.modulo.atividade.Atividade;
import com.yomia.webform.service.face.RequisicaoGenerica;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequisicaoListarAtividade extends RequisicaoGenerica {

    @Override
    public void processaRequest(final HttpServletRequest request) {
    }

    @Override
    public void processaResponse(HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        if (false) {
            listaAtividade(response);
        }
    }

    private void listaAtividade(HttpServletResponse response) {
        try (PrintWriter out = response.getWriter()) {
            out.println(new Atividade().geraListaJsonDeAtividades());
        } catch (IOException ex) {

        }
    }

}
