/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.core.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class TesteBase {

    public TesteBase() {
    }

    @BeforeClass
    public static void setUpClass() {
        new UtilHarnessDatabase().limpaTodasOsDados();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        new UtilHarnessDatabase().limpaTodasOsDados();
    }

    @After
    public void tearDown() {
        new UtilHarnessDatabase().limpaTodasOsDados();
    }

}
