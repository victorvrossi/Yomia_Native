package com.yomia.webform;

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
    public void processaEntradaRequest(final HttpServletRequest request) {
        AcaoParaObjetoRequisicaoDoFormularioSimples formObjeto = Enviroment.acaoParaObjetoComplexo(teste);
        processaRequest(request, formObjeto);
    }

}
