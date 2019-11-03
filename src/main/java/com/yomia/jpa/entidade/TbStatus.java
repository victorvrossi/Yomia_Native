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

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "tb_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbStatus.findAll", query = "SELECT t FROM TbStatus t"),
    @NamedQuery(name = "TbStatus.findById", query = "SELECT t FROM TbStatus t WHERE t.id = :id"),
    @NamedQuery(name = "TbStatus.findByTitulo", query = "SELECT t FROM TbStatus t WHERE t.titulo = :titulo")})
public class TbStatus implements BaseEntidade {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "titulo")
    private String titulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStatus")
    private List<TbHistoricoStatusAtv> tbHistoricoStatusAtvList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStatus")
    private List<TbStatusAtividade> tbStatusAtividadeList;

    public TbStatus() {
    }

    public TbStatus(Integer id) {
        this.id = id;
    }

    public TbStatus(Integer id, String titulo) {
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
    public List<TbHistoricoStatusAtv> getTbHistoricoStatusAtvList() {
        return tbHistoricoStatusAtvList;
    }

    public void setTbHistoricoStatusAtvList(List<TbHistoricoStatusAtv> tbHistoricoStatusAtvList) {
        this.tbHistoricoStatusAtvList = tbHistoricoStatusAtvList;
    }

    @XmlTransient
    public List<TbStatusAtividade> getTbStatusAtividadeList() {
        return tbStatusAtividadeList;
    }

    public void setTbStatusAtividadeList(List<TbStatusAtividade> tbStatusAtividadeList) {
        this.tbStatusAtividadeList = tbStatusAtividadeList;
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
        if (!(object instanceof TbStatus)) {
            return false;
        }
        TbStatus other = (TbStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yomia.jpa.entidade.TbStatus[ id=" + id + " ]";
    }
    
}
