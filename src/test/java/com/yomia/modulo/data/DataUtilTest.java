
package com.yomia.modulo.data;

import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;

public class DataUtilTest {
    
   
    @Test
    public void testAtual() {
        DataDoSistema expResult = DataDoSistema.novaData(Calendar.getInstance());
        DataDoSistema result = DataUtil.atual();
        assertEquals(expResult.calendario().get(Calendar.DATE), result.calendario().get(Calendar.DATE));
        assertEquals(expResult.calendario().get(Calendar.HOUR), result.calendario().get(Calendar.HOUR));
        assertEquals(expResult.calendario().get(Calendar.MINUTE), result.calendario().get(Calendar.MINUTE));
    }

    @Test
    public void testDataManual() {
        int ano = 2019;
        EnumDataMes mes = EnumDataMes.AGOSTO;
        int dia = 10;
        DataDoSistema expResult = DataUtil.dataManual(2019, EnumDataMes.AGOSTO, 10);
        DataDoSistema result = DataUtil.dataManual(ano, mes, dia);
        assertEquals(expResult.calendario(), result.calendario());
    }

    @Test
    public void testFormatarData() {
        Date data = DataUtil.dataManual(2019, EnumDataMes.OUTUBRO, 10).calendario().getTime();
        String expResult = "2019-10-10";
        String result = DataUtil.formatarData(data);
        assertEquals(expResult, result);
        
    }

    @Test
    public void testResgatarMes() {
        Calendar data = DataUtil.dataManual(2019, EnumDataMes.ABRIL, 10).calendario();
        EnumDataMes expResult = EnumDataMes.ABRIL;
        EnumDataMes result = DataUtil.resgatarMes(data);
        assertEquals(expResult, result);
    }

    @Test
    public void testResgatarAno() {        
        Calendar data = DataUtil.dataManual(2019, EnumDataMes.ABRIL, 10).calendario();
        int expResult = 2019;
        int result = DataUtil.resgatarAno(data);
        assertEquals(expResult, result);
    }

    @Test
    public void testResgatarDia() {
        Calendar data = DataUtil.dataManual(2019, EnumDataMes.ABRIL, 10).calendario();
        int expResult = 10;
        int result = DataUtil.resgatarDia(data);
        assertEquals(expResult, result);
    }

    @Test
    public void testContaDiasDaDataEntradaAteDataSaida() {
        Calendar entrada = DataUtil.dataManual(2019, EnumDataMes.ABRIL, 10).calendario();
        Calendar saida = DataUtil.dataManual(2019, EnumDataMes.ABRIL, 15).calendario();
        int expResult = 5;
        int result = DataUtil.contaDiasDaDataEntradaAteDataSaida(entrada, saida);
        assertEquals(expResult, result);
    }

    @Test
    public void testResgatarMesAnterior() {
        Calendar atual = DataUtil.dataManual(2019, EnumDataMes.ABRIL, 10).calendario();;
        EnumDataMes expResult = EnumDataMes.MARCO;
        EnumDataMes result = DataUtil.resgatarMesAnterior(atual);
        assertEquals(expResult, result);
    }
    @Test
    public void testResgatarMesAnteriorQuandoPrimeiroDoAno() {
        Calendar atual = DataUtil.dataManual(2019, EnumDataMes.JANEIRO, 10).calendario();;
        EnumDataMes expResult = EnumDataMes.DEZEMBRO;
        EnumDataMes result = DataUtil.resgatarMesAnterior(atual);
        assertEquals(expResult, result);
    }
    
}
