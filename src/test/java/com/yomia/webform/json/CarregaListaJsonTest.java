
package com.yomia.webform.json;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.dao.DaoAtividade;
import com.yomia.modulo.atividade.Atividade;
import com.yomia.modulo.atividade.Entidade;
import com.yomia.modulo.data.DataUtil;
import com.yomia.test.util.AtividadeUtil;
import com.yomia.test.util.MainFuncionalTest;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;


public class CarregaListaJsonTest extends MainFuncionalTest{
        
    @Test
    public void testListaTodosElementoEmJson() {
        new AtividadeUtil().novaAtividade();
        new AtividadeUtil().novaAtividade();
        System.out.println("listaTodosElementoEmJson");
        Class<? extends DaoGenerico> daoClass = DaoAtividade.class;
        Class<? extends JsonAtividade> jsonClass = JsonAtividade.class;
        Class<? extends Entidade> entidadeClass = Atividade.class;
        CarregaListaJson instance = new CarregaListaJson();
        String result = instance.listaTodosElementoEmJson(daoClass, jsonClass, entidadeClass);        
        assertNotNull(result);
        
        String dataCriacao = DataUtil.formatarData(DataUtil.atual().data());
        String exp = "[{\"codigoAtividade\":\"TESTE-001\",\"titulo\":\"TESTE\",\"descricao\":\"TESTE\",\"status\":\"aberto\",\"tipo\":\"Tipo\",\"dataCriacao\":\""+dataCriacao+"\"},{\"codigoAtividade\":\"TESTE-001\",\"titulo\":\"TESTE\",\"descricao\":\"TESTE\",\"status\":\"aberto\",\"tipo\":\"Tipo\",\"dataCriacao\":\""+dataCriacao+"\"}]";
        assertEquals(exp, result);
    }
    
    
}
