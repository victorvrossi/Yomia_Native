
package com.yomia.webform.requisicao;

import com.yomia.jpa.dao.DaoStatus;
import com.yomia.modulo.core.Status;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.webform.json.JsonListarStatus;
import com.yomia.webform.json.model.CarregarDadosEmListaJson;
import com.yomia.webform.service.face.RequisicaoGenerica;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequisicaoListaStatus extends RequisicaoGenerica{

    @Override
    public void processaRequest(HttpServletRequest request) {}

    @Override
    public void processaResponse(HttpServletResponse response) throws FalhaGenerica {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(new CarregarDadosEmListaJson().listaTodosElementoEmJson( new Status(),new DaoStatus(), new JsonListarStatus()));
        } catch (IOException ex) {
            Logger.getLogger(RequisicaoListaStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
