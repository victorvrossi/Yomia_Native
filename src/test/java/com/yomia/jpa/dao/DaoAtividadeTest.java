package com.yomia.jpa.dao;

import com.yomia.test.util.MainFuncionalTest;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbFuncionario;
import com.yomia.jpa.entidade.TbProjeto;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.jpa.entidade.TbTipoAtividade;
import com.yomia.modulo.falhas.FalhaOperacaoDeBD;
import com.yomia.test.util.AtividadeUtil;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class DaoAtividadeTest extends MainFuncionalTest {

    /**
     * Test of novaAtividade method, of class DaoAtividade.
     */
    @Test
    public void testNovaAtividade() {
        System.out.println("novaAtividade");
        TbAtividade novaAtividade = new AtividadeUtil().novaAtividade();
        assertNotNull(novaAtividade.getId());

    }

    @Test(expected = FalhaOperacaoDeBD.class)
    public void testeFalhaAoSalvar()throws FalhaOperacaoDeBD{
        System.out.println("Falha ao gerar novaAtividade");
        String titulo = "TESTE";
        String codigoAtividade = "TESTE-001";
        String descricao = "TESTE";
        DaoAtividade instance = new DaoAtividade();
        assertNull(instance.novaAtividade(titulo, codigoAtividade, descricao, null, null, null, null));

    }

    /**
     * Test of carregarTodasAtividades method, of class DaoAtividade.
     */
    @Test
    public void testCarregarTodasAtividades() {
        System.out.println("carregarTodasAtividades");
        new AtividadeUtil().novaAtividade();
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
