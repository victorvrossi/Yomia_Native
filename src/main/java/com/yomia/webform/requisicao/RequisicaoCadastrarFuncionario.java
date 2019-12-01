package com.yomia.webform.requisicao;

import com.yomia.modulo.core.Funcionario;
import com.yomia.webform.service.face.RequisicaoGenerica;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequisicaoCadastrarFuncionario extends RequisicaoGenerica {

    @Override
    public void processaRequest(HttpServletRequest request) {
        String nome = request.getParameter("lb_titulo");
        System.out.println("Funci:" + nome);
        if (verificaDadosDeEntrada(new String[]{nome})) {
            new Funcionario().novo(nome);
        }

    }

    @Override
    public void processaResponse(HttpServletResponse response) {
        try (PrintWriter out = response.getWriter()) {
            out.println("OK Funci");
        } catch (IOException ex) {

        }
    }

}
