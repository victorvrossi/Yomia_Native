package com.yomia.webform;

import com.yomia.webform.formularios.FormularioGenerico;
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
}
