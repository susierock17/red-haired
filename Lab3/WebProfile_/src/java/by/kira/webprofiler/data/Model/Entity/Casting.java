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

public class Casting implements Serializable {
    
    private Integer idCasting;
    
    private String actorList;
    

    public Casting() {
    }

    public Casting(Integer idCasting) {
        this.idCasting = idCasting;
    }

    public Casting(Integer idCasting, String actorList) {
        this.idCasting = idCasting;
        this.actorList = actorList;
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
        return  actorList;
    }

    
    
}
