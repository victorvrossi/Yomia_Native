package com.yomia.webform;

import com.yomia.webform.service.face.RequisicaoGenerica;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExecutaAcaoParaRequisicaoDoFormulario<T extends RequisicaoGenerica> {

    public void processaRequest(HttpServletRequest request) {
        ((RequisicaoGenerica) var).processaRequest(request);
    }

    private T var;

    public ExecutaAcaoParaRequisicaoDoFormulario(T var) {
        this.var = var;
    }

    void processaResponse(HttpServletResponse response) throws IOException {
         ((RequisicaoGenerica) var).processaResponse(response);
    }
}
