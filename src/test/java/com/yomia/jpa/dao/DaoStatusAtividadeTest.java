
package com.yomia.jpa.dao;

import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.jpa.entidade.TbStatusAtividade;
import com.yomia.modulo.falhas.FalhaGenerica;
import org.junit.Test;
import static org.junit.Assert.*;
import test.core.util.CoreUtil;
import test.core.util.MainFuncionalTest;

public class DaoStatusAtividadeTest extends MainFuncionalTest{
    

    /**
     * Test of consultaPorTitulo method, of class DaoStatusAtividade.
     */
    @Test
    public void testConsultaPorTitulo() {
        System.out.println("consultaPorTitulo");
        TbAtividade atividade = null;
        String aberto = "aberto";
        DaoStatusAtividade instance = new DaoStatusAtividade();
        final CoreUtil coreUtil = new CoreUtil();
        
        atividade = coreUtil.novaAtividade();
        final TbStatus tbStatus = coreUtil.getNovoStatus();
        
        instance.consultaPorTitulo(atividade, aberto);
    }

    /**
     * Test of novoStatus method, of class DaoStatusAtividade.
     */
    @Test
    public void testNovoStatus() {
        try{
            System.out.println("novoStatus");
        final CoreUtil coreUtil = new CoreUtil();
        TbAtividade idAtividade = coreUtil.novaAtividade();
        TbStatus tbStatus = coreUtil.getNovoStatus();
        
        DaoStatusAtividade instance = new DaoStatusAtividade();
        TbStatusAtividade expResult = new TbStatusAtividade();
        expResult.setIdStatus(tbStatus);
        expResult.setIdAtividade(idAtividade);
        TbStatusAtividade result = null;
        result = instance.novoStatus(idAtividade, tbStatus);
        assertEquals(expResult, result);
        }catch(FalhaGenerica e){
        }
        
    }

    /**
     * Test of getClasseTabela method, of class DaoStatusAtividade.
     */
    @Test
    public void testGetClasseTabela() {
        System.out.println("getClasseTabela");
        DaoStatusAtividade instance = new DaoStatusAtividade();
        Class<TbStatusAtividade> expResult = TbStatusAtividade.class;
        Class<TbStatusAtividade> result = instance.getClasseTabela();
        assertEquals(expResult, result);
    }
    
}
