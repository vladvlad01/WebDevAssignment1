package dao;

import entities.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PassengerDAO {

    protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public void persistPassenger(Passenger passenger){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        System.out.println("");
        entityManager.persist(passenger);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Passenger> getAllPassengers(){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Passenger> passports = (List<Passenger>) entityManager.createNamedQuery("Passenger.findAll").getResultList();
        entityManager.close();
        return passports;
    }

    public void removePassenger(Passenger passenger){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        System.out.println();
        entityManager.remove(entityManager.merge(passenger));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

