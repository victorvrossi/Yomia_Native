package com.yomia.webform;

import com.yomia.webform.formularios.FormularioGenerico;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;

public class WebFormTest {

    public HttpServletRequest getMockRequest() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        List<String> arrlist = new ArrayList<String>();
        arrlist.add("Ram");
        arrlist.add("Gopal");
        arrlist.add("Verma");
        Enumeration<String> e = Collections.enumeration(arrlist);
        Mockito.when(request.getParameterNames()).thenReturn(e);
        return request;
    }

    Enviroment.ObjetoTeste teste = new Enviroment().get();
    @Test
    public void testProcessRequest() throws Exception {
        new ExecutaAcaoParaRequisicaoDoFormulario(new FormularioParaTeste(teste)).processaRequest(getMockRequest());
        
        assertEquals("TesteDeForm",teste.getTexto() );
    }

}
