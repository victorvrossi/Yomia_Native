
package com.yomia.webform.json;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.dao.DaoAtividade;
import com.yomia.modulo.atividade.Atividade;
import com.yomia.modulo.atividade.Entidade;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;

@Category(FunctionalInterface.class)
public class CarregaListaJsonTest {
    
    public CarregaListaJsonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Test
    public void testListaTodosElementoEmJson() {
        System.out.println("listaTodosElementoEmJson");
        Class<? extends DaoGenerico> daoClass = DaoAtividade.class;
        Class<? extends JsonAtividade> jsonClass = JsonAtividade.class;
        Class<? extends Entidade> entidadeClass = Atividade.class;
        CarregaListaJson instance = new CarregaListaJson();
        String result = instance.listaTodosElementoEmJson(daoClass, jsonClass, entidadeClass);
        assertNotNull(result);
        
    }
    
}
