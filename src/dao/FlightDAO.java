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

    public void mergeFlight(Flight flight, String flightNumber){
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        flight = (Flight) entityManager.createNamedQuery("Flight.findByFlightNumber").setParameter("flightNumber", flightNumber).getSingleResult();

        entityManager.detach(flight);
        entityManager.getTransaction().begin();
        entityManager.merge(flight);
        entityManager.getTransaction().commit();
        entityManager.close();
    }



}
