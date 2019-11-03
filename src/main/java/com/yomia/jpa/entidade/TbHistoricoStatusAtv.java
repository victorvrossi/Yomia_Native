package com.yomia.jpa.entidade;

import com.yomia.jpa.controler.BaseEntidade;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "tb_historico_status_atv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbHistoricoStatusAtv.findAll", query = "SELECT t FROM TbHistoricoStatusAtv t"),
    @NamedQuery(name = "TbHistoricoStatusAtv.findById", query = "SELECT t FROM TbHistoricoStatusAtv t WHERE t.id = :id"),
    @NamedQuery(name = "TbHistoricoStatusAtv.findByDataEfetivado", query = "SELECT t FROM TbHistoricoStatusAtv t WHERE t.dataEfetivado = :dataEfetivado")})
public class TbHistoricoStatusAtv implements BaseEntidade {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_efetivado")
    @Temporal(TemporalType.DATE)
    private Date dataEfetivado;
    @JoinColumn(name = "id_atividade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TbAtividade idAtividade;
    @JoinColumn(name = "id_status", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TbStatus idStatus;

    public TbHistoricoStatusAtv() {
    }

    public TbHistoricoStatusAtv(Integer id) {
        this.id = id;
    }

    public TbHistoricoStatusAtv(Integer id, Date dataEfetivado) {
        this.id = id;
        this.dataEfetivado = dataEfetivado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataEfetivado() {
        return dataEfetivado;
    }

    public void setDataEfetivado(Date dataEfetivado) {
        this.dataEfetivado = dataEfetivado;
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
        if (!(object instanceof TbHistoricoStatusAtv)) {
            return false;
        }
        TbHistoricoStatusAtv other = (TbHistoricoStatusAtv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yomia.jpa.entidade.TbHistoricoStatusAtv[ id=" + id + " ]";
    }
    
}
