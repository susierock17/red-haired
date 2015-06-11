/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 *
 * @author Kira
 */
@Entity
@Table(name="Projects")
public class Project  extends DubbingObject  implements Serializable {
    private Long projectID;
    private String name;
    private String description;
    private String publishDate;
    private Genre genre;
    private ArrayList<DubActor> dubActors;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getProjectID() {
        return projectID;
    }

    public void setProjectID(Long projectID) {
        this.projectID = projectID;
    }
    
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "PublishDate")
    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    @Column(name = "Genre")
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public ArrayList<DubActor> getDubActors() {
        return dubActors;
    }
    
    public String getDubActorsInString() {
        return dubActors.toString();
    }
    
    public void setDubActors(ArrayList<DubActor> dubActors) {
        this.dubActors = dubActors;
    }

    
    @Override
    public String toString() {
        return "Project{" + "projectID=" + projectID + ", name=" + name + ", description=" + description + ", publishDate=" + publishDate + ", genre=" + genre + '}';
    }
    
    
}
