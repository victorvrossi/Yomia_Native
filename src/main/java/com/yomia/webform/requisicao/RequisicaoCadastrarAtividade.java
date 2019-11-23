package com.yomia.webform.requisicao;

import com.yomia.modulo.atividade.Atividade;
import com.yomia.webform.AcaoParaObjetoRequisicaoDoFormularioSimples;
import com.yomia.webform.service.face.RequisicaoGenerica;
import static com.yomia.webform.service.face.RequisicaoGenerica.processaRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequisicaoCadastrarAtividade extends RequisicaoGenerica {

    @Override
    public void processaRequest(final HttpServletRequest request) {
        acaoCadastroRequest(request);
    }

    @Override
    public void processaResponse(HttpServletResponse response) {
    }

    private void acaoCadastroRequest(HttpServletRequest request) {
        AcaoParaObjetoRequisicaoDoFormularioSimples formObjeto = new AcaoParaObjetoRequisicaoDoFormularioSimples() {
            @Override
            public void executarAcao(HttpServletRequest request) {
                final String titulo = request.getParameter("lb_titulo");
                final String descricao = request.getParameter("lb_descricao");
                final String tipo = request.getParameter("selecttipoativi");
                if (verificaDadosDeEntrada(new String[]{tipo,titulo,descricao})) {
                    new Atividade().cadastrarNovaAtividade(titulo, descricao, tipo);
                }

            }
        };
        processaRequest(request, formObjeto);
    }

}
