package com.yomia.webform;

import com.yomia.webform.service.face.FormularioGenerico;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExecutaAcaoParaRequisicaoDoFormulario<T extends FormularioGenerico> {

    public void processaRequest(HttpServletRequest request) {
        ((FormularioGenerico) var).processaRequest(request);
    }

    private T var;

    public ExecutaAcaoParaRequisicaoDoFormulario(T var) {
        this.var = var;
    }

    void processaResponse(HttpServletResponse response) throws IOException {
         ((FormularioGenerico) var).processaResponse(response);
    }
}
