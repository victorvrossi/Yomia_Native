
package com.yomia.webform.requisicao;

import com.yomia.modulo.core.Status;
import com.yomia.modulo.core.TipoAtividade;
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
    public void processaResponse(HttpServletResponse response) {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //out.println(new Status().carregaLista());
        } catch (IOException ex) {
            Logger.getLogger(RequisicaoListaStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
