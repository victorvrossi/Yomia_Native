
package com.yomia.modulo.atividade;

import com.yomia.envoriment.Unitario;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;

@Category(Unitario.class)
public class AtividadeTest {
    
    @Test
    public void testListaAtividade() {
        System.out.println("listaAtividade");
        Atividade instance = new Atividade();
        String expResult = "[{\"codigoAtividade\":\"PARIO-005\",\"titulo\":\"dfgdfg\",\"descricao\":\"default textdfgdfg\",\"status\":\"Aberto\",\"tipo\":\"Backlog\",\"dataCriacao\":\"2019-11-04\"},{\"codigoAtividade\":\"PARIO-005\",\"titulo\":\"gfhjnfgh\",\"descricao\":\"fghfgh\",\"status\":\"Aberto\",\"tipo\":\"Backlog\",\"dataCriacao\":\"2019-11-04\"},{\"codigoAtividade\":\"PARIO-005\",\"titulo\":\"sdfsdfsd\",\"descricao\":\"sdfsdfsdfsd\",\"status\":\"Aberto\",\"tipo\":\"Backlog\",\"dataCriacao\":\"2019-11-05\"},{\"codigoAtividade\":\"PARIO-005\",\"titulo\":\"Caiu na lata\",\"descricao\":\"default text\",\"status\":\"Aberto\",\"tipo\":\"Backlog\",\"dataCriacao\":\"2019-11-05\"}]";
        String result = instance.listaAtividade();
        System.out.println(""+result);
        assertEquals(expResult, result);
    }


  
    
}
