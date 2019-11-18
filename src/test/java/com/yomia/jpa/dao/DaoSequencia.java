package com.yomia.jpa.dao;

import com.yomia.jpa.entidade.TbFluxoAtividade;
import com.yomia.jpa.entidade.TbFluxoDesvio;
import com.yomia.jpa.entidade.TbFluxoSequencia;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.test.util.MainFuncionalTest;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DaoSequencia extends MainFuncionalTest {

    @Test
    public void hello() {
        try {
            TbStatus novoStatus = criaStatus();
            TbFluxoAtividade novoFluxo = criaFluxoAtividade();
            
            TbFluxoSequencia novaSequencia = criaFluxoSequencia(novoFluxo, novoStatus);
            
            criaFluxoDesvio(novaSequencia);
        } catch (Exception ex) {
            System.out.println("Falhou:"+ex);
        }
        
    }

    private void criaFluxoDesvio(TbFluxoSequencia novaSequencia) {
        DaoFluxoDesvio dev = new DaoFluxoDesvio();
        TbFluxoDesvio novoDesvio = dev.novoDesvio(novaSequencia, novaSequencia);
        assertNull(novoDesvio.getId());
    }

    private TbFluxoSequencia criaFluxoSequencia(TbFluxoAtividade novoFluxo, TbStatus novoStatus) throws Exception {
        DaoFluxoSequencia seq = new DaoFluxoSequencia();
        TbFluxoSequencia novaSequencia = seq.novaSequencia(novoFluxo, novoStatus,0);
        seq.salvar(novaSequencia);
        assertNotNull(novaSequencia.getId());
        assertNotNull(novaSequencia.getIdFluxo());
        assertNotNull(novaSequencia.getIdStatus());
        return novaSequencia;
    }

    private TbFluxoAtividade criaFluxoAtividade() {
        DaoFluxoAtividade f = new DaoFluxoAtividade();
        TbFluxoAtividade novoFluxo = f.novoFluxo("Fluxo Teste");
        assertNotNull(novoFluxo.getId());
        return novoFluxo;
    }

    private TbStatus criaStatus() {
        DaoStatus m = new DaoStatus();
        TbStatus novoStatus = m.novoStatus("Teste");
        assertNotNull(novoStatus.getId());
        return novoStatus;
    }
}
