package com.yomia.jpa.entidade;

import com.yomia.jpa.controler.BaseEntidade;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "tb_funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFuncionario.findAll", query = "SELECT t FROM TbFuncionario t"),
    @NamedQuery(name = "TbFuncionario.findById", query = "SELECT t FROM TbFuncionario t WHERE t.id = :id"),
    @NamedQuery(name = "TbFuncionario.findByNome", query = "SELECT t FROM TbFuncionario t WHERE t.nome = :nome")})
public class TbFuncionario implements BaseEntidade {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idResponsavel")
    private List<TbAtividade> tbAtividadeList;

    public TbFuncionario() {
    }

    public TbFuncionario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        if (!(object instanceof TbFuncionario)) {
            return false;
        }
        TbFuncionario other = (TbFuncionario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yomia.jpa.entidade.TbFuncionario[ id=" + id + " ]";
    }

}
