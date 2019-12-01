
package com.yomia.modulo.core;

import com.yomia.modulo.core.FluxoAtividade;
import test.core.DatabaseTest;
import test.core.util.MainFuncionalTest;
import test.core.util.UtilHarnessDatabase;
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
