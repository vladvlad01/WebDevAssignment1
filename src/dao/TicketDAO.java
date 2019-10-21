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
        System.out.println();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Ticket> getAllTickets(){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Ticket> tickets = (List<Ticket>) entityManager.createNamedQuery("Ticket.findAllOrderedByDestination").getResultList();
        entityManager.close();
        return tickets;
    }

    public void mergeTicket(Ticket ticketToUpdate){

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(ticketToUpdate);
        System.out.println("Updated to: "+ticketToUpdate.toString());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeTicket(Ticket ticketToRemove){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.merge(ticketToRemove));
        System.out.println(ticketToRemove.toString()+" was successfully removed");
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
