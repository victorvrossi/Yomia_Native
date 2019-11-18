
package com.yomia.envoriment;

import com.yomia.test.DatabaseTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;

@Category(DatabaseTest.class)
public class NewEmptyJUnitTest {

    public NewEmptyJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
        System.out.println("**********************************************");
        new flx().fluxo();
        System.out.println("////");
    }
}

class flx{
    String titulo="Fluxo";
    Seq start = new Seq("Start",new Lig());
    public void fluxo(){
        System.out.println("Titulo:"+titulo);        
        start.sequencia();
    }
}

class Seq{
    private String status;
    Lig p;

    public Seq(String status, Lig p) {
        this.status = status;
        this.p = p;
    }
    
    public void sequencia(){
        
        System.out.print("Status>"+status+"*");
        if(p==null){return;}
        p.proximo(new Seq("FIM", null));
    }
}
class Lig{
    public void proximo(Seq prox){
        prox.sequencia();
    }
}