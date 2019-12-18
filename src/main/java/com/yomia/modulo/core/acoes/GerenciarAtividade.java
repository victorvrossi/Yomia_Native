package com.yomia.modulo.core.acoes;

import com.yomia.jpa.dao.DaoAtividade;
import com.yomia.jpa.dao.DaoFuncionario;
import com.yomia.jpa.dao.DaoTipoAtividade;
import com.yomia.jpa.entidade.TbFuncionario;
import com.yomia.jpa.entidade.TbProjeto;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.jpa.entidade.TbTipoAtividade;
import com.yomia.modulo.core.Funcionario;
import com.yomia.modulo.falhas.FalhaGenerica;
import java.util.List;

public class GerenciarAtividade implements GerenciarSistema
{

    public static void cadastrar(String titulo, String descricao, String tipo, Funcionario responsavel) throws FalhaGenerica {
        final TbTipoAtividade tipoAtividade = new DaoTipoAtividade().carregaTipoAtividadePorTitulo(tipo);
        DaoFuncionario daoFuncionario = new DaoFuncionario();
        List<TbFuncionario> l = daoFuncionario.pesquisaPorNome(responsavel.getNome());
        if (l.size() < 1) {
            throw new FalhaGenerica("").lancarError("Falha", "Erro", "Problema de funcionario");
        }
        TbFuncionario funcionario = l.get(0);
        TbStatus status = new TbStatus(1);
        TbProjeto tbProjeto = new TbProjeto(1);
        String codigo = tbProjeto.getSigla();
        new DaoAtividade().novaAtividade(titulo, "PARIO-005", descricao, tbProjeto, status, tipoAtividade, funcionario);
    }
}
