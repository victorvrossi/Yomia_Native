package com.yomia.webform;

import com.yomia.webform.formularios.face.FormularioGenerico;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExecutaAcaoParaRequisicaoDoFormulario<T extends FormularioGenerico> {

    public void processaRequest(HttpServletRequest request) {
        ((FormularioGenerico) var).processaEntradaRequest(request);
    }

    private T var;

    public ExecutaAcaoParaRequisicaoDoFormulario(T var) {
        this.var = var;
    }

    public void see() {

    }

    void processaResponse(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("OK Estou no response");
            System.out.println("Passei pelo out");
        }
    }
}
