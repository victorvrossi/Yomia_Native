package com.yomia.webform;

import com.yomia.envoriment.Enviroment;
import com.yomia.envoriment.ObjetoTeste;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

public class WebFormTest {

    public HttpServletRequest getMockRequest() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        return request;
    }

    ObjetoTeste teste = new Enviroment().get();
    @Test
    public void testProcessRequest() throws Exception {
        new ExecutaAcaoParaRequisicaoDoFormulario(new FormularioParaTeste(teste)).processaRequest(getMockRequest());
        
        assertEquals("TesteDeForm",teste.getTexto() );
    }

}
