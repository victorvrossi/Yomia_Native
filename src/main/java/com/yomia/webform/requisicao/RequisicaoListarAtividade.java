package com.yomia.webform.requisicao;

import com.yomia.jpa.dao.DaoAtividade;
import com.yomia.modulo.core.Atividade;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.saida.dataTable.ProcessaJsonAtividadeParaDataTable;
import com.yomia.webform.json.model.CarregarDadosEmListaJson;
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
        return new CarregarDadosEmListaJson().listaTodosElementoEmJsonParaDataTable(new DaoAtividade(), new ProcessaJsonAtividadeParaDataTable());
    }

}
