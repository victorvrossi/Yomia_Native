
package com.yomia.webform.requisicao;

import com.yomia.webform.service.face.RequisicaoGenerica;
import com.yomia.webform.json.JsonListarCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClienteListaTicket extends RequisicaoGenerica{

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
            
        }
    }
    
}
