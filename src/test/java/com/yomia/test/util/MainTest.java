package com.yomia.test.util;

import com.yomia.test.util.UtilHarnessDatabase;
import com.yomia.envoriment.Funcional;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Category;

@Category(Funcional.class)
public class MainTest {
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
