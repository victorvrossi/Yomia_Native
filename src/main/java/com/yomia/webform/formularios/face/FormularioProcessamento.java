package com.yomia.webform.formularios.face;

import java.io.IOException;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import com.yomia.webform.AcaoParaObjetoRequisicaoDoFormularioSimples;

public class FormularioProcessamento {

    public void request(HttpServletRequest request, AcaoParaObjetoRequisicaoDoFormularioSimples objeto)
            throws ServletException, IOException {
        validaParaProcessa(request, objeto);
        objeto.executarAcao(request);
    }

    public static void validaParaProcessa(HttpServletRequest request, AcaoParaObjetoRequisicaoDoFormularioSimples objeto) throws FalhaAoExecutarAcaoParaRequisicaoDoFormulario {
        if (objeto == null) {
            throw new FalhaAoExecutarAcaoParaRequisicaoDoFormulario("Acao para executar o Objeto do Formulario Invalido.");
        }
        if (request == null) {
            throw new FalhaHTTPRequestEstaNulo();
        }
    }
}
