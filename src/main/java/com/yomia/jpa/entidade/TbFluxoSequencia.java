package com.yomia.jpa.entidade;

import com.yomia.jpa.controler.BaseEntidade;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tb_fluxo_sequencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFluxoSequencia.findAll", query = "SELECT t FROM TbFluxoSequencia t"),
    @NamedQuery(name = "TbFluxoSequencia.findById", query = "SELECT t FROM TbFluxoSequencia t WHERE t.id = :id")})
public class TbFluxoSequencia implements BaseEntidade{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_fluxo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TbFluxoAtividade idFluxo;
    @JoinColumn(name = "id_status", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TbStatus idStatus;

    public TbFluxoSequencia() {
    }

    public TbFluxoSequencia(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TbFluxoAtividade getIdFluxo() {
        return idFluxo;
    }

    public void setIdFluxo(TbFluxoAtividade idFluxo) {
        this.idFluxo = idFluxo;
    }

    public TbStatus getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(TbStatus idStatus) {
        this.idStatus = idStatus;
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
        if (!(object instanceof TbFluxoSequencia)) {
            return false;
        }
        TbFluxoSequencia other = (TbFluxoSequencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yomia.jpa.entidade.TbFluxoSequencia[ id=" + id + " ]";
    }

}
