/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yomia.webform;

import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.test.Unitario;
import com.yomia.webform.requisicao.ClienteListaTicket;
import com.yomia.webform.requisicao.RequisicaoAvancarStatusAtividade;
import com.yomia.webform.requisicao.RequisicaoCadastrarAtividade;
import com.yomia.webform.requisicao.RequisicaoCadastrarFuncionario;
import com.yomia.webform.requisicao.RequisicaoCadastroStatus;
import com.yomia.webform.requisicao.RequisicaoCadastroTipoAtividade;
import com.yomia.webform.requisicao.RequisicaoListaTipoAtividade;
import com.yomia.webform.requisicao.RequisicaoListarAtividade;
import com.yomia.webform.requisicao.RequisicaoSolicitarLogin;
import com.yomia.webform.service.face.RequisicaoGenerica;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;

@Category(Unitario.class)
public class EnumeracaoFormulariosSistemaTest {

    /**
     * Test of retornaFormPorURI method, of class EnumeracaoFormulariosSistema.
     */
    @Test
    public void testRetornaFormPorURI() throws Exception {
        System.out.println("retornaFormPorURI");

        testEnum("atividade.form.cad", new RequisicaoCadastrarAtividade());
        testEnum("tipo_atividade.form.cad", new RequisicaoCadastroTipoAtividade());
        testEnum("status_atividade.form.cad", new RequisicaoCadastroStatus());
        testEnum("funcionario.form.cad", new RequisicaoCadastrarFuncionario());
        testEnum("atividade.form.lista", new RequisicaoListarAtividade());
        testEnum("tipo_atividade.lista", new RequisicaoListaTipoAtividade());
        testEnum("ticket.list", new ClienteListaTicket());
        testEnum("usuario.login", new RequisicaoSolicitarLogin());
        testEnum("atividade.avanca.status", new RequisicaoAvancarStatusAtividade());
    }

    private void testEnum(String uri, RequisicaoGenerica expResult) throws FalhaGenerica {
        RequisicaoGenerica result = EnumeracaoFormulariosSistema.retornaFormPorURI(uri);
        assertEquals(expResult.getClass(), result.getClass());
    }

}
