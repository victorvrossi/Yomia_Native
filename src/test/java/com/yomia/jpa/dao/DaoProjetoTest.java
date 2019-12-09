/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yomia.jpa.dao;

import com.yomia.jpa.entidade.TbProjeto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import test.core.util.TesteBase;

/**
 *
 * @author Victor
 */
public class DaoProjetoTest extends TesteBase{
    @Test
    public void testNovoProjeto() {
        System.out.println("novoProjeto");
        String titulo = "Projeto Teste";
        String sigla = "Teste";
        DaoProjeto instance = new DaoProjeto();
        TbProjeto result = instance.novoProjeto(titulo, sigla);
        assertNotNull(result.getId());
    }

    /**
     * Test of getClasseTabela method, of class DaoProjeto.
     */
    @Test
    public void testGetClasseTabela() {
        System.out.println("getClasseTabela");
        DaoProjeto instance = new DaoProjeto();
        Class<TbProjeto> expResult = TbProjeto.class;
        Class<TbProjeto> result = instance.getClasseTabela();
        assertEquals(expResult, result);
    }
    
}
