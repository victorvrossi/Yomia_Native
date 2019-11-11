/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yomia.jpa.dao;

import com.yomia.jpa.entidade.TbFluxoAtividade;
import com.yomia.jpa.entidade.TbFluxoSequencia;
import com.yomia.jpa.entidade.TbTipoAtividade;
import com.yomia.test.util.MainFuncionalTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Victor
 */
public class DaoFluxoAtividadeTest extends MainFuncionalTest{
    
    
    @Test
    public void testNovoFluxo_3args() {
        System.out.println("novoFluxo");
        String titulo = "Teste";
        DaoTipoAtividade k = new DaoTipoAtividade();
        
        DaoFluxoAtividade flx = new DaoFluxoAtividade();
        TbFluxoAtividade fluxo =flx.novoFluxo("Teste");
        
        TbTipoAtividade novoTipoAtividade = k.novoTipoAtividade("teste",fluxo);
        
        List<TbFluxoSequencia> tbFluxoSequenciaList = new ArrayList<>();
        List<TbTipoAtividade> tbTipoAtividadeList = new ArrayList<>();
        tbTipoAtividadeList.add(novoTipoAtividade);
        
        DaoFluxoAtividade instance = new DaoFluxoAtividade();
        String expResult = "Teste";
        TbFluxoAtividade result = instance.novoFluxo(titulo, tbFluxoSequenciaList, tbTipoAtividadeList);
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
        instance.removerFluxo(titulo);

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
