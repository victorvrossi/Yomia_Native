
package com.yomia.modulo.atividade;

import com.yomia.test.util.AtividadeUtil;
import com.yomia.test.util.MainFuncionalTest;
import org.junit.Test;
import static org.junit.Assert.*;

public class AtividadeTest extends MainFuncionalTest{
    
    @Test
    public void testListaAtividade() {
        System.out.println("listaAtividade");
        new AtividadeUtil().novaAtividade();
        new AtividadeUtil().novaAtividade();
        Atividade instance = new Atividade();
        String expResult = "[{\"codigoAtividade\":\"TESTE-001\",\"titulo\":\"TESTE\",\"descricao\":\"TESTE\",\"status\":\"aberto\",\"tipo\":\"Tipo\",\"dataCriacao\":\"2019-11-10\"},{\"codigoAtividade\":\"TESTE-001\",\"titulo\":\"TESTE\",\"descricao\":\"TESTE\",\"status\":\"aberto\",\"tipo\":\"Tipo\",\"dataCriacao\":\"2019-11-10\"}]";
        String result = instance.geraListaJsonDeAtividades();
        assertEquals(expResult, result);
    }


  
    
}
