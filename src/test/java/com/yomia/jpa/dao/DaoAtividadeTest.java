package com.yomia.jpa.dao;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.falhas.FalhaOperacaoDeBD;
import test.core.util.CoreUtil;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import test.core.util.TesteBase;
import test.core.util.UtilHarnessDatabase;

public class DaoAtividadeTest  extends TesteBase{

    /**
     * Test of novaAtividade method, of class DaoAtividade.
     */
    @Test
    public void testNovaAtividade() {
        System.out.println("novaAtividade**********************************************");
        TbAtividade novaAtividade = new CoreUtil().novaAtividade();
        assertNotNull(novaAtividade.getId());
        assertNotNull(novaAtividade.getTbStatusAtividade().getId());
        assertNotNull(novaAtividade.getTbStatusAtividade().getIdStatus());
        assertEquals("aberto", novaAtividade.getTbStatusAtividade().getIdStatus().getTitulo());
        assertEquals("TESTE-001", novaAtividade.getTbStatusAtividade().getIdAtividade().getCodigoAtividade());
        assertEquals("Yomia", novaAtividade.getIdProjeto().getTitulo());
        
    }

    @Test(expected = FalhaOperacaoDeBD.class)
    public void testeFalhaAoSalvar()throws FalhaOperacaoDeBD, FalhaGenerica{
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
        List<BaseEntidade> result = instance.carregarListaDoBanco();
        assertEquals(1,result.size());
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
