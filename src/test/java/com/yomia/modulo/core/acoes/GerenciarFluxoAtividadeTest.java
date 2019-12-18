/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yomia.modulo.core.acoes;

import com.yomia.jpa.dao.DaoFluxoAtividade;
import com.yomia.jpa.entidade.TbFluxoAtividade;
import com.yomia.modulo.core.Status;
import com.yomia.modulo.core.TipoAtividade;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import test.core.util.CoreUtil;

/**
 *
 * @author Victor
 */
public class GerenciarFluxoAtividadeTest {
    
    public GerenciarFluxoAtividadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testNovoFluxoParaAtividade() throws Exception {
        System.out.println("novoFluxoParaAtividade");
        String titulo = "Fluxo 1";
        GerenciarFluxoAtividade instance = new GerenciarFluxoAtividade();
        TipoAtividade tipoAtividade = (TipoAtividade)new TipoAtividade().converteTabelaParaObjeto(new CoreUtil().novoTipoAtividade());
        List<Status> listaStatus = new ArrayList<Status>();        
        listaStatus.add((Status)new Status().converteTabelaParaObjeto(new CoreUtil().novoStatus("Status1")));
        TbFluxoAtividade result = instance.novoFluxoParaAtividade(titulo, tipoAtividade, listaStatus);
        
        
        DaoFluxoAtividade expResult = null;
        assertNotNull(result.getId());
    }
    
}
