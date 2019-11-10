package com.yomia.jpa.dao;

import com.yomia.test.util.MainTest;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbFuncionario;
import com.yomia.jpa.entidade.TbProjeto;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.jpa.entidade.TbTipoAtividade;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;


public class DaoAtividadeTest extends MainTest{

    /**
     * Test of novaAtividade method, of class DaoAtividade.
     */
    @Test
    public void testNovaAtividade() {
        System.out.println("novaAtividade");
        TbAtividade novaAtividade = novaAtividade();
        System.out.println("END:" + novaAtividade.toString());
        assertNotNull(novaAtividade.getId());

    }

    /**
     * Test of carregarTodasAtividades method, of class DaoAtividade.
     */
    @Test
    public void testCarregarTodasAtividades() {
        System.out.println("carregarTodasAtividades");
        novaAtividade();
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

    private TbAtividade novaAtividade() {
        TbProjeto projeto = novoProjeto();
        TbStatus novoStatus = novoStatus();
        TbTipoAtividade novoTipoAtividade = novoTipoAtividade();
        TbFuncionario novoFuncionario = novoFuncionario();
        
        String titulo = "TESTE";
        String codigoAtividade = "TESTE-001";
        String descricao = "TESTE";
        DaoAtividade instance = new DaoAtividade();
        
        TbAtividade novaAtividade = instance.novaAtividade(titulo, codigoAtividade, descricao, projeto, novoStatus, novoTipoAtividade, novoFuncionario);
        return novaAtividade;
    }

    private TbFuncionario novoFuncionario() {
        TbFuncionario novoFuncionario = new DaoFuncionario().novoFuncionario("func");
        assertNotNull(novoFuncionario.getId());
        return novoFuncionario;
    }

    private TbTipoAtividade novoTipoAtividade() {
        TbTipoAtividade novoTipoAtividade = new DaoTipoAtividade().novoTipoAtividade("Tipo");
        assertNotNull(novoTipoAtividade.getId());
        return novoTipoAtividade;
    }

    private TbStatus novoStatus() {
        TbStatus novoStatus = new DaoStatus().novoStatus("aberto");
        assertNotNull(novoStatus.getId());
        return novoStatus;
    }

    private TbProjeto novoProjeto() {
        TbProjeto projeto = new DaoProjeto().novoProjeto("Yomia", "YMA");
        assertNotNull(projeto.getId());
        return projeto;
    }
}
