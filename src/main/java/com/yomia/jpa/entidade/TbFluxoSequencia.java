package com.yomia.jpa.entidade;

import com.yomia.jpa.controler.BaseEntidade;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "tb_fluxo_sequencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFluxoSequencia.findAll", query = "SELECT t FROM TbFluxoSequencia t"),
    @NamedQuery(name = "TbFluxoSequencia.findById", query = "SELECT t FROM TbFluxoSequencia t WHERE t.id = :id"),
    @NamedQuery(name = "TbFluxoSequencia.findByOrdem", query = "SELECT t FROM TbFluxoSequencia t WHERE t.ordem = :ordem")})
public class TbFluxoSequencia implements BaseEntidade {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ordem")
    private int ordem;
    @JoinColumn(name = "id_fluxo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TbFluxoAtividade idFluxo;
    @JoinColumn(name = "id_status", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TbStatus idStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeqChegada")
    private List<TbFluxoDesvio> tbFluxoDesvioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeqSaida")
    private List<TbFluxoDesvio> tbFluxoDesvioList1;

    public TbFluxoSequencia() {
    }

    public TbFluxoSequencia(Integer id) {
        this.id = id;
    }

    public TbFluxoSequencia(Integer id, int ordem) {
        this.id = id;
        this.ordem = ordem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
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

    @XmlTransient
    public List<TbFluxoDesvio> getTbFluxoDesvioList() {
        return tbFluxoDesvioList;
    }

    public void setTbFluxoDesvioList(List<TbFluxoDesvio> tbFluxoDesvioList) {
        this.tbFluxoDesvioList = tbFluxoDesvioList;
    }

    @XmlTransient
    public List<TbFluxoDesvio> getTbFluxoDesvioList1() {
        return tbFluxoDesvioList1;
    }

    public void setTbFluxoDesvioList1(List<TbFluxoDesvio> tbFluxoDesvioList1) {
        this.tbFluxoDesvioList1 = tbFluxoDesvioList1;
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
