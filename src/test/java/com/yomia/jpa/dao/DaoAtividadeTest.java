package com.yomia.jpa.dao;

import test.core.util.MainFuncionalTest;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.falhas.FalhaOperacaoDeBD;
import test.core.util.CoreUtil;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import test.core.util.UtilHarnessDatabase;

public class DaoAtividadeTest extends MainFuncionalTest {

    /**
     * Test of novaAtividade method, of class DaoAtividade.
     */
    @Test
    public void testNovaAtividade() {
        new UtilHarnessDatabase().limpaTodasOsDados();
        System.out.println("novaAtividade**********************************************");
        TbAtividade novaAtividade = new CoreUtil().novaAtividade();
        assertNotNull(novaAtividade.getId());
    }

    @Test(expected = FalhaOperacaoDeBD.class)
    public void testeFalhaAoSalvar()throws FalhaOperacaoDeBD, FalhaGenerica{
        new UtilHarnessDatabase().limpaTodasOsDados();
        System.out.println("Falha ao gerar novaAtividade");
        String titulo = "TESTE";
        String codigoAtividade = "TESTE-001";
        String descricao = "TESTE";
        DaoAtividade instance = new DaoAtividade();
        instance.novaAtividade(titulo, codigoAtividade, descricao, null, null, null, null);

    }

    /**
     * Test of carregarTodasAtividades method, of class DaoAtividade.
     */
    @Test
    public void testCarregarTodasAtividades() throws FalhaOperacaoDeBD {
        System.out.println("carregarTodasAtividades");
        new CoreUtil().novaAtividade();
        DaoAtividade instance = new DaoAtividade();
        List<TbAtividade> result = instance.carregarTodasAtividades();
        assertTrue(result.size() == 1);
    }

    /**
     * Test of getClasseTabela method, of class DaoAtividade.
     */
    @Test
    public void testGetClasseTabela() {
        System.out.println("getClasseTabela");
        DaoAtividade instance = new DaoAtividade();
        Class expResult = TbAtividade.class;
        Class<TbAtividade> result = instance.getClasseTabela();
        assertEquals(expResult, result);
    }

}
