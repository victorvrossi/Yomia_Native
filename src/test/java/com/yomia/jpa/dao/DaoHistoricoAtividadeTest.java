
package com.yomia.jpa.dao;

import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbHistoricoStatusAtv;
import com.yomia.jpa.entidade.TbStatus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import test.core.util.CoreUtil;
import test.core.util.TesteBase;

public class DaoHistoricoAtividadeTest extends TesteBase{

    /**
     * Test of registrarHistorico method, of class DaoHistoricoAtividade.
     */
    @Test
    public void testRegistrarHistorico() throws Exception {
        System.out.println("registrarHistorico");
        TbAtividade idAtividade = new CoreUtil().novaAtividade();
        assertNotNull(idAtividade.getId());
        TbStatus idStatus = new CoreUtil().novoStatus("Fechado");
        assertNotNull(idStatus.getId());
        DaoHistoricoAtividade instance = new DaoHistoricoAtividade();
        TbHistoricoStatusAtv l =instance.registrarHistorico(idAtividade, idStatus);
        assertNotNull(l.getId());
        
    }

    /**
     * Test of getClasseTabela method, of class DaoHistoricoAtividade.
     */
    @Test
    public void testGetClasseTabela() {
        System.out.println("getClasseTabela");
        DaoHistoricoAtividade instance = new DaoHistoricoAtividade();
        Class<TbHistoricoStatusAtv> expResult = TbHistoricoStatusAtv.class;
        Class<TbHistoricoStatusAtv> result = instance.getClasseTabela();
        assertEquals(expResult, result);
    }
    
}
