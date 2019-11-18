
package com.yomia.modulo.atividade;

import com.yomia.test.DatabaseTest;
import com.yomia.test.util.UtilHarnessDatabase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
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
