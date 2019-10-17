/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yomia.modulo.data;

import java.util.Calendar;
import java.util.Date;
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
public class DataUtilTest {
    
   
    @Test
    public void testAtual() {
        DataDoSistema expResult = DataDoSistema.novaData(Calendar.getInstance());
        DataDoSistema result = DataUtil.atual();
        assertEquals(expResult.data().get(Calendar.DATE), result.data().get(Calendar.DATE));
        assertEquals(expResult.data().get(Calendar.HOUR), result.data().get(Calendar.HOUR));
        assertEquals(expResult.data().get(Calendar.MINUTE), result.data().get(Calendar.MINUTE));
    }

    @Test
    public void testDataManual() {
        int ano = 2019;
        EnumDataMes mes = EnumDataMes.AGOSTO;
        int dia = 10;
        DataDoSistema expResult = DataUtil.dataManual(2019, EnumDataMes.AGOSTO, 10);
        DataDoSistema result = DataUtil.dataManual(ano, mes, dia);
        assertEquals(expResult.data(), result.data());
    }

    @Test
    public void testFormatarData() {
        Date data = DataUtil.dataManual(2019, EnumDataMes.OUTUBRO, 10).data().getTime();
        String expResult = "2019-10-10";
        String result = DataUtil.formatarData(data);
        assertEquals(expResult, result);
        
    }

    @Test
    public void testResgatarMes() {
        Calendar data = DataUtil.dataManual(2019, EnumDataMes.ABRIL, 10).data();
        EnumDataMes expResult = EnumDataMes.ABRIL;
        EnumDataMes result = DataUtil.resgatarMes(data);
        assertEquals(expResult, result);
    }

    @Test
    public void testResgatarAno() {
        System.out.println("resgatarAno");
        Calendar data = DataUtil.dataManual(2019, EnumDataMes.ABRIL, 10).data();
        int expResult = 2019;
        int result = DataUtil.resgatarAno(data);
        assertEquals(expResult, result);
    }

    @Test
    public void testResgatarDia() {
        System.out.println("resgatarDia");
        Calendar data = DataUtil.dataManual(2019, EnumDataMes.ABRIL, 10).data();
        int expResult = 10;
        int result = DataUtil.resgatarDia(data);
        assertEquals(expResult, result);
    }

    @Test
    public void testContaDiasDaDataEntradaAteDataSaida() {
        System.out.println("contaDiasDaDataEntradaAteDataSaida");
        Calendar entrada = DataUtil.dataManual(2019, EnumDataMes.ABRIL, 10).data();
        Calendar saida = DataUtil.dataManual(2019, EnumDataMes.ABRIL, 15).data();
        int expResult = 5;
        int result = DataUtil.contaDiasDaDataEntradaAteDataSaida(entrada, saida);
        assertEquals(expResult, result);
    }

    @Test
    public void testResgatarMesAnterior() {
        System.out.println("resgatarMesAnterior");
        Calendar atual = DataUtil.dataManual(2019, EnumDataMes.ABRIL, 10).data();;
        EnumDataMes expResult = EnumDataMes.MARCO;
        EnumDataMes result = DataUtil.resgatarMesAnterior(atual);
        assertEquals(expResult, result);
    }
    @Test
    public void testResgatarMesAnteriorQuandoPrimeiroDoAno() {
        System.out.println("resgatarMesAnterior");
        Calendar atual = DataUtil.dataManual(2019, EnumDataMes.JANEIRO, 10).data();;
        EnumDataMes expResult = EnumDataMes.DEZEMBRO;
        EnumDataMes result = DataUtil.resgatarMesAnterior(atual);
        assertEquals(expResult, result);
    }
    
}
