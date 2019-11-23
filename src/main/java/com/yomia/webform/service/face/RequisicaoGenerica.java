package com.yomia.webform.service.face;

public abstract class RequisicaoGenerica implements InterfaceFormularioHTTP {

    public void verificaLoginNoSistema() {

    }

    public boolean verificaDadosDeEntrada(String parametros[]) {
        for (String p : parametros) {
            if (p == null || p.equals("")) {
                return false;
            }
        }
        return true;
    }

  
}
