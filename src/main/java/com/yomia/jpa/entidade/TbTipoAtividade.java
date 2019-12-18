package com.yomia.jpa.entidade;

import com.yomia.jpa.controler.BaseEntidade;
import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "tb_tipo_atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTipoAtividade.findAll", query = "SELECT t FROM TbTipoAtividade t"),
    @NamedQuery(name = "TbTipoAtividade.findById", query = "SELECT t FROM TbTipoAtividade t WHERE t.id = :id"),
    @NamedQuery(name = "TbTipoAtividade.findByTitulo", query = "SELECT t FROM TbTipoAtividade t WHERE t.titulo = :titulo")})
public class TbTipoAtividade implements BaseEntidade {

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idTipoAtv")
    private TbFluxoAtividade tbFluxoAtividade;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "titulo")
    private String titulo;
    @OneToMany(mappedBy = "idTipoAtividade")
    private List<TbAtividade> tbAtividadeList;

    public TbTipoAtividade() {
    }

    public TbTipoAtividade(Integer id) {
        this.id = id;
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

    public TbFluxoAtividade getTbFluxoAtividade() {
        return tbFluxoAtividade;
    }

    public void setTbFluxoAtividade(TbFluxoAtividade tbFluxoAtividade) {
        this.tbFluxoAtividade = tbFluxoAtividade;
    }

}
