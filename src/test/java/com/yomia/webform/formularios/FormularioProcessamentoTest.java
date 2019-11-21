package com.yomia.webform.formularios;

import com.yomia.webform.service.face.ProcessamentoDaRequisicao;
import com.yomia.envoriment.Enviroment;
import com.yomia.envoriment.ObjetoTeste;
import com.yomia.test.Unitario;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import static org.junit.Assert.*;
import com.yomia.webform.AcaoParaObjetoRequisicaoDoFormularioSimples;
import org.junit.experimental.categories.Category;

@Category(Unitario.class)
public class FormularioProcessamentoTest {

    ObjetoTeste teste = new Enviroment().get();

    @Test
    public void testRequest() throws Exception {
        HttpServletRequest request = Enviroment.getMockRequest();
        AcaoParaObjetoRequisicaoDoFormularioSimples objeto = Enviroment.acaoParaObjetoDeTeste(teste);
        ProcessamentoDaRequisicao instance = new ProcessamentoDaRequisicao();
        instance.request(request, objeto);
        assertEquals("teste", teste.getTexto());
    }

}
