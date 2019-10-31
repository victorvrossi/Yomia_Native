
package com.yomia.webform.formularios;

import com.yomia.webform.service.face.FormularioGenerico;
import com.yomia.envoriment.Enviroment;
import com.yomia.envoriment.ObjetoTeste;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import static org.junit.Assert.*;
import com.yomia.webform.AcaoParaObjetoRequisicaoDoFormularioSimples;

public class FormularioGenericoTest {

    ObjetoTeste teste = new Enviroment().get();

    @Test
    public void testProcessaRequest() {

        teste.setTexto("fail");
        HttpServletRequest request = Enviroment.getMockRequest();
        AcaoParaObjetoRequisicaoDoFormularioSimples objeto = Enviroment.acaoParaObjetoDeTeste(teste);
        assertEquals("fail", teste.getTexto());
        FormularioGenerico.processaRequest(request, objeto);
        assertEquals("teste", teste.getTexto());

    }

}
