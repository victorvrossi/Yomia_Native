
package com.yomia.modulo.atividade;

import com.yomia.test.DatabaseTest;
import com.yomia.test.util.UtilHarnessDatabase;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(DatabaseTest.class)
public class FluxoAtividadeTest {
    
    
    @Test
    public void testNovoFluxo() {
        new UtilHarnessDatabase().limpaTodasOsDados();
        System.out.println("novoFluxo");
        FluxoAtividade instance = new FluxoAtividade();
        instance.novoFluxo();
    }
    
}
