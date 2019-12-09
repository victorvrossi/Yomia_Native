package com.yomia.jpa.dao;

import com.yomia.jpa.entidade.TbStatus;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import test.core.util.TesteBase;

public class DaoStatusTest extends TesteBase{

    @Test
    public void testNovoStatus() {
        System.out.println("novoStatus");
        String aberto = "aberto";
        DaoStatus instance = new DaoStatus();

        TbStatus result = instance.novoStatus(aberto);
        assertNotNull(result.getId());
        TbStatus expResult = instance.consultarPorId(result.getId());
        assertEquals(expResult.getTitulo(), result.getTitulo());
    }

    /**
     * Test of carregarTodosStatus method, of class DaoStatus.
     */
    @Test
    public void testCarregarTodosStatus() {
        System.out.println("carregarTodosStatus");
        String fechado = "fechado";
        DaoStatus instance = new DaoStatus();

        TbStatus resultTb = instance.novoStatus(fechado);
        assertNotNull(resultTb.getId());

        List<TbStatus> expResult = new ArrayList<>();
        TbStatus moment = new TbStatus();
        moment.setTitulo(fechado);
        expResult.add(moment);
        List<TbStatus> result = instance.carregarTodosStatus();
        for (TbStatus tbStatus : result) {
            for (TbStatus r : expResult) {
                assertEquals(tbStatus.getTitulo(), r.getTitulo());
            }
        }
    }

    /**
     * Test of pesquisaPorTitulo method, of class DaoStatus.
     */
    @Test
    public void testPesquisaPorTitulo() {
        System.out.println("pesquisaPorTitulo");
        String titulo = "fechado";
        DaoStatus instance = new DaoStatus();

        TbStatus resultTb = instance.novoStatus(titulo);
        assertNotNull(resultTb.getId());

        TbStatus expResult = new TbStatus();
        expResult.setTitulo(titulo);
        TbStatus result = instance.pesquisaPorTitulo(titulo);
        assertEquals(expResult.getTitulo(), result.getTitulo());
    }

    /**
     * Test of getClasseTabela method, of class DaoStatus.
     */
    @Test
    public void testGetClasseTabela() {
        System.out.println("getClasseTabela");
        DaoStatus instance = new DaoStatus();
        Class<TbStatus> expResult = TbStatus.class;
        Class<TbStatus> result = instance.getClasseTabela();
        assertEquals(expResult, result);
    }

}
