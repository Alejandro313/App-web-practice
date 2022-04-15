package ar.org.centro8.curso.java.web.repositories.jpa;

import ar.org.centro8.curso.java.web.entities.Articulo;
import ar.org.centro8.curso.java.web.repositories.interfaces.I_ArticuloRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class ArticuloRepository implements I_ArticuloRepository{

    private EntityManagerFactory emf;

    public ArticuloRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public void save(Articulo articulo) {
       if(articulo==null) return;
       EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(articulo);
            et.commit();
        } catch (Exception e) {
            System.out.println(e);
            et.rollback();
        }
        em.close();
    }

    @Override
    public void remove(Articulo articulo) {
        if(articulo==null) return;
       EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(articulo));
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
        }
        em.close();
    }

    @Override
    public void update(Articulo articulo) {
        if(articulo==null) return;
       EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(articulo);
            et.commit();
        } catch (Exception e) {
            System.out.println(e);
            et.rollback();
        }
        em.close();
    }

    @Override
    public List<Articulo> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Articulo>list=(List<Articulo>)em.createNamedQuery("Articulo.findAll").getResultList();
        em.close();
        return list;
    }
}
