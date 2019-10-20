package dao;

import entities.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;

public class ServiceDAO {
    protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public void persistObject(Object object){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(object);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public HashSet<Object> getAllObjects(){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        HashSet<Object> objects = (HashSet<Object>) entityManager.createNamedQuery("Ticket.findAllOrderedByDestination").getResultList();
        entityManager.close();
        return objects;
    }

    public Object mergeObject(Object object){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        object = (Object) entityManager.createNamedQuery("Ticket.findByDestination").setParameter("destination", "London").getSingleResult();

        entityManager.detach(object);

        entityManager.getTransaction().begin();
        entityManager.merge(object);
        entityManager.getTransaction().commit();
        entityManager.close();
        return object;
    }

    public void removeObject(Object Object){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.merge(Object));
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
