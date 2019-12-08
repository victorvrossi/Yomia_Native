package com.yomia.jpa.entidade;

import com.yomia.jpa.controler.BaseEntidade;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tb_fluxo_atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFluxoAtividade.findAll", query = "SELECT t FROM TbFluxoAtividade t"),
    @NamedQuery(name = "TbFluxoAtividade.findById", query = "SELECT t FROM TbFluxoAtividade t WHERE t.id = :id"),
    @NamedQuery(name = "TbFluxoAtividade.findByTitulo", query = "SELECT t FROM TbFluxoAtividade t WHERE t.titulo = :titulo"),
    @NamedQuery(name = "TbFluxoAtividade.findByVisibilidadePublica", query = "SELECT t FROM TbFluxoAtividade t WHERE t.visibilidadePublica = :visibilidadePublica")})
public class TbFluxoAtividade implements BaseEntidade {

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
    @Column(name = "visibilidade_publica")
    private boolean visibilidadePublica;

    public TbFluxoAtividade() {
    }

    public TbFluxoAtividade(Integer id) {
        this.id = id;
    }

    public TbFluxoAtividade(Integer id, String titulo, boolean visibilidadePublica) {
        this.id = id;
        this.titulo = titulo;
        this.visibilidadePublica = visibilidadePublica;
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

    public boolean getVisibilidadePublica() {
        return visibilidadePublica;
    }

    public void setVisibilidadePublica(boolean visibilidadePublica) {
        this.visibilidadePublica = visibilidadePublica;
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
        if (!(object instanceof TbFluxoAtividade)) {
            return false;
        }
        TbFluxoAtividade other = (TbFluxoAtividade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yomia.jpa.entidade.TbFluxoAtividade[ id=" + id + " ]";
    }

}
