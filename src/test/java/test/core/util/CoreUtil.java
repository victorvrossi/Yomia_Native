package test.core.util;

import com.yomia.jpa.dao.DaoAtividade;
import com.yomia.jpa.dao.DaoFuncionario;
import com.yomia.jpa.dao.DaoProjeto;
import com.yomia.jpa.dao.DaoStatus;
import com.yomia.jpa.dao.DaoTipoAtividade;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbFluxoAtividade;
import com.yomia.jpa.entidade.TbFuncionario;
import com.yomia.jpa.entidade.TbProjeto;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.jpa.entidade.TbTipoAtividade;
import static org.junit.Assert.assertNotNull;

public class CoreUtil {

    TbProjeto projeto;
    TbStatus novoStatus;
    TbTipoAtividade novoTipoAtividade;
    TbFuncionario novoFuncionario;

    public TbAtividade novaAtividade() {
        TbAtividade novaAtividade = null;
        try {
            projeto = novoProjeto();
            novoStatus = novoStatus();
            novoTipoAtividade = novoTipoAtividade();
            novoFuncionario = novoFuncionario();

            String titulo = "TESTE";
            String codigoAtividade = "TESTE-001";
            String descricao = "TESTE";
            DaoAtividade instance = new DaoAtividade();
            novaAtividade = instance.novaAtividade(titulo, codigoAtividade, descricao, projeto, novoStatus, novoTipoAtividade, novoFuncionario);
        } catch (Exception e) {
            System.out.println("Falhou:" + e);
        }
        return novaAtividade;
    }

    public TbFuncionario novoFuncionario() {
        TbFuncionario novoFuncionario = new DaoFuncionario().novoFuncionario("func");
        assertNotNull(novoFuncionario.getId());
        return novoFuncionario;
    }

    public TbTipoAtividade novoTipoAtividade() {
        TbFluxoAtividade fluxo = new TbFluxoAtividade();
        fluxo.setTitulo("Fluxo Teste");
        fluxo.setVisibilidadePublica(true);

        TbTipoAtividade novoTipoAtividade = new DaoTipoAtividade().novoTipoAtividade("Tipo", fluxo);
        assertNotNull(novoTipoAtividade.getId());
        return novoTipoAtividade;
    }

    public TbStatus novoStatus() {
        TbStatus novoStatus = new DaoStatus().novoStatus("aberto");
        assertNotNull(novoStatus.getId());
        return novoStatus;
    }

    public TbProjeto novoProjeto() {
        TbProjeto projeto = new DaoProjeto().novoProjeto("Yomia", "YMA");
        assertNotNull(projeto.getId());
        return projeto;
    }

    public TbProjeto getProjeto() {
        return projeto;
    }

    public TbStatus getNovoStatus() {
        return novoStatus;
    }

    public TbTipoAtividade getNovoTipoAtividade() {
        return novoTipoAtividade;
    }

    public TbFuncionario getNovoFuncionario() {
        return novoFuncionario;
    }
    
    
    
    
    

}
