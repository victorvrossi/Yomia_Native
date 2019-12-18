package com.yomia.jpa.entidade;

import com.yomia.jpa.controler.BaseEntidade;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tb_fluxo_desvio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFluxoDesvio.findAll", query = "SELECT t FROM TbFluxoDesvio t"),
    @NamedQuery(name = "TbFluxoDesvio.findById", query = "SELECT t FROM TbFluxoDesvio t WHERE t.id = :id")})
public class TbFluxoDesvio implements BaseEntidade {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_seq_chegada", referencedColumnName = "id")
    @ManyToOne(optional = false,cascade = CascadeType.ALL)
    private TbFluxoSequencia idSeqChegada;
    @JoinColumn(name = "id_seq_saida", referencedColumnName = "id")
    @ManyToOne(optional = false,cascade = CascadeType.ALL)
    private TbFluxoSequencia idSeqSaida;

    public TbFluxoDesvio() {
    }

    public TbFluxoDesvio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TbFluxoSequencia getIdSeqChegada() {
        return idSeqChegada;
    }

    public void setIdSeqChegada(TbFluxoSequencia idSeqChegada) {
        this.idSeqChegada = idSeqChegada;
    }

    public TbFluxoSequencia getIdSeqSaida() {
        return idSeqSaida;
    }

    public void setIdSeqSaida(TbFluxoSequencia idSeqSaida) {
        this.idSeqSaida = idSeqSaida;
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
        if (!(object instanceof TbFluxoDesvio)) {
            return false;
        }
        TbFluxoDesvio other = (TbFluxoDesvio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yomia.jpa.entidade.TbFluxoDesvio[ id=" + id + " ]";
    }

}
