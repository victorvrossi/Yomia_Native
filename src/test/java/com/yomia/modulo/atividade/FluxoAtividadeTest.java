
package com.yomia.modulo.atividade;

import com.yomia.test.DatabaseTest;
import com.yomia.test.util.MainFuncionalTest;
import com.yomia.test.util.UtilHarnessDatabase;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(DatabaseTest.class)
public class FluxoAtividadeTest extends MainFuncionalTest{
    
    
    @Test
    public void testNovoFluxo() {        
        System.out.println("novoFluxo");
        FluxoAtividade instance = new FluxoAtividade();
        instance.novoFluxo();
    }
    
}
