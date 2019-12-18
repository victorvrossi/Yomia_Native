package com.yomia.modulo.core;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.dao.DaoTipoAtividade;
import com.yomia.jpa.entidade.TbFluxoAtividade;
import com.yomia.jpa.entidade.TbTipoAtividade;
import com.yomia.modulo.falhas.FalhaGenerica;

public class TipoAtividade extends Entidade{

    private String titulo;
    
    public void novoTipoAtividade(String tipo) throws FalhaGenerica{
        validaEntrada(tipo);
        DaoTipoAtividade novo = new DaoTipoAtividade();
        novo.novoTipoAtividade(tipo);
    }

    void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }


    private void validaEntrada(String tipo) {
        if(tipo == null || tipo.equals("")){
            throw new NullPointerException("Tipo de Atividada]e NULL");
        }
        
    }

    @Override
    public Entidade converteTabelaParaObjeto(BaseEntidade tb) {
        titulo = ((TbTipoAtividade)tb).getTitulo();
        return this;
    }
}
