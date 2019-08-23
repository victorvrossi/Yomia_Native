package com.yomia.webform.formularios;

import com.yomia.webform.formularios.face.FormularioGenerico;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yomia.webform.AcaoParaObjetoRequisicaoDoFormularioSimples;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FormularioParaAtividade extends FormularioGenerico {

    @Override
    public void processaRequest(final HttpServletRequest request) {
        AcaoParaObjetoRequisicaoDoFormularioSimples formObjeto = new AcaoParaObjetoRequisicaoDoFormularioSimples() {
            @Override
            public void executarAcao(HttpServletRequest request) {
                final String titulo = request.getParameter("lb_n_titulo");
                final String descricao = request.getParameter("tx_n_descricao");
                System.out.println(">>" + titulo + ">>" + descricao);
            }
        };
        processaRequest(request, formObjeto);
    }

    @Override
    public void processaResponse(HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("OK Estou no response");
            System.out.println("Passei pelo out");
        } catch (IOException ex) {
            Logger.getLogger(FormularioParaAtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
