package com.yomia.webform.formularios;

import com.yomia.modulo.atividade.Atividade;
import com.yomia.webform.AcaoParaObjetoRequisicaoDoFormularioSimples;
import com.yomia.webform.service.face.FormularioGenerico;
import static com.yomia.webform.service.face.FormularioGenerico.processaRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormularioAtividade extends FormularioGenerico {

    AcaoFormulario acao = AcaoFormulario.NENHUMA;

    public FormularioAtividade(AcaoFormulario acao) {
        this.acao = acao;
    }

    @Override
    public void processaRequest(final HttpServletRequest request) {
        acaoCadastroRequest(request);
        avancaStatus(request);
    }

    @Override
    public void processaResponse(HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        listaAtividade(response);
    }

    private void acaoCadastroRequest(HttpServletRequest request) {
        if (!AcaoFormulario.CADASTRAR.equals(acao)) {
            return;
        }
        AcaoParaObjetoRequisicaoDoFormularioSimples formObjeto = new AcaoParaObjetoRequisicaoDoFormularioSimples() {
            @Override
            public void executarAcao(HttpServletRequest request) {
                try {
                    final String titulo = request.getParameter("lb_titulo");
                    final String descricao = request.getParameter("lb_descricao");
                    final String tipo = request.getParameter("selecttipoativi");
                    
                    new Atividade().cadastrarNovaAtividade(titulo, descricao,tipo);
                } catch (Exception ex) {
                    Logger.getLogger(FormularioAtividade.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        processaRequest(request, formObjeto);
    }

    private void listaAtividade(HttpServletResponse response) {
        if (!AcaoFormulario.LISTAR.equals(acao)) {
            return;
        }
        try (PrintWriter out = response.getWriter()) {
            out.println(new Atividade().listaAtividade(response));
        } catch (IOException ex) {
            Logger.getLogger(FormularioAtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void avancaStatus(HttpServletRequest request) {
        if (!AcaoFormulario.AVANCAR_STATUS.equals(acao)) {
            return;
        }
        AcaoParaObjetoRequisicaoDoFormularioSimples formObjeto = new AcaoParaObjetoRequisicaoDoFormularioSimples() {
            @Override
            public void executarAcao(HttpServletRequest request) {
                try {
                    String titulo = request.getParameter("atividade");
                    System.out.println("Avanca Status atividade:"+titulo);
                    titulo = request.getParameter("tvt");
                    System.out.println("Avanca Status atividade:"+titulo);
                } catch (Exception ex) {
                    Logger.getLogger(FormularioAtividade.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        processaRequest(request, formObjeto);
        
    }

}
