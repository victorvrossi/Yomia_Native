package com.yomia.webform;

import com.yomia.envoriment.Enviroment;
import com.yomia.webform.service.face.FormularioGenerico;
import com.yomia.webform.formularios.*;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Assert;
import com.yomia.webform.AcaoParaObjetoRequisicaoDoFormularioSimples;

public class FormularioParaTeste extends FormularioGenerico {

    Enviroment.ObjetoTeste teste;

    FormularioParaTeste(Enviroment.ObjetoTeste teste) {
        this.teste = teste;
    }

    @Override
    public void processaRequest(final HttpServletRequest request) {
        AcaoParaObjetoRequisicaoDoFormularioSimples formObjeto = Enviroment.acaoParaObjetoComplexo(teste);
        processaRequest(request, formObjeto);
    }

    @Override
    public void processaResponse(HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
