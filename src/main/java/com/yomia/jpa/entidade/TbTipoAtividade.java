/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yomia.jpa.entidade;

import com.yomia.jpa.controler.BaseEntidade;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "tb_tipo_atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTipoAtividade.findAll", query = "SELECT t FROM TbTipoAtividade t"),
    @NamedQuery(name = "TbTipoAtividade.findById", query = "SELECT t FROM TbTipoAtividade t WHERE t.id = :id"),
    @NamedQuery(name = "TbTipoAtividade.findByTitulo", query = "SELECT t FROM TbTipoAtividade t WHERE t.titulo = :titulo")})
public class TbTipoAtividade implements BaseEntidade {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "titulo")
    private String titulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoAtividade")
    private List<TbAtividade> tbAtividadeList;

    public TbTipoAtividade() {
    }

    public TbTipoAtividade(Integer id) {
        this.id = id;
    }

    public TbTipoAtividade(Integer id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlTransient
    public List<TbAtividade> getTbAtividadeList() {
        return tbAtividadeList;
    }

    public void setTbAtividadeList(List<TbAtividade> tbAtividadeList) {
        this.tbAtividadeList = tbAtividadeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTipoAtividade)) {
            return false;
        }
        TbTipoAtividade other = (TbTipoAtividade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yomia.jpa.entidade.TbTipoAtividade[ id=" + id + " ]";
    }
    
}
