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
        entityManager.persist(passenger);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public List<Passenger> getAllPassengers(){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Passenger> passengers = (List<Passenger>) entityManager.createNamedQuery("Passenger.findAll").getResultList();
        entityManager.close();
        return passengers;
    }

    public void mergePassenger(Passenger passengerToEdit){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(passengerToEdit);
        System.out.println("Your passport number was successfuly updated to: "+passengerToEdit.toString());
        System.out.println("====================================================================");

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removePassenger(Passenger passengerToRemove){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.merge(passengerToRemove));
        System.out.println(passengerToRemove.toString() + " was removed!");
        System.out.println();
        System.out.println("==========================================================================");

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

