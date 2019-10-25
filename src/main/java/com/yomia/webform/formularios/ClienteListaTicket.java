
package com.yomia.webform.formularios;

import com.yomia.modulo.atividade.Atividade;
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
            String t;
            ArrayList<JsonClienteLista>aa = new ArrayList<>();
            ArrayList<Atividade> lista = null;
            for (Atividade atividade : lista) {
                //aa.add(JsonClienteLista.converte(atividade));
            }
            
            t = new JsonClienteLista().jsonList(aa);
            out.println(""+t);
            //System.out.println("Passei pelo out:"+t);
        } catch (IOException ex) {
            Logger.getLogger(FormularioParaAtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
