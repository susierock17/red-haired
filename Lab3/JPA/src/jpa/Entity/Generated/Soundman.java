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
@Table(name = "soundman")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Soundman.findAll", query = "SELECT s FROM Soundman s"),
    @NamedQuery(name = "Soundman.findByIdSoundman", query = "SELECT s FROM Soundman s WHERE s.idSoundman = :idSoundman"),
    @NamedQuery(name = "Soundman.findBySoundmanName", query = "SELECT s FROM Soundman s WHERE s.soundmanName = :soundmanName")})
public class Soundman implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_soundman")
    private Integer idSoundman;
    @Basic(optional = false)
    @Column(name = "soundman_name")
    private String soundmanName;
    @OneToMany(mappedBy = "soundmanId")
    private Collection<Project> projectCollection;

    public Soundman() {
    }

    public Soundman(Integer idSoundman) {
        this.idSoundman = idSoundman;
    }

    public Soundman(Integer idSoundman, String soundmanName) {
        this.idSoundman = idSoundman;
        this.soundmanName = soundmanName;
    }

    public Integer getIdSoundman() {
        return idSoundman;
    }

    public void setIdSoundman(Integer idSoundman) {
        this.idSoundman = idSoundman;
    }

    public String getSoundmanName() {
        return soundmanName;
    }

    public void setSoundmanName(String soundmanName) {
        this.soundmanName = soundmanName;
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
        hash += (idSoundman != null ? idSoundman.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soundman)) {
            return false;
        }
        Soundman other = (Soundman) object;
        if ((this.idSoundman == null && other.idSoundman != null) || (this.idSoundman != null && !this.idSoundman.equals(other.idSoundman))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return soundmanName;
    }
    
}
