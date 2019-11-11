package com.yomia.test.util;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Category;
import com.yomia.test.DatabaseTest;

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
