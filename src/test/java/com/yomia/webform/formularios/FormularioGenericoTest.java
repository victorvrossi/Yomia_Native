/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yomia.webform.formularios;

import com.yomia.webform.formularios.face.FormularioGenerico;
import com.yomia.webform.Enviroment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import com.yomia.webform.AcaoParaObjetoRequisicaoDoFormularioSimples;

/**
 *
 * @author Victor
 */
public class FormularioGenericoTest {

    Enviroment.ObjetoTeste teste = new Enviroment().get();

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
