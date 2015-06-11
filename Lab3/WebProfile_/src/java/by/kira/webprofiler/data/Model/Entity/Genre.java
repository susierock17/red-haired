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

public class Genre implements Serializable {
    
    private Integer idGenre;
   
    private String genreName;
    
    public Genre() {
    }

    public Genre(Integer idGenre) {
        this.idGenre = idGenre;
    }

    public Genre(Integer idGenre, String genreName) {
        this.idGenre = idGenre;
        this.genreName = genreName;
    }

    public Integer getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Integer idGenre) {
        this.idGenre = idGenre;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGenre != null ? idGenre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genre)) {
            return false;
        }
        Genre other = (Genre) object;
        if ((this.idGenre == null && other.idGenre != null) || (this.idGenre != null && !this.idGenre.equals(other.idGenre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  genreName;
    }
}
