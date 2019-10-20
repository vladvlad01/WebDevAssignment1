package dao;

import entities.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.List;

public class TicketDAO {

    protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");


    public void persistTicket(Ticket ticket){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(ticket);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public HashSet<Ticket> getAllTickets(){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        HashSet<Ticket> tickets = (HashSet<Ticket>) entityManager.createNamedQuery("Ticket.findAllOrderedByDestination").getResultList();
        entityManager.close();
        return tickets;
    }

    public void mergeTicket(Ticket ticket){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ticket = (Ticket) entityManager.createNamedQuery("Ticket.findByDestination").setParameter("destination", "London").getSingleResult();

        entityManager.detach(ticket);
        ticket.setDestination("Dublin");
        entityManager.getTransaction().begin();
        entityManager.merge(ticket);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeTicket(Ticket ticket){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.merge(ticket));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
