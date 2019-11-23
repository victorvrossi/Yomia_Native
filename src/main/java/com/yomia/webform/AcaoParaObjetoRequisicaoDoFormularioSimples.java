package com.yomia.webform;

import javax.servlet.http.HttpServletRequest;

public abstract class AcaoParaObjetoRequisicaoDoFormularioSimples {

    public abstract void executarAcao(HttpServletRequest request);

    public boolean verificaDadosDeEntrada(String parametros[]) {
        for (String p : parametros) {
            if (p == null || p.equals("")) {
                return false;
            }
        }
        return true;
    }

}
