/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yomia.jpa.dao;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.entidade.TbFluxoAtividade;
import com.yomia.jpa.entidade.TbFluxoSequencia;
import com.yomia.jpa.entidade.TbTipoAtividade;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import test.core.util.CoreUtil;
import test.core.util.TesteBase;

/**
 *
 * @author Victor
 */
public class DaoFluxoAtividadeTest extends TesteBase{
    
    

    /**
     * Test of cadastrarNovoFluxo method, of class DaoFluxoAtividade.
     */
    @Test
    public void testCadastrarNovoFluxo() throws Exception {
        System.out.println("cadastrarNovoFluxo");
        String titulo = "Novo Fluxo";
        TbTipoAtividade idTipoAtv = new CoreUtil().novoTipoAtividade();
        List<TbFluxoSequencia> tbFluxoSequenciaList = null;
        DaoFluxoAtividade instance = new DaoFluxoAtividade();
        TbFluxoAtividade l =instance.cadastrarNovoFluxo(titulo, idTipoAtv, tbFluxoSequenciaList);
        assertNotNull(l.getId());        
    }

    /**
     * Test of getClasseTabela method, of class DaoFluxoAtividade.
     */
    @Test
    public void testGetClasseTabela() {
        System.out.println("getClasseTabela");
        DaoFluxoAtividade instance = new DaoFluxoAtividade();
        Class<TbFluxoAtividade> expResult = TbFluxoAtividade.class;
        Class<TbFluxoAtividade> result = instance.getClasseTabela();
        assertEquals(expResult, result);
    }

    /**
     * Test of carregarListaDoBanco method, of class DaoFluxoAtividade.
     */
    @Test
    public void testCarregarListaDoBanco() throws Exception {
        System.out.println("carregarListaDoBanco");
        DaoFluxoAtividade instance = new DaoFluxoAtividade();
        List<BaseEntidade> result = instance.carregarListaDoBanco();
        assertEquals(0, result.size());
    }
    
}
