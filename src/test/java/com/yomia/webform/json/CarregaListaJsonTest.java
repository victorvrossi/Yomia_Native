
package com.yomia.webform.json;

import com.yomia.webform.json.model.CarregaListaJson;
import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.dao.DaoAtividade;
import com.yomia.modulo.core.Atividade;
import com.yomia.modulo.core.Entidade;
import com.yomia.modulo.data.DataUtil;
import com.yomia.modulo.falhas.FalhaGenerica;
import test.core.util.CoreUtil;
import test.core.util.MainFuncionalTest;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;


public class CarregaListaJsonTest extends MainFuncionalTest{
        
    @Test
    public void testListaTodosElementoEmJson() throws FalhaGenerica {
        new CoreUtil().novaAtividade();
        new CoreUtil().novaAtividade();
        System.out.println("listaTodosElementoEmJson");
        Class<? extends DaoGenerico> daoClass = DaoAtividade.class;
        Class<? extends JsonListarAtividades> jsonClass = JsonListarAtividades.class;
        Class<? extends Entidade> entidadeClass = Atividade.class;
        CarregaListaJson instance = new CarregaListaJson();
        String result = instance.listaTodosElementoEmJson(daoClass, jsonClass, entidadeClass);        
        assertNotNull(result);
        
        String dataCriacao = DataUtil.formatarData(DataUtil.atual().data());
        String exp = "[{\"codigoAtividade\":\"TESTE-001\",\"titulo\":\"TESTE\",\"descricao\":\"TESTE\",\"status\":\"aberto\",\"tipo\":\"Tipo\",\"dataCriacao\":\""+dataCriacao+"\"},{\"codigoAtividade\":\"TESTE-001\",\"titulo\":\"TESTE\",\"descricao\":\"TESTE\",\"status\":\"aberto\",\"tipo\":\"Tipo\",\"dataCriacao\":\""+dataCriacao+"\"}]";
        assertEquals(exp, result);
    }
    
    
}
