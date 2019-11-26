package com.yomia.webform;

import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.falhas.SaidaDeError;
import com.yomia.webform.service.face.RequisicaoGenerica;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletWebForm extends HttpServlet {

    RequisicaoGenerica processaUrlRetornaFormularioParaExecucao(HttpServletRequest request) throws FalhaGenerica {
        String URI = request.getRequestURI().replace("/form/", "");
        return EnumeracaoFormulariosSistema.retornaFormPorURI(URI);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (request == null) {
            return;
        }
        RequisicaoGenerica formularioParaExecutar = null;
        try {
            formularioParaExecutar = processaUrlRetornaFormularioParaExecucao(request);
        } catch (FalhaGenerica ex) {
            try {
                SaidaDeError.responseComSaidaDeErro(response, ex);
            } catch (Exception e) {
                System.err.println("Falha ao lançar erro:" + e);
            }
        }
        final ExecutaAcaoParaRequisicaoDoFormulario requisicao = new ExecutaAcaoParaRequisicaoDoFormulario(formularioParaExecutar);

        try {
            requisicao.processaRequest(request);
        } catch (FalhaGenerica ex) {
            try {
                SaidaDeError.responseComSaidaDeErro(response, ex);
            } catch (Exception e) {
                System.err.println("Falha ao lançar erro:" + e);
            }
        }

        try {
            requisicao.processaResponse(response);
        } catch (FalhaGenerica ex) {
            try {
                SaidaDeError.responseComSaidaDeErro(response, ex);
            } catch (Exception e) {
                System.err.println("Falha ao lançar erro:" + e);
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
