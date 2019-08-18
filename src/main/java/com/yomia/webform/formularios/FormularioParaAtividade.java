package com.yomia.webform.formularios;

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yomia.webform.AcaoParaObjetoRequisicaoDoFormularioSimples;

public class FormularioParaAtividade extends FormularioGenerico {

    @Override
    public void processaEntradaRequest(final HttpServletRequest request) {        
        AcaoParaObjetoRequisicaoDoFormularioSimples formObjeto = new AcaoParaObjetoRequisicaoDoFormularioSimples() {
            @Override
            public void executarAcao(HttpServletRequest request,Iterator<String> asIterator) {
            }
        };
        processaRequest(request, formObjeto);
    }
    
}
