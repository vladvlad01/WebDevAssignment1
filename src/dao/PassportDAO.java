package dao;
import entities.Passport;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PassportDAO {

    protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public void persistPassport(Passport passport){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(passport);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Passport> getAllPassports(){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Passport> passports = (List<Passport>) entityManager.createNamedQuery("Passport.findAllOrderedByLastName").getResultList();
        entityManager.close();
        return passports;
    }

    public void mergePassport(Passport passport){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        passport = (Passport) entityManager.createNamedQuery("Passport.findByPassportNumber").setParameter("passportNumber", "PS321").getSingleResult();

        entityManager.detach(passport);
        passport.setPassportNumber("PS000");
        entityManager.getTransaction().begin();
        entityManager.merge(passport);
        System.out.println("Your passport number was successfuly updated to: "+passport.getPassportNumber());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removePassport(Passport passport){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.merge(passport));
        System.out.println(passport.toString() + " was removed!");
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
