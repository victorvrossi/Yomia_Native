
package com.yomia.jpa.dao;

import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.jpa.entidade.TbStatusAtividade;
import com.yomia.modulo.falhas.FalhaGenerica;
import org.junit.Test;
import static org.junit.Assert.*;
import test.core.util.CoreUtil;
import test.core.util.TesteBase;

public class DaoStatusAtividadeTest extends TesteBase{
    

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

    @Test
    public void testNovoStatus() throws FalhaGenerica {
        System.out.println("novoStatus");        
        final CoreUtil coreUtil = new CoreUtil();
        TbAtividade idAtividade = coreUtil.novaAtividade();
       
        final TbStatus novoStatus = new DaoStatus().novoStatus("nono");
        DaoStatusAtividade instance = new DaoStatusAtividade();
        assertNotNull(novoStatus.getId());
        
        TbStatusAtividade result = null;
        result = instance.novoStatus(idAtividade, novoStatus);
        assertNotNull(result.getId());
        
        
    }

    @Test
    public void testGetClasseTabela() {
        System.out.println("getClasseTabela");
        DaoStatusAtividade instance = new DaoStatusAtividade();
        Class<TbStatusAtividade> expResult = TbStatusAtividade.class;
        Class<TbStatusAtividade> result = instance.getClasseTabela();
        assertEquals(expResult, result);
    }
    
}
