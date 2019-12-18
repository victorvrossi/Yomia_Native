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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "tb_fluxo_atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFluxoAtividade.findAll", query = "SELECT t FROM TbFluxoAtividade t"),
    @NamedQuery(name = "TbFluxoAtividade.findById", query = "SELECT t FROM TbFluxoAtividade t WHERE t.id = :id"),
    @NamedQuery(name = "TbFluxoAtividade.findByTitulo", query = "SELECT t FROM TbFluxoAtividade t WHERE t.titulo = :titulo")})
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFluxo")
    private List<TbFluxoSequencia> tbFluxoSequenciaList;
    @JoinColumn(name = "id_tipo_atv", referencedColumnName = "id")
    @OneToOne(optional = false)
    private TbTipoAtividade idTipoAtv;

    public TbFluxoAtividade() {
    }

    public TbFluxoAtividade(Integer id) {
        this.id = id;
    }

    public TbFluxoAtividade(Integer id, String titulo) {
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
    public List<TbFluxoSequencia> getTbFluxoSequenciaList() {
        return tbFluxoSequenciaList;
    }

    public void setTbFluxoSequenciaList(List<TbFluxoSequencia> tbFluxoSequenciaList) {
        this.tbFluxoSequenciaList = tbFluxoSequenciaList;
    }

    public TbTipoAtividade getIdTipoAtv() {
        return idTipoAtv;
    }

    public void setIdTipoAtv(TbTipoAtividade idTipoAtv) {
        this.idTipoAtv = idTipoAtv;
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
