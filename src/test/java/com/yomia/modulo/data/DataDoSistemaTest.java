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

public class DataDoSistemaTest {
    
    @Test
    public void testNovaData() {
        DataDoSistema expResult =  DataUtil.dataManual(2019, EnumDataMes.MAIO, 10);
        Calendar c = new GregorianCalendar(2019, EnumDataMes.MAIO.valorMes, 10);
        DataDoSistema result = DataDoSistema.novaData(c);
        assertEquals(expResult.data(), result.data());
    }
    @Test
    public void testFimDeSemana_Sabado() {
        DataDoSistema expResult =  DataUtil.dataManual(2019, EnumDataMes.AGOSTO, 10);
        boolean finalDeSemana = expResult.finalDeSemana(expResult.dia(), expResult.mes());
        assertTrue(finalDeSemana);
    }
    @Test
    public void testFimDeSemana_Domingo() {
        DataDoSistema expResult =  DataUtil.dataManual(2019, EnumDataMes.AGOSTO, 11);
        boolean finalDeSemana = expResult.finalDeSemana(expResult.dia(), expResult.mes());
        assertTrue(finalDeSemana);
    }

    
}
