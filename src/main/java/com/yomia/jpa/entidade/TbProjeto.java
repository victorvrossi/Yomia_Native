package com.yomia.jpa.entidade;

import com.yomia.jpa.controler.BaseEntidade;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "tb_projeto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProjeto.findAll", query = "SELECT t FROM TbProjeto t"),
    @NamedQuery(name = "TbProjeto.findById", query = "SELECT t FROM TbProjeto t WHERE t.id = :id"),
    @NamedQuery(name = "TbProjeto.findByTitulo", query = "SELECT t FROM TbProjeto t WHERE t.titulo = :titulo"),
    @NamedQuery(name = "TbProjeto.findBySigla", query = "SELECT t FROM TbProjeto t WHERE t.sigla = :sigla")})
public class TbProjeto implements BaseEntidade {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "sigla")
    private String sigla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProjeto")
    private List<TbAtividade> tbAtividadeList;

    public TbProjeto() {
    }

    public TbProjeto(Integer id) {
        this.id = id;
    }

    public TbProjeto(Integer id, String titulo, String sigla) {
        this.id = id;
        this.titulo = titulo;
        this.sigla = sigla;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
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
        if (!(object instanceof TbProjeto)) {
            return false;
        }
        TbProjeto other = (TbProjeto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yomia.jpa.entidade.TbProjeto[ id=" + id + " ]";
    }
    
}
