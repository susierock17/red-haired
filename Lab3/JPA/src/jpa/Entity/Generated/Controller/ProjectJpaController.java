/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.Entity.Generated.Controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.Entity.Generated.Genre;
import jpa.Entity.Generated.Soundman;
import jpa.Entity.Generated.Casting;
import jpa.Entity.Generated.Controller.exceptions.NonexistentEntityException;
import jpa.Entity.Generated.Project;

/**
 *
 * @author Kira
 */
public class ProjectJpaController implements Serializable {

    public ProjectJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Project project) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Genre genreId = project.getGenreId();
            if (genreId != null) {
                genreId = em.getReference(genreId.getClass(), genreId.getIdGenre());
                project.setGenreId(genreId);
            }
            Soundman soundmanId = project.getSoundmanId();
            if (soundmanId != null) {
                soundmanId = em.getReference(soundmanId.getClass(), soundmanId.getIdSoundman());
                project.setSoundmanId(soundmanId);
            }
            Casting castingId = project.getCastingId();
            if (castingId != null) {
                castingId = em.getReference(castingId.getClass(), castingId.getIdCasting());
                project.setCastingId(castingId);
            }
            em.persist(project);
            if (genreId != null) {
                genreId.getProjectCollection().add(project);
                genreId = em.merge(genreId);
            }
            if (soundmanId != null) {
                soundmanId.getProjectCollection().add(project);
                soundmanId = em.merge(soundmanId);
            }
            if (castingId != null) {
                castingId.getProjectCollection().add(project);
                castingId = em.merge(castingId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Project project) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Project persistentProject = em.find(Project.class, project.getIdProject());
            Genre genreIdOld = persistentProject.getGenreId();
            Genre genreIdNew = project.getGenreId();
            Soundman soundmanIdOld = persistentProject.getSoundmanId();
            Soundman soundmanIdNew = project.getSoundmanId();
            Casting castingIdOld = persistentProject.getCastingId();
            Casting castingIdNew = project.getCastingId();
            if (genreIdNew != null) {
                genreIdNew = em.getReference(genreIdNew.getClass(), genreIdNew.getIdGenre());
                project.setGenreId(genreIdNew);
            }
            if (soundmanIdNew != null) {
                soundmanIdNew = em.getReference(soundmanIdNew.getClass(), soundmanIdNew.getIdSoundman());
                project.setSoundmanId(soundmanIdNew);
            }
            if (castingIdNew != null) {
                castingIdNew = em.getReference(castingIdNew.getClass(), castingIdNew.getIdCasting());
                project.setCastingId(castingIdNew);
            }
            project = em.merge(project);
            if (genreIdOld != null && !genreIdOld.equals(genreIdNew)) {
                genreIdOld.getProjectCollection().remove(project);
                genreIdOld = em.merge(genreIdOld);
            }
            if (genreIdNew != null && !genreIdNew.equals(genreIdOld)) {
                genreIdNew.getProjectCollection().add(project);
                genreIdNew = em.merge(genreIdNew);
            }
            if (soundmanIdOld != null && !soundmanIdOld.equals(soundmanIdNew)) {
                soundmanIdOld.getProjectCollection().remove(project);
                soundmanIdOld = em.merge(soundmanIdOld);
            }
            if (soundmanIdNew != null && !soundmanIdNew.equals(soundmanIdOld)) {
                soundmanIdNew.getProjectCollection().add(project);
                soundmanIdNew = em.merge(soundmanIdNew);
            }
            if (castingIdOld != null && !castingIdOld.equals(castingIdNew)) {
                castingIdOld.getProjectCollection().remove(project);
                castingIdOld = em.merge(castingIdOld);
            }
            if (castingIdNew != null && !castingIdNew.equals(castingIdOld)) {
                castingIdNew.getProjectCollection().add(project);
                castingIdNew = em.merge(castingIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = project.getIdProject();
                if (findProject(id) == null) {
                    throw new NonexistentEntityException("The project with id " + id + " no longer exists.");
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
            Project project;
            try {
                project = em.getReference(Project.class, id);
                project.getIdProject();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The project with id " + id + " no longer exists.", enfe);
            }
            Genre genreId = project.getGenreId();
            if (genreId != null) {
                genreId.getProjectCollection().remove(project);
                genreId = em.merge(genreId);
            }
            Soundman soundmanId = project.getSoundmanId();
            if (soundmanId != null) {
                soundmanId.getProjectCollection().remove(project);
                soundmanId = em.merge(soundmanId);
            }
            Casting castingId = project.getCastingId();
            if (castingId != null) {
                castingId.getProjectCollection().remove(project);
                castingId = em.merge(castingId);
            }
            em.remove(project);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Project> findProjectEntities() {
        return findProjectEntities(true, -1, -1);
    }

    public List<Project> findProjectEntities(int maxResults, int firstResult) {
        return findProjectEntities(false, maxResults, firstResult);
    }

    private List<Project> findProjectEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Project.class));
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

    public Project findProject(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Project.class, id);
        } finally {
            em.close();
        }
    }

    public int getProjectCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Project> rt = cq.from(Project.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
