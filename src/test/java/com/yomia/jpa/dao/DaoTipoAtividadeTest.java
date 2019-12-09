
package com.yomia.jpa.dao;

import com.yomia.jpa.entidade.TbFluxoAtividade;
import com.yomia.jpa.entidade.TbTipoAtividade;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import test.core.util.CoreUtil;
import test.core.util.TesteBase;

public class DaoTipoAtividadeTest extends TesteBase{
  
    @Test
    public void testNovoTipoAtividade() {
        System.out.println("novoTipoAtividade");
        String titulo = "tipoatv";
        TbFluxoAtividade idFluxoAtividade = null;
        DaoTipoAtividade instance = new DaoTipoAtividade();
        TbTipoAtividade result = instance.novoTipoAtividade(titulo, idFluxoAtividade);
        assertNotNull(result.getId());
    }

    @Test
    public void testCarregaTipoAtividade() {
        System.out.println("carregaTipoAtividade");
        DaoTipoAtividade instance = new DaoTipoAtividade();
        TbTipoAtividade expResult = new CoreUtil().novoTipoAtividade();
        
        List<TbTipoAtividade> result = instance.carregaTipoAtividade();
        assertEquals(1, result.size());
        assertEquals(expResult.getId(), result.get(0).getId());
    }

    @Test
    public void testCarregaTipoAtividadePorTitulo() {
        System.out.println("carregaTipoAtividadePorTitulo");
        String titulo = "Tipo";
        DaoTipoAtividade instance = new DaoTipoAtividade();
        TbTipoAtividade expResult = new CoreUtil().novoTipoAtividade();
        TbTipoAtividade result = instance.carregaTipoAtividadePorTitulo(titulo);
        assertEquals(expResult.getId(), result.getId());
    }

    @Test
    public void testGetClasseTabela() {
        System.out.println("getClasseTabela");
        DaoTipoAtividade instance = new DaoTipoAtividade();
        Class<TbTipoAtividade> expResult = TbTipoAtividade.class;
        Class<TbTipoAtividade> result = instance.getClasseTabela();
        assertEquals(expResult, result);
    }
    
}
