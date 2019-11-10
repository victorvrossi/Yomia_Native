
package com.yomia.modulo.atividade;

import com.yomia.envoriment.Funcional;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(Funcional.class)
public class AtividadeTest {
    
    @Test
    public void testListaAtividade() {
        System.out.println("listaAtividade");
        Atividade instance = new Atividade();
        String expResult = "[{\"codigoAtividade\":\"PARIO-005\",\"titulo\":\"dfgdfg\",\"descricao\":\"default textdfgdfg\",\"status\":\"Aberto\",\"tipo\":\"Backlog\",\"dataCriacao\":\"2019-11-04\"},{\"codigoAtividade\":\"PARIO-005\",\"titulo\":\"gfhjnfgh\",\"descricao\":\"fghfgh\",\"status\":\"Aberto\",\"tipo\":\"Backlog\",\"dataCriacao\":\"2019-11-04\"},{\"codigoAtividade\":\"PARIO-005\",\"titulo\":\"sdfsdfsd\",\"descricao\":\"sdfsdfsdfsd\",\"status\":\"Aberto\",\"tipo\":\"Backlog\",\"dataCriacao\":\"2019-11-05\"},{\"codigoAtividade\":\"PARIO-005\",\"titulo\":\"Caiu na lata\",\"descricao\":\"default text\",\"status\":\"Aberto\",\"tipo\":\"Backlog\",\"dataCriacao\":\"2019-11-05\"},{\"codigoAtividade\":\"PARIO-005\",\"titulo\":\"dgrfgdf\",\"descricao\":\"dfgdfgdf\",\"status\":\"Aberto\",\"tipo\":\"Backlog\",\"dataCriacao\":\"2019-11-06\"}]";
       // String result = instance.geraListaJsonDeAtividades();
       // System.out.println(""+result);
//        assertEquals(expResult, result);
    }


  
    
}
