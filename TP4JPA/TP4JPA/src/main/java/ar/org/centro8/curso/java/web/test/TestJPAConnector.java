/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.org.centro8.curso.java.web.test;

import ar.org.centro8.curso.java.web.entities.Articulo;
import ar.org.centro8.curso.java.web.enums.EspecieRecomendada;
import ar.org.centro8.curso.java.web.enums.Tipo;
import java.time.LocalTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestJPAConnector {
    public static void main(String[] args) {
        tiempo();
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAPU");
        tiempo();
        EntityManager em=emf.createEntityManager();
        tiempo();
        
        Query query=em.createNamedQuery("Articulo.findById");
        query.setParameter("id", 1);
        Articulo art=(Articulo)query.getSingleResult();
        
        Articulo articulo = new Articulo("Pez", "Goma", Tipo.JUGUETE.toString(), EspecieRecomendada.FELINO.toString(), 300, 600, 8, 3, 20, "Pez de goma para gato", Boolean.TRUE);
        Articulo articulo2 = new Articulo("Hueso", "Dental", Tipo.SNACK.toString(), EspecieRecomendada.CANINO.toString(), 150, 300, 12, 5, 30, "Hueso dental canino", Boolean.TRUE);
    
        EntityTransaction tr=em.getTransaction();
        tr.begin();
        try{
            em.persist(articulo);
            em.persist(articulo2);
            tr.commit();
            System.out.println("Se guardo!");
        }catch(javax.persistence.PersistenceException e){
            System.out.println("Error "+e.getLocalizedMessage());
            System.out.println("Error "+e.getMessage());
            tr.rollback();
        }catch(Exception e){
            System.out.println(e);
            tr.rollback();
        }
    }
    
    private static void tiempo() {
        System.out.println("******************************************");
        System.out.println(LocalTime.now());
        System.out.println("******************************************");
    }
}
