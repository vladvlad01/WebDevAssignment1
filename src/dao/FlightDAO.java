package dao;

import entities.Flight;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FlightDAO {

    protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public void persistFlight(Flight flight){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(flight);
        System.out.println("Persisted");
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Flight getFlight(String flightNumber){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Flight flight = (Flight) entityManager.createNamedQuery("Flight.findByFlightNumber").setParameter("flightNumber", flightNumber).getSingleResult();
        if(!flight.getFlightNumber().equals(flightNumber)){
            return null;
        }
        return flight;
    }

    public void mergeFlight(Flight flightToUpdate){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(flightToUpdate);
        System.out.println(flightToUpdate.toString()+" updated with success!");
        System.out.println("#####################################################");

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeFlight(Flight flightToRemove){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.merge(flightToRemove));
        System.out.println(flightToRemove.toString()+" removed with success!");
        System.out.println();
        System.out.println("=======================================================");

        entityManager.getTransaction().commit();
        entityManager.close();
    }



}
