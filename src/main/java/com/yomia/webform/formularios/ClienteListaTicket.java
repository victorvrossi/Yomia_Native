
package com.yomia.webform.formularios;

import com.yomia.webform.service.face.FormularioGenerico;
import com.yomia.webform.json.JsonClienteLista;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClienteListaTicket extends FormularioGenerico{

    @Override
    public void processaRequest(HttpServletRequest request) {
        
    }

    @Override
    public void processaResponse(HttpServletResponse response) {
         t(response);
    }

    private void t(HttpServletResponse response) {
        try (PrintWriter out = response.getWriter()) {
           
            //System.out.println("Passei pelo out:"+t);
        } catch (IOException ex) {
            Logger.getLogger(FormularioParaAtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
