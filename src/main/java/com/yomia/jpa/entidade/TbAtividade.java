/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yomia.jpa.entidade;

import com.yomia.jpa.controler.BaseEntidade;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "tb_atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAtividade.findAll", query = "SELECT t FROM TbAtividade t"),
    @NamedQuery(name = "TbAtividade.findById", query = "SELECT t FROM TbAtividade t WHERE t.id = :id"),
    @NamedQuery(name = "TbAtividade.findByTitulo", query = "SELECT t FROM TbAtividade t WHERE t.titulo = :titulo"),
    @NamedQuery(name = "TbAtividade.findByDataCriacao", query = "SELECT t FROM TbAtividade t WHERE t.dataCriacao = :dataCriacao"),
    @NamedQuery(name = "TbAtividade.findByCodigoAtividade", query = "SELECT t FROM TbAtividade t WHERE t.codigoAtividade = :codigoAtividade")})
public class TbAtividade implements BaseEntidade {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAtividade")
    private List<TbHistoricoStatusAtv> tbHistoricoStatusAtvList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idAtividade")
    private TbStatusAtividade tbStatusAtividade;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_criacao")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codigo_atividade")
    private String codigoAtividade;
    @JoinColumn(name = "id_responsavel", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TbFuncionario idResponsavel;
    @JoinColumn(name = "id_projeto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TbProjeto idProjeto;
    @JoinColumn(name = "id_tipo_atividade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TbTipoAtividade idTipoAtividade;

    public TbAtividade() {
    }

    public TbAtividade(Integer id) {
        this.id = id;
    }

    public TbAtividade(Integer id, String titulo, String descricao, Date dataCriacao, String codigoAtividade) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.codigoAtividade = codigoAtividade;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getCodigoAtividade() {
        return codigoAtividade;
    }

    public void setCodigoAtividade(String codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }

    public TbFuncionario getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(TbFuncionario idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public TbProjeto getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(TbProjeto idProjeto) {
        this.idProjeto = idProjeto;
    }

    public TbTipoAtividade getIdTipoAtividade() {
        return idTipoAtividade;
    }

    public void setIdTipoAtividade(TbTipoAtividade idTipoAtividade) {
        this.idTipoAtividade = idTipoAtividade;
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
        if (!(object instanceof TbAtividade)) {
            return false;
        }
        TbAtividade other = (TbAtividade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yomia.jpa.entidade.TbAtividade[ id=" + id + " ]";
    }

    @XmlTransient
    public List<TbHistoricoStatusAtv> getTbHistoricoStatusAtvList() {
        return tbHistoricoStatusAtvList;
    }

    public void setTbHistoricoStatusAtvList(List<TbHistoricoStatusAtv> tbHistoricoStatusAtvList) {
        this.tbHistoricoStatusAtvList = tbHistoricoStatusAtvList;
    }

    public TbStatusAtividade getTbStatusAtividade() {
        return tbStatusAtividade;
    }

    public void setTbStatusAtividade(TbStatusAtividade tbStatusAtividade) {
        this.tbStatusAtividade = tbStatusAtividade;
    }
    
}
