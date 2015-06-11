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

public class Project implements Serializable {
   
    private Integer idProject;
    
    private String projectName;
    
    private String description;
  
    private String publishYear;
    
    private Genre genreId;
   
    private Soundman soundmanId;
   
    private Casting castingId;

    public Project() {
    }

    public Project(Integer idProject) {
        this.idProject = idProject;
    }

    public Project(Integer idProject, String projectName) {
        this.idProject = idProject;
        this.projectName = projectName;
    }

    public Integer getIdProject() {
        return idProject;
    }

    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public Genre getGenreId() {
        return genreId;
    }

    public void setGenreId(Genre genreId) {
        this.genreId = genreId;
    }

    public Soundman getSoundmanId() {
        return soundmanId;
    }

    public void setSoundmanId(Soundman soundmanId) {
        this.soundmanId = soundmanId;
    }

    public Casting getCastingId() {
        return castingId;
    }

    public void setCastingId(Casting castingId) {
        this.castingId = castingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProject != null ? idProject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.idProject == null && other.idProject != null) || (this.idProject != null && !this.idProject.equals(other.idProject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.kira.webprofiler.data.Model.Entity.Project[ idProject=" + idProject + " ]";
    }
    
}
