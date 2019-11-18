package com.yomia.webform;

import com.yomia.webform.formularios.AcaoFormulario;
import com.yomia.webform.formularios.CadastroStatus;
import com.yomia.webform.formularios.CadastroTipoAtividade;
import com.yomia.webform.formularios.ClienteListaTicket;
import com.yomia.webform.formularios.FormularioAtividade;
import com.yomia.webform.service.face.FormularioGenerico;
import com.yomia.webform.formularios.ListaTipoAtividade;
import java.util.HashMap;
import java.util.Map;

public enum EnumeracaoFormulariosSistema {

    CADASTRAR_ATIVIDADE(new Object[]{"atividade.form.cad", new FormularioAtividade(AcaoFormulario.CADASTRAR)}),
    CADASTRAR_TIPO_ATIVIDADE(new Object[]{"tipo_atividade.form.cad", new CadastroTipoAtividade()}),
    CADASTRAR_STATUS_ATIVIDADE(new Object[]{"status_atividade.form.cad", new CadastroStatus()}),
    
    LISTAR_ATIVIDADE(new Object[]{"atividade.form.lista", new FormularioAtividade(AcaoFormulario.LISTAR)}),
    AVANCA_STATUS_ATIVIDADE(new Object[]{"atividade.avanca.status", new FormularioAtividade(AcaoFormulario.AVANCAR_STATUS)}),
    LISTAR_TIPO_ATIVIDADE(new Object[]{"tipo_atividade.lista", new ListaTipoAtividade()}),
    LISTA_TICKET(new Object[]{"ticket.list", new ClienteListaTicket()})
    ;

    public Object[] uri_obj;

    private EnumeracaoFormulariosSistema(Object[] uri) {
        this.uri_obj = uri;
    }

    public String uri() {
        return (String) uri_obj[0];
    }

    private static Map<String, EnumeracaoFormulariosSistema> relacao;
    
    static {
        relacao = new HashMap<>();
        for (EnumeracaoFormulariosSistema s : values()) {
            relacao.put((String) s.uri_obj[0], s);
        }
    }

    public static FormularioGenerico retornaFormPorURI(String URI) {
        if(!relacao.containsKey(URI)){
            throw  new NullPointerException("Nenhuma relação declarada para "+URI);
        }
        final Object var = relacao.get(URI).uri_obj[1];
        
        return (FormularioGenerico) var;
    }

    

}
