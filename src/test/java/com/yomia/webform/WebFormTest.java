package com.yomia.webform;

import com.yomia.envoriment.Enviroment;
import com.yomia.envoriment.ObjetoTeste;
import test.core.Unitario;
import com.yomia.webform.service.face.RequisicaoGenerica;
import com.yomia.webform.sessao.SessaoUsuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

@Category(Unitario.class)
public class WebFormTest {
SessaoUsuario use = new SessaoUsuario();
    public HttpServletRequest getMockRequest() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpSession ss = Mockito.mock(HttpSession.class);
        
        
        Mockito.when(request.getSession()).thenReturn(ss);
        Mockito.when(request.getSession().getAttribute(SessaoUsuario.SESSAO_RESERVADA)).thenReturn(use);
        return request;
    }

    @Test
    public void testProcessaRequest() throws Exception {
        ObjetoTeste teste = new Enviroment().getObjetoTeste();
        new ExecutaAcaoParaRequisicaoDoFormulario(new FormularioTesteSimples(teste)).processaRequest(getMockRequest());
        assertEquals("TesteDeForm", teste.getTexto());
    }

    @Test
    public void testVerificaSessao() throws Exception {
        use.efetuaLogin("ok", "OK");
        ObjetoTeste teste = new Enviroment().getObjetoTeste();
        new ExecutaAcaoParaRequisicaoDoFormulario(new FormularioTesteDeSessao(teste)).processaRequest(getMockRequest());
        assertEquals("TesteDeForm", teste.getTexto());
        use = new SessaoUsuario();
    }
    @Test(expected = NullPointerException.class)
    public void testFalhaSessao() throws Exception {
        ObjetoTeste teste = new Enviroment().getObjetoTeste();
        new ExecutaAcaoParaRequisicaoDoFormulario(new FormularioTesteDeSessao(teste)).processaRequest(getMockRequest());
        assertEquals("TesteDeForm", teste.getTexto());
        use = new SessaoUsuario();
    }

}

class FormularioTesteSimples extends RequisicaoGenerica {

    ObjetoTeste teste;

    FormularioTesteSimples(ObjetoTeste teste) {
        this.teste = teste;
    }

    @Override
    public void processaRequest(final HttpServletRequest request) {
        if (teste == null) {
            throw new NullPointerException("Objeto de Teste está null");
        }
        teste.setTexto("TesteDeForm");
    }

    @Override
    public void processaResponse(HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

class FormularioTesteDeSessao extends RequisicaoGenerica {

    ObjetoTeste teste;

    FormularioTesteDeSessao(ObjetoTeste teste) {
        this.teste = teste;
    }

    @Override
    public void processaRequest(final HttpServletRequest request) {
        SessaoUsuario l = (SessaoUsuario) request.getSession().getAttribute(SessaoUsuario.SESSAO_RESERVADA);
        if (l == null || !l.estaLogadoNoSistema()) {
            throw new NullPointerException("Objeto de Teste está null");
        }
        if (teste == null) {
            throw new NullPointerException("Objeto de Teste está null");
        }
        teste.setTexto("TesteDeForm");
    }

    @Override
    public void processaResponse(HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
