/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 *
 * @author Kira
 */
@Entity
@Table(name="DubActors")
public class DubActor extends DubbingObject implements Serializable  {
    private Long actorID;
    private String fullName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getActorID() {
        return actorID;
    }

    public void setActorID(Long ActorID) {
        this.actorID = ActorID;
    }
    
    @Column(name = "FullName")
    //@Size(max = 15)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String FullName) {
        this.fullName = FullName;
    }

    @Override
    public String toString() {
        return "DubActor{" + "ActorID=" + actorID + ", FullName=" + fullName + '}';
    }
    
    
    
}
