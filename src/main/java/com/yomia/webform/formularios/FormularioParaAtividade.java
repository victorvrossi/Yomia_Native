package com.yomia.webform.formularios;

import com.yomia.webform.formularios.face.FormularioGenerico;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yomia.webform.AcaoParaObjetoRequisicaoDoFormularioSimples;

public class FormularioParaAtividade extends FormularioGenerico {

    @Override
    public void processaEntradaRequest(final HttpServletRequest request) {        
        AcaoParaObjetoRequisicaoDoFormularioSimples formObjeto = new AcaoParaObjetoRequisicaoDoFormularioSimples() {
            @Override
            public void executarAcao(HttpServletRequest request) {
                final String titulo = request.getParameter("lb_n_titulo");
                final String descricao = request.getParameter("tx_n_descricao");
                System.out.println(">>"+titulo+">>"+descricao);
            }
        };
        processaRequest(request, formObjeto);
    }
    
}
