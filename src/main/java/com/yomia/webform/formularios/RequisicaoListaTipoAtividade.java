
package com.yomia.webform.formularios;

import com.yomia.modulo.atividade.TipoAtividade;
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
    public void processaResponse(HttpServletResponse response) {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(new TipoAtividade().carregaLista());
            System.out.println("Passei pelo out");
        } catch (IOException ex) {
            Logger.getLogger(RequisicaoListaTipoAtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
