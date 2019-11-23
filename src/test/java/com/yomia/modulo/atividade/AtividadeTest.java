
package com.yomia.modulo.atividade;

import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.modulo.data.DataUtil;
import com.yomia.test.util.AtividadeUtil;
import com.yomia.test.util.MainFuncionalTest;
import org.junit.Test;
import static org.junit.Assert.*;

public class AtividadeTest extends MainFuncionalTest{
    
    @Test
    public void testListaAtividade() {
        System.out.println("listaAtividade");
        TbAtividade n1 = new AtividadeUtil().novaAtividade();
        TbAtividade n2 =new AtividadeUtil().novaAtividade();
        
        assertNotNull(n1.getId());
        assertNotNull(n2.getId());
        Atividade instance = new Atividade();
        
        String dataCriacao = DataUtil.formatarData(DataUtil.atual().data());
        String expResult = "[{\"codigoAtividade\":\"TESTE-001\",\"titulo\":\"TESTE\",\"descricao\":\"TESTE\",\"status\":\"aberto\",\"tipo\":\"Tipo\",\"dataCriacao\":\""+dataCriacao+"\"},{\"codigoAtividade\":\"TESTE-001\",\"titulo\":\"TESTE\",\"descricao\":\"TESTE\",\"status\":\"aberto\",\"tipo\":\"Tipo\",\"dataCriacao\":\""+dataCriacao+"\"}]";
        String result = instance.geraListaJsonDeAtividades();
        assertEquals(expResult, result);
    }


  
    
}
