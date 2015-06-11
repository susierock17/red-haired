/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.Entity.Generated;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kira
 */
@Entity
@Table(name = "casting")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casting.findAll", query = "SELECT c FROM Casting c"),
    @NamedQuery(name = "Casting.findByIdCasting", query = "SELECT c FROM Casting c WHERE c.idCasting = :idCasting"),
    @NamedQuery(name = "Casting.findByActorList", query = "SELECT c FROM Casting c WHERE c.actorList = :actorList")})
public class Casting implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_casting")
    private Integer idCasting;
    @Column(name = "actor_list")
    private String actorList;
    @OneToMany(mappedBy = "castingId")
    private Collection<Project> projectCollection;

    public Casting() {
    }

    public Casting(Integer idCasting) {
        this.idCasting = idCasting;
    }

    public Integer getIdCasting() {
        return idCasting;
    }

    public void setIdCasting(Integer idCasting) {
        this.idCasting = idCasting;
    }

    public String getActorList() {
        return actorList;
    }

    public void setActorList(String actorList) {
        this.actorList = actorList;
    }

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCasting != null ? idCasting.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casting)) {
            return false;
        }
        Casting other = (Casting) object;
        if ((this.idCasting == null && other.idCasting != null) || (this.idCasting != null && !this.idCasting.equals(other.idCasting))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return actorList;
    }
    
}
