/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.kira.webprofiler.data.Model.Entity;

import java.io.Serializable;

/**
 *
 * @author Kira
 */
public class Soundman implements Serializable {
    
    private Integer idSoundman;
    
    private String soundmanName;
    

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
        return  soundmanName;
    }
    
}
