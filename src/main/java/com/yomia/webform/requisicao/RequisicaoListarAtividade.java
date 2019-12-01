package com.yomia.webform.requisicao;

import com.yomia.modulo.atividade.Atividade;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.webform.service.face.RequisicaoGenerica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequisicaoListarAtividade extends RequisicaoGenerica {

    @Override
    public void processaRequest(final HttpServletRequest request) throws FalhaGenerica {
    }

    @Override
    public void processaResponse(HttpServletResponse response) throws FalhaGenerica {
        String lista = "";
        try {
            lista = listaAtividade();
            printSaida(response, lista);
        } catch (FalhaGenerica ex) {
            throw ex;
        }
    }

    private String listaAtividade() throws FalhaGenerica {
        return new Atividade().geraListaJsonDeAtividadesParaDataTable();
    }

}
