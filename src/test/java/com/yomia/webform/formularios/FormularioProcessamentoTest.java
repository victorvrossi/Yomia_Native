package com.yomia.webform.formularios;

import com.yomia.webform.service.face.FormularioProcessamento;
import com.yomia.envoriment.Enviroment;
import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.yomia.webform.AcaoParaObjetoRequisicaoDoFormularioSimples;

public class FormularioProcessamentoTest {
    Enviroment.ObjetoTeste teste = new Enviroment().get();
    @Test
    public void testRequest() throws Exception {
        HttpServletRequest request = Enviroment.getMockRequest();
        AcaoParaObjetoRequisicaoDoFormularioSimples objeto = Enviroment.acaoParaObjetoDeTeste(teste);
        FormularioProcessamento instance = new FormularioProcessamento();
        instance.request(request, objeto);
        assertEquals("teste", teste.getTexto());
    }

    
}
