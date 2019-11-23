package com.yomia.webform;

import com.yomia.envoriment.Enviroment;
import com.yomia.envoriment.ObjetoTeste;
import com.yomia.test.Unitario;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

@Category(Unitario.class)
public class WebFormTest {

    public HttpServletRequest getMockRequest() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        return request;
    }

    
    @Test
    public void testProcessRequest() throws Exception {
        ObjetoTeste teste = new Enviroment().getObjetoTeste();
        new ExecutaAcaoParaRequisicaoDoFormulario(new FormularioParaTeste(teste)).processaRequest(getMockRequest());
        assertEquals("TesteDeForm",teste.getTexto() );
    }

}
