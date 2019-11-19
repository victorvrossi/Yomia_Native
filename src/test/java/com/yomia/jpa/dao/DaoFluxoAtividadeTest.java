/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yomia.jpa.dao;

import com.yomia.jpa.entidade.TbFluxoAtividade;
import com.yomia.jpa.entidade.TbFluxoSequencia;
import com.yomia.test.util.MainFuncionalTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Victor
 */
public class DaoFluxoAtividadeTest extends MainFuncionalTest{
    
    
    @Test
    public void testNovoFluxo_args() {
        System.out.println("novoFluxo");
        String titulo = "Teste";
        List<TbFluxoSequencia> tbFluxoSequenciaList = new ArrayList<>();
        
        DaoFluxoAtividade instance = new DaoFluxoAtividade();
        String expResult = "Teste";
        TbFluxoAtividade result = instance.novoFluxo(titulo, tbFluxoSequenciaList);
        assertEquals(expResult, result.getTitulo());
    }

    /**
     * Test of novoFluxo method, of class DaoFluxoAtividade.
     */
    @Test
    public void testNovoFluxo_String() {
        System.out.println("novoFluxo");
        String titulo = "Teste";
        DaoFluxoAtividade instance = new DaoFluxoAtividade();
        String expResult = "Teste";
        TbFluxoAtividade result = instance.novoFluxo(titulo);
        assertEquals(expResult, result.getTitulo());
    }

    /**
     * Test of removerFluxo method, of class DaoFluxoAtividade.
     */
    @Test
    public void testRemoverFluxo() {
        System.out.println("removerFluxo");
        String titulo = "";
        DaoFluxoAtividade instance = new DaoFluxoAtividade();
        TbFluxoAtividade novoFluxo = instance.novoFluxo(titulo);
        Integer id = novoFluxo.getId();
        instance.removerFluxo(titulo);
        
        TbFluxoAtividade consultarPorId = instance.consultarPorId(id);
        assertNull(consultarPorId);
    }

    /**
     * Test of getClasseTabela method, of class DaoFluxoAtividade.
     */
    @Test
    public void testGetClasseTabela() {
        System.out.println("getClasseTabela");
        DaoFluxoAtividade instance = new DaoFluxoAtividade();
        Class<TbFluxoAtividade> expResult =TbFluxoAtividade.class;
        Class<TbFluxoAtividade> result = instance.getClasseTabela();
        assertEquals(expResult, result);

    }
    
}
