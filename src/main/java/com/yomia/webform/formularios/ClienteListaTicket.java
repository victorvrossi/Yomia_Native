
package com.yomia.webform.formularios;

import com.yomia.webform.formularios.face.FormularioGenerico;
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
            JsonClienteLista user = new JsonClienteLista();
            user.setData("hoje");
            user.setDescricao("ok");
            user.setStatus("Aberto");
            user.setTitulo("Teste");
            String t = new JsonClienteLista().json(user);
            
            
            ArrayList<JsonClienteLista>aa = new ArrayList<>();
            for(int k=0;k<100;k++){
                aa.add(user);
            }
            
            
            t = new JsonClienteLista().jsonList(aa);
            out.println(""+t);
            //System.out.println("Passei pelo out:"+t);
        } catch (IOException ex) {
            Logger.getLogger(FormularioParaAtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
