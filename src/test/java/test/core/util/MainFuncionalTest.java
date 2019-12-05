package test.core.util;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Category;
import test.core.DatabaseTest;

@Category(DatabaseTest.class)
public class MainFuncionalTest {
    @BeforeClass
    public static void setUpClass() {
        new UtilHarnessDatabase().limpaTodasOsDados();
    }

    @Before
    public void setUp() {
        new UtilHarnessDatabase().limpaTodasOsDados();
    }

    @After
    public void setDown() {
        new UtilHarnessDatabase().limpaTodasOsDados();
    }
    
}
