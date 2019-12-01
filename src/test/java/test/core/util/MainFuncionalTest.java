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
    }

    @Before
    public void setUp() {
    }

    @After
    public void setDown() {
        new UtilHarnessDatabase().limpaTodasOsDados();
    }
    
}
