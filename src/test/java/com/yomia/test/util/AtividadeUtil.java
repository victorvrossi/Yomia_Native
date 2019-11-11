
package com.yomia.test.util;

import com.yomia.jpa.dao.DaoAtividade;
import com.yomia.jpa.dao.DaoFuncionario;
import com.yomia.jpa.dao.DaoProjeto;
import com.yomia.jpa.dao.DaoStatus;
import com.yomia.jpa.dao.DaoTipoAtividade;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbFluxoAtividade;
import com.yomia.jpa.entidade.TbFluxoSequencia;
import com.yomia.jpa.entidade.TbFuncionario;
import com.yomia.jpa.entidade.TbProjeto;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.jpa.entidade.TbTipoAtividade;
import java.util.ArrayList;
import static org.junit.Assert.assertNotNull;

public class AtividadeUtil {
     public  TbAtividade novaAtividade() {
        TbProjeto projeto = novoProjeto();
        TbStatus novoStatus = novoStatus();
        TbTipoAtividade novoTipoAtividade = novoTipoAtividade();
        TbFuncionario novoFuncionario = novoFuncionario();
        
        String titulo = "TESTE";
        String codigoAtividade = "TESTE-001";
        String descricao = "TESTE";
        DaoAtividade instance = new DaoAtividade();
        
        TbAtividade novaAtividade = instance.novaAtividade(titulo, codigoAtividade, descricao, projeto, novoStatus, novoTipoAtividade, novoFuncionario);
        return novaAtividade;
    }

    private TbFuncionario novoFuncionario() {
        TbFuncionario novoFuncionario = new DaoFuncionario().novoFuncionario("func");
        assertNotNull(novoFuncionario.getId());
        return novoFuncionario;
    }

    private TbTipoAtividade novoTipoAtividade() {
        TbFluxoAtividade fluxo = new TbFluxoAtividade();
        fluxo.setTitulo("Fluxo Teste");
        fluxo.setVisibilidadePublica(true);
        fluxo.setTbFluxoSequenciaList(new ArrayList<TbFluxoSequencia>());
        fluxo.setTbTipoAtividadeList(new ArrayList<TbTipoAtividade>());
        TbTipoAtividade novoTipoAtividade = new DaoTipoAtividade().novoTipoAtividade("Tipo",fluxo);
        assertNotNull(novoTipoAtividade.getId());
        return novoTipoAtividade;
    }

    private TbStatus novoStatus() {
        TbStatus novoStatus = new DaoStatus().novoStatus("aberto");
        assertNotNull(novoStatus.getId());
        return novoStatus;
    }

    private TbProjeto novoProjeto() {
        TbProjeto projeto = new DaoProjeto().novoProjeto("Yomia", "YMA");
        assertNotNull(projeto.getId());
        return projeto;
    }
    
}
