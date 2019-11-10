
package com.yomia.jpa.dao;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbProjeto;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoProjeto extends DaoGenerico<TbProjeto>  {

    public TbProjeto novoProjeto(String titulo,String sigla){
        TbProjeto tbProjeto = new TbProjeto();
        tbProjeto.setSigla(sigla);
        tbProjeto.setTitulo(titulo);
        try {
            salvar(tbProjeto);
        } catch (Exception ex) {
            Logger.getLogger(DaoProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbProjeto;
    }
    @Override
    public Class<TbProjeto> getClasseTabela() {
        return TbProjeto.class;
    }
    
}
