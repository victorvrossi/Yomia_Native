package com.yomia.webform.formularios.face;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import com.yomia.webform.AcaoParaObjetoRequisicaoDoFormularioSimples;

public class FormularioProcessamento {

    public void request(HttpServletRequest request, AcaoParaObjetoRequisicaoDoFormularioSimples objeto)
            throws ServletException, IOException {
        objeto.executarAcao(request);
    }

}
