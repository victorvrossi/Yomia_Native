/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yomia.modulo.data;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Victor
 */
public class DataDoSistemaTest {
    
   

    /**
     * Test of novaData method, of class DataDoSistema.
     */
    @Test
    public void testNovaData() {
        DataDoSistema expResult =  DataUtil.dataManual(2019, EnumDataMes.MAIO, 10);
        Calendar c = new GregorianCalendar(2019, EnumDataMes.MAIO.valorMes, 10);
        DataDoSistema result = DataDoSistema.novaData(c);
        assertEquals(expResult.data(), result.data());
    }

    
}
