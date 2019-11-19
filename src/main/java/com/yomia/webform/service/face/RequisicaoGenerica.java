package com.yomia.webform.service.face;

import com.yomia.modulo.falhas.FalhaAoExecutarAcaoParaRequisicaoDoFormulario;
import com.yomia.modulo.falhas.FalhaHTTPRequestEstaNulo;
import com.yomia.webform.ExecutaAcaoParaRequisicaoDoFormulario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import com.yomia.webform.AcaoParaObjetoRequisicaoDoFormularioSimples;

public abstract class RequisicaoGenerica implements InterfaceFormularioHTTP {

    public static void processaRequest(HttpServletRequest request, AcaoParaObjetoRequisicaoDoFormularioSimples objeto) {
        try {
            validaParaProcessa(request,objeto);
            FormularioProcessamento h = new FormularioProcessamento();
            h.request(request, objeto);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ExecutaAcaoParaRequisicaoDoFormulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void validaParaProcessa(HttpServletRequest request,AcaoParaObjetoRequisicaoDoFormularioSimples objeto) throws FalhaAoExecutarAcaoParaRequisicaoDoFormulario {
        if (objeto == null) {
            throw new FalhaAoExecutarAcaoParaRequisicaoDoFormulario("Acao para executar o Objeto do Serviço Inválido." );
        }
        if (request == null) {
            throw new FalhaHTTPRequestEstaNulo();
        }
    }
}
