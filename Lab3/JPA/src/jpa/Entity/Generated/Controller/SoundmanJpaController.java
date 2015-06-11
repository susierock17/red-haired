/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.Entity.Generated.Controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.Entity.Generated.Project;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.Entity.Generated.Controller.exceptions.NonexistentEntityException;
import jpa.Entity.Generated.Soundman;

/**
 *
 * @author Kira
 */
public class SoundmanJpaController implements Serializable {

    public SoundmanJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Soundman soundman) {
        if (soundman.getProjectCollection() == null) {
            soundman.setProjectCollection(new ArrayList<Project>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Project> attachedProjectCollection = new ArrayList<Project>();
            for (Project projectCollectionProjectToAttach : soundman.getProjectCollection()) {
                projectCollectionProjectToAttach = em.getReference(projectCollectionProjectToAttach.getClass(), projectCollectionProjectToAttach.getIdProject());
                attachedProjectCollection.add(projectCollectionProjectToAttach);
            }
            soundman.setProjectCollection(attachedProjectCollection);
            em.persist(soundman);
            for (Project projectCollectionProject : soundman.getProjectCollection()) {
                Soundman oldSoundmanIdOfProjectCollectionProject = projectCollectionProject.getSoundmanId();
                projectCollectionProject.setSoundmanId(soundman);
                projectCollectionProject = em.merge(projectCollectionProject);
                if (oldSoundmanIdOfProjectCollectionProject != null) {
                    oldSoundmanIdOfProjectCollectionProject.getProjectCollection().remove(projectCollectionProject);
                    oldSoundmanIdOfProjectCollectionProject = em.merge(oldSoundmanIdOfProjectCollectionProject);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Soundman soundman) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Soundman persistentSoundman = em.find(Soundman.class, soundman.getIdSoundman());
            Collection<Project> projectCollectionOld = persistentSoundman.getProjectCollection();
            Collection<Project> projectCollectionNew = soundman.getProjectCollection();
            Collection<Project> attachedProjectCollectionNew = new ArrayList<Project>();
            for (Project projectCollectionNewProjectToAttach : projectCollectionNew) {
                projectCollectionNewProjectToAttach = em.getReference(projectCollectionNewProjectToAttach.getClass(), projectCollectionNewProjectToAttach.getIdProject());
                attachedProjectCollectionNew.add(projectCollectionNewProjectToAttach);
            }
            projectCollectionNew = attachedProjectCollectionNew;
            soundman.setProjectCollection(projectCollectionNew);
            soundman = em.merge(soundman);
            for (Project projectCollectionOldProject : projectCollectionOld) {
                if (!projectCollectionNew.contains(projectCollectionOldProject)) {
                    projectCollectionOldProject.setSoundmanId(null);
                    projectCollectionOldProject = em.merge(projectCollectionOldProject);
                }
            }
            for (Project projectCollectionNewProject : projectCollectionNew) {
                if (!projectCollectionOld.contains(projectCollectionNewProject)) {
                    Soundman oldSoundmanIdOfProjectCollectionNewProject = projectCollectionNewProject.getSoundmanId();
                    projectCollectionNewProject.setSoundmanId(soundman);
                    projectCollectionNewProject = em.merge(projectCollectionNewProject);
                    if (oldSoundmanIdOfProjectCollectionNewProject != null && !oldSoundmanIdOfProjectCollectionNewProject.equals(soundman)) {
                        oldSoundmanIdOfProjectCollectionNewProject.getProjectCollection().remove(projectCollectionNewProject);
                        oldSoundmanIdOfProjectCollectionNewProject = em.merge(oldSoundmanIdOfProjectCollectionNewProject);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = soundman.getIdSoundman();
                if (findSoundman(id) == null) {
                    throw new NonexistentEntityException("The soundman with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Soundman soundman;
            try {
                soundman = em.getReference(Soundman.class, id);
                soundman.getIdSoundman();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The soundman with id " + id + " no longer exists.", enfe);
            }
            Collection<Project> projectCollection = soundman.getProjectCollection();
            for (Project projectCollectionProject : projectCollection) {
                projectCollectionProject.setSoundmanId(null);
                projectCollectionProject = em.merge(projectCollectionProject);
            }
            em.remove(soundman);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Soundman> findSoundmanEntities() {
        return findSoundmanEntities(true, -1, -1);
    }

    public List<Soundman> findSoundmanEntities(int maxResults, int firstResult) {
        return findSoundmanEntities(false, maxResults, firstResult);
    }

    private List<Soundman> findSoundmanEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Soundman.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Soundman findSoundman(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Soundman.class, id);
        } finally {
            em.close();
        }
    }

    public int getSoundmanCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Soundman> rt = cq.from(Soundman.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
