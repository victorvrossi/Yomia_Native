package com.yomia.jpa.dao;

import com.yomia.test.util.MainFuncionalTest;
import com.yomia.jpa.entidade.TbFuncionario;
import org.junit.Test;
import static org.junit.Assert.*;

public class DaoFuncionarioTest extends MainFuncionalTest{
    
    

    /**
     * Test of novoFuncionario method, of class DaoFuncionario.
     */
    @Test
    public void testNovoFuncionario() {
        System.out.println("novoFuncionario");
        String nome = "";
        DaoFuncionario instance = new DaoFuncionario();
        TbFuncionario result = instance.novoFuncionario(nome);
        assertNotNull(result.getId());
    }

    /**
     * Test of getClasseTabela method, of class DaoFuncionario.
     */
    @Test
    public void testGetClasseTabela() {
        System.out.println("getClasseTabela");
        DaoFuncionario instance = new DaoFuncionario();
        Class<TbFuncionario> expResult = TbFuncionario.class;
        Class<TbFuncionario> result = instance.getClasseTabela();
        assertEquals(expResult, result);
    }
    
}
