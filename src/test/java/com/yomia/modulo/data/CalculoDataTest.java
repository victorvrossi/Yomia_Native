package com.yomia.modulo.data;

import com.yomia.test.Unitario;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(Unitario.class)
public class CalculoDataTest {

    int tempoEstimadoProjeto = EnvorimentData.tempoEstimado();
    CalculoData calc = EnvorimentData.calcula();

    @Test
    public void testTamanhoDia() {
        assertEquals("Valida tamanho do dia:", 8, calc.tamanhoDoDia());
    }

    @Test
    public void testContagemDeDiasDadoHoraSemSobra() {
        tempoEstimadoProjeto = 40;
        int dias = calc.calculaQuantidadeDeDiasDadoHora(tempoEstimadoProjeto);
        int resto = calc.restoTempoEstimadoParaTamanhoDoDia(tempoEstimadoProjeto);
        assertEquals("Quantidade De dias esperados:", 5, dias);
        assertEquals("Sobra de tempo esperados(Horas):", 0, resto);
    }

    @Test
    public void testContagemDeDiasDadoHoraComSobra() {
        int dias = calc.calculaQuantidadeDeDiasDadoHora(tempoEstimadoProjeto);
        int resto = calc.restoTempoEstimadoParaTamanhoDoDia(tempoEstimadoProjeto);
        assertEquals("Quantidade De dias esperados:", 5, dias);
        assertEquals("Sobra de tempo esperados(Horas):", 5, resto);
    }

    @Test
    public void testDataDeEntregaDoisDias() {

        DataDoSistema saida = calculaEntrega(8, 16);
        assertEquals("2019-05-12 08:25", DataUtil.formatarDataYYYYMMDDHHMI(saida.calendario().getTime()));
    }

    @Test
    public void testDataDeEntregaDoisDiasQuatroHoras() {
        DataDoSistema saida = calculaEntrega(8, 20);
        assertEquals("2019-05-12 12:25", DataUtil.formatarDataYYYYMMDDHHMI(saida.calendario().getTime()));

    }

    @Test
    public void testDataDeEntregaDadoConfiguracaoDoisDiasAntesExpediente() {
        DataDoSistema saida = calculaEntrega(7, 16);
        assertEquals("2019-05-12 08:25", DataUtil.formatarDataYYYYMMDDHHMI(saida.calendario().getTime()));
    }

    @Test
    public void testDataDeEntregaDadoConfiguracaoDoisDiasDepoisExpediente() {
        DataDoSistema saida = calculaEntrega(19, 16);
        assertEquals("2019-05-13 08:00", DataUtil.formatarDataYYYYMMDDHHMI(saida.calendario().getTime()));
    }

    @Test
    public void testDataDeEntregaDadoConfiguracao() {
        DataDoSistema saida = calculaEntrega(19, 20);
        assertEquals("2019-05-13 12:00", DataUtil.formatarDataYYYYMMDDHHMI(saida.calendario().getTime()));
    }

    @Test
    public void testDataDeEntregaDadoConfiguracaoComAlmoco() {
        DataDoSistema saida = calculaEntrega(19, 21,true);
        assertEquals("2019-05-13 15:00", DataUtil.formatarDataYYYYMMDDHHMI(saida.calendario().getTime()));
    }
     @Test
    public void testDataDeEntregaDadoConfiguracaoComFolga() {
        DataDoSistema saida = calculaEntregaConsiderandoFolga(8, 21);
        assertEquals("2019-08-14 15:25", DataUtil.formatarDataYYYYMMDDHHMI(saida.calendario().getTime()));
    }

    @Test
    public void testDataDeEntregaDadoConfiguracaoSemAlmoco() {
        DataDoSistema saida = calculaEntrega(19, 21,false);
        assertEquals("2019-05-13 13:00", DataUtil.formatarDataYYYYMMDDHHMI(saida.calendario().getTime()));
    }

    static DataDoSistema calculaEntrega(int horaEntrada, int limite,boolean temAlmoco) {
        return  EnvorimentData.calculaEntrega(horaEntrada, limite,temAlmoco);
    }
    static DataDoSistema calculaEntrega(int horaEntrada, int limite) {
        return  EnvorimentData.calculaEntrega(horaEntrada, limite,false);
    }
    
    static DataDoSistema calculaEntregaConsiderandoFolga(int horaEntrada, int limite) {
        return  EnvorimentData.calculaEntregaConsiderandoFolga(horaEntrada, limite,true);
    }

}
