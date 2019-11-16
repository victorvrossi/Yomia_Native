package com.yomia.jpa.entidade;

import com.yomia.jpa.controler.BaseEntidade;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tb_status_atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbStatusAtividade.findAll", query = "SELECT t FROM TbStatusAtividade t"),
    @NamedQuery(name = "TbStatusAtividade.findById", query = "SELECT t FROM TbStatusAtividade t WHERE t.id = :id"),
    @NamedQuery(name = "TbStatusAtividade.findByDataEntrada", query = "SELECT t FROM TbStatusAtividade t WHERE t.dataEntrada = :dataEntrada")})
public class TbStatusAtividade implements BaseEntidade {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_entrada")
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @JoinColumn(name = "id_atividade", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.PERSIST)
    private TbAtividade idAtividade;
    @JoinColumn(name = "id_status", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private TbStatus idStatus;

    public TbStatusAtividade() {
    }

    public TbStatusAtividade(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public TbAtividade getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(TbAtividade idAtividade) {
        this.idAtividade = idAtividade;
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
        if (!(object instanceof TbStatusAtividade)) {
            return false;
        }
        TbStatusAtividade other = (TbStatusAtividade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yomia.jpa.entidade.TbStatusAtividade[ id=" + id + " ]";
    }

}
