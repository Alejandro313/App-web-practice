package ar.org.centro8.curso.java.web.test;

import ar.org.centro8.curso.java.web.entities.Articulo;
import ar.org.centro8.curso.java.web.enums.EspecieRecomendada;
import ar.org.centro8.curso.java.web.enums.Tipo;
import ar.org.centro8.curso.java.web.repositories.interfaces.I_ArticuloRepository;
import ar.org.centro8.curso.java.web.repositories.jpa.ArticuloRepository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestoRepositoryJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAPU");
        I_ArticuloRepository ar=new ArticuloRepository(emf);
        EntityManager em=emf.createEntityManager();
        
        Articulo articulo=new Articulo("Cat chow", "Pescado", Tipo.ALIMENTO.toString(), EspecieRecomendada.FELINO.toString(), 400, 600, 10, 3, 20, "sin", Boolean.TRUE);
        Articulo articulo2=new Articulo("Collar pet", "Rojo", Tipo.ACCESORIO.toString(), EspecieRecomendada.CANINO.toString(), 300,500, 20, 5, 30, "sin", Boolean.TRUE);
        Articulo articulo3=new Articulo("almohada", "Amarilla", Tipo.PRENDA.toString(), EspecieRecomendada.CANINO.toString(), 600,800, 5, 3, 20, "sin", Boolean.TRUE);
        
        ar.save(articulo);
        ar.save(articulo2);
        ar.save(articulo3);
        
        System.out.println("****************************************");
        System.out.println("Mostrar todo");
        ar.getAll().forEach(System.out::println);
        System.out.println("****************************************");
        System.out.println("Consulta por nombre");
        ar.getLikeNombre("Ca").forEach(System.out::println);
        System.out.println("****************************************");
        System.out.println("Consulta por alimento");
        ar.getLikeTipo(Tipo.ALIMENTO).forEach(System.out::println);
        System.out.println("****************************************");
        System.out.println("Consulta por activo");
        ar.getLikeActivo(true).forEach(System.out::println);
        
        //ar.remove(ar.getById(3));
        
        System.out.println("*******************");
        System.out.println("UPDATE");
        //Articulo a=ar.getById(2);
        //a.setActivo(Boolean.FALSE);
        //ar.update(a);
        
        System.out.println("****************************************");
        System.out.println("Consulta por nombre");
        ar.getLikeNombre("almohada").forEach(System.out::println);
    }
}
