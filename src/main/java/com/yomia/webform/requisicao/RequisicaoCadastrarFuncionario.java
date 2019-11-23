package com.yomia.webform.requisicao;

import com.yomia.modulo.atividade.Atividade;
import com.yomia.modulo.atividade.Funcionario;
import com.yomia.webform.AcaoParaObjetoRequisicaoDoFormularioSimples;
import com.yomia.webform.service.face.RequisicaoGenerica;
import static com.yomia.webform.service.face.RequisicaoGenerica.processaRequest;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequisicaoCadastrarFuncionario extends RequisicaoGenerica {

    @Override
    public void processaRequest(HttpServletRequest request) {
        AcaoParaObjetoRequisicaoDoFormularioSimples formObjeto = new AcaoParaObjetoRequisicaoDoFormularioSimples() {
            @Override
            public void executarAcao(HttpServletRequest request) {
                String nome = request.getParameter("lb_titulo");
                System.out.println("Funci:"+nome);
                if (verificaDadosDeEntrada(new String[]{nome})) {
                    new Funcionario().novo(nome);
                }

            }
        };
        processaRequest(request, formObjeto);
    }

    @Override
    public void processaResponse(HttpServletResponse response) {
        try (PrintWriter out = response.getWriter()) {
            out.println("OK Funci");
        } catch (IOException ex) {

        }
    }

}
