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
import jpa.Entity.Generated.Casting;
import jpa.Entity.Generated.Controller.exceptions.NonexistentEntityException;

/**
 *
 * @author Kira
 */
public class CastingJpaController implements Serializable {

    public CastingJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Casting casting) {
        if (casting.getProjectCollection() == null) {
            casting.setProjectCollection(new ArrayList<Project>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Project> attachedProjectCollection = new ArrayList<Project>();
            for (Project projectCollectionProjectToAttach : casting.getProjectCollection()) {
                projectCollectionProjectToAttach = em.getReference(projectCollectionProjectToAttach.getClass(), projectCollectionProjectToAttach.getIdProject());
                attachedProjectCollection.add(projectCollectionProjectToAttach);
            }
            casting.setProjectCollection(attachedProjectCollection);
            em.persist(casting);
            for (Project projectCollectionProject : casting.getProjectCollection()) {
                Casting oldCastingIdOfProjectCollectionProject = projectCollectionProject.getCastingId();
                projectCollectionProject.setCastingId(casting);
                projectCollectionProject = em.merge(projectCollectionProject);
                if (oldCastingIdOfProjectCollectionProject != null) {
                    oldCastingIdOfProjectCollectionProject.getProjectCollection().remove(projectCollectionProject);
                    oldCastingIdOfProjectCollectionProject = em.merge(oldCastingIdOfProjectCollectionProject);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Casting casting) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Casting persistentCasting = em.find(Casting.class, casting.getIdCasting());
            Collection<Project> projectCollectionOld = persistentCasting.getProjectCollection();
            Collection<Project> projectCollectionNew = casting.getProjectCollection();
            Collection<Project> attachedProjectCollectionNew = new ArrayList<Project>();
            for (Project projectCollectionNewProjectToAttach : projectCollectionNew) {
                projectCollectionNewProjectToAttach = em.getReference(projectCollectionNewProjectToAttach.getClass(), projectCollectionNewProjectToAttach.getIdProject());
                attachedProjectCollectionNew.add(projectCollectionNewProjectToAttach);
            }
            projectCollectionNew = attachedProjectCollectionNew;
            casting.setProjectCollection(projectCollectionNew);
            casting = em.merge(casting);
            for (Project projectCollectionOldProject : projectCollectionOld) {
                if (!projectCollectionNew.contains(projectCollectionOldProject)) {
                    projectCollectionOldProject.setCastingId(null);
                    projectCollectionOldProject = em.merge(projectCollectionOldProject);
                }
            }
            for (Project projectCollectionNewProject : projectCollectionNew) {
                if (!projectCollectionOld.contains(projectCollectionNewProject)) {
                    Casting oldCastingIdOfProjectCollectionNewProject = projectCollectionNewProject.getCastingId();
                    projectCollectionNewProject.setCastingId(casting);
                    projectCollectionNewProject = em.merge(projectCollectionNewProject);
                    if (oldCastingIdOfProjectCollectionNewProject != null && !oldCastingIdOfProjectCollectionNewProject.equals(casting)) {
                        oldCastingIdOfProjectCollectionNewProject.getProjectCollection().remove(projectCollectionNewProject);
                        oldCastingIdOfProjectCollectionNewProject = em.merge(oldCastingIdOfProjectCollectionNewProject);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = casting.getIdCasting();
                if (findCasting(id) == null) {
                    throw new NonexistentEntityException("The casting with id " + id + " no longer exists.");
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
            Casting casting;
            try {
                casting = em.getReference(Casting.class, id);
                casting.getIdCasting();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The casting with id " + id + " no longer exists.", enfe);
            }
            Collection<Project> projectCollection = casting.getProjectCollection();
            for (Project projectCollectionProject : projectCollection) {
                projectCollectionProject.setCastingId(null);
                projectCollectionProject = em.merge(projectCollectionProject);
            }
            em.remove(casting);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Casting> findCastingEntities() {
        return findCastingEntities(true, -1, -1);
    }

    public List<Casting> findCastingEntities(int maxResults, int firstResult) {
        return findCastingEntities(false, maxResults, firstResult);
    }

    private List<Casting> findCastingEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Casting.class));
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

    public Casting findCasting(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Casting.class, id);
        } finally {
            em.close();
        }
    }

    public int getCastingCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Casting> rt = cq.from(Casting.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
