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
import jpa.Entity.Generated.Genre;

/**
 *
 * @author Kira
 */
public class GenreJpaController implements Serializable {

    public GenreJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Genre genre) {
        if (genre.getProjectCollection() == null) {
            genre.setProjectCollection(new ArrayList<Project>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Project> attachedProjectCollection = new ArrayList<Project>();
            for (Project projectCollectionProjectToAttach : genre.getProjectCollection()) {
                projectCollectionProjectToAttach = em.getReference(projectCollectionProjectToAttach.getClass(), projectCollectionProjectToAttach.getIdProject());
                attachedProjectCollection.add(projectCollectionProjectToAttach);
            }
            genre.setProjectCollection(attachedProjectCollection);
            em.persist(genre);
            for (Project projectCollectionProject : genre.getProjectCollection()) {
                Genre oldGenreIdOfProjectCollectionProject = projectCollectionProject.getGenreId();
                projectCollectionProject.setGenreId(genre);
                projectCollectionProject = em.merge(projectCollectionProject);
                if (oldGenreIdOfProjectCollectionProject != null) {
                    oldGenreIdOfProjectCollectionProject.getProjectCollection().remove(projectCollectionProject);
                    oldGenreIdOfProjectCollectionProject = em.merge(oldGenreIdOfProjectCollectionProject);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Genre genre) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Genre persistentGenre = em.find(Genre.class, genre.getIdGenre());
            Collection<Project> projectCollectionOld = persistentGenre.getProjectCollection();
            Collection<Project> projectCollectionNew = genre.getProjectCollection();
            Collection<Project> attachedProjectCollectionNew = new ArrayList<Project>();
            for (Project projectCollectionNewProjectToAttach : projectCollectionNew) {
                projectCollectionNewProjectToAttach = em.getReference(projectCollectionNewProjectToAttach.getClass(), projectCollectionNewProjectToAttach.getIdProject());
                attachedProjectCollectionNew.add(projectCollectionNewProjectToAttach);
            }
            projectCollectionNew = attachedProjectCollectionNew;
            genre.setProjectCollection(projectCollectionNew);
            genre = em.merge(genre);
            for (Project projectCollectionOldProject : projectCollectionOld) {
                if (!projectCollectionNew.contains(projectCollectionOldProject)) {
                    projectCollectionOldProject.setGenreId(null);
                    projectCollectionOldProject = em.merge(projectCollectionOldProject);
                }
            }
            for (Project projectCollectionNewProject : projectCollectionNew) {
                if (!projectCollectionOld.contains(projectCollectionNewProject)) {
                    Genre oldGenreIdOfProjectCollectionNewProject = projectCollectionNewProject.getGenreId();
                    projectCollectionNewProject.setGenreId(genre);
                    projectCollectionNewProject = em.merge(projectCollectionNewProject);
                    if (oldGenreIdOfProjectCollectionNewProject != null && !oldGenreIdOfProjectCollectionNewProject.equals(genre)) {
                        oldGenreIdOfProjectCollectionNewProject.getProjectCollection().remove(projectCollectionNewProject);
                        oldGenreIdOfProjectCollectionNewProject = em.merge(oldGenreIdOfProjectCollectionNewProject);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = genre.getIdGenre();
                if (findGenre(id) == null) {
                    throw new NonexistentEntityException("The genre with id " + id + " no longer exists.");
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
            Genre genre;
            try {
                genre = em.getReference(Genre.class, id);
                genre.getIdGenre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The genre with id " + id + " no longer exists.", enfe);
            }
            Collection<Project> projectCollection = genre.getProjectCollection();
            for (Project projectCollectionProject : projectCollection) {
                projectCollectionProject.setGenreId(null);
                projectCollectionProject = em.merge(projectCollectionProject);
            }
            em.remove(genre);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Genre> findGenreEntities() {
        return findGenreEntities(true, -1, -1);
    }

    public List<Genre> findGenreEntities(int maxResults, int firstResult) {
        return findGenreEntities(false, maxResults, firstResult);
    }

    private List<Genre> findGenreEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Genre.class));
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

    public Genre findGenre(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Genre.class, id);
        } finally {
            em.close();
        }
    }

    public int getGenreCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Genre> rt = cq.from(Genre.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
