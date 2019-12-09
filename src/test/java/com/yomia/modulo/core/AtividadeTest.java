
package com.yomia.modulo.core;

import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.modulo.data.DataUtil;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.saida.ProcessaJsonSaidaAtividade;
import test.core.util.CoreUtil;
import org.junit.Test;
import static org.junit.Assert.*;

public class AtividadeTest {
    
    @Test
    public void testGeraListaJsonDeAtividades() throws FalhaGenerica {
        System.out.println("listaAtividade");
        TbAtividade n1 = new CoreUtil().novaAtividade();
        TbAtividade n2 =new CoreUtil().novaAtividade();
        
        assertNotNull(n1.getId());
        assertNotNull(n2.getId());
        ProcessaJsonSaidaAtividade instance = new ProcessaJsonSaidaAtividade();
        
        String dataCriacao = DataUtil.formatarData(DataUtil.atual().data());
        String expResult = "[{\"codigoAtividade\":\"TESTE-001\",\"titulo\":\"TESTE\",\"descricao\":\"TESTE\",\"status\":\"aberto\",\"tipo\":\"Tipo\",\"dataCriacao\":\""+dataCriacao+"\"},{\"codigoAtividade\":\"TESTE-001\",\"titulo\":\"TESTE\",\"descricao\":\"TESTE\",\"status\":\"aberto\",\"tipo\":\"Tipo\",\"dataCriacao\":\""+dataCriacao+"\"}]";
        String result = instance.geraListaJsonDeAtividades();
        System.out.println(""+result);
        //assertEquals(expResult, result);
    }


  
    
}
