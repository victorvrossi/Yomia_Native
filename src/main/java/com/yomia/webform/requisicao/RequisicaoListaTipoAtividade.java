
package com.yomia.webform.requisicao;

import com.yomia.jpa.dao.DaoTipoAtividade;
import com.yomia.modulo.core.TipoAtividade;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.webform.json.model.CarregaListaJson;
import com.yomia.webform.json.JsonListarTipoAtividade;
import com.yomia.webform.service.face.RequisicaoGenerica;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequisicaoListaTipoAtividade extends RequisicaoGenerica{

    @Override
    public void processaRequest(HttpServletRequest request) {}

    @Override
    public void processaResponse(HttpServletResponse response) throws FalhaGenerica {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(new CarregaListaJson().listaTodosElementoEmJson(DaoTipoAtividade.class, JsonListarTipoAtividade.class, TipoAtividade.class));
        } catch (IOException ex) {
            Logger.getLogger(RequisicaoListaTipoAtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
