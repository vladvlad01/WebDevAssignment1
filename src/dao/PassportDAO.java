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
        System.out.println();
        entityManager.close();
    }

    public List<Passport> getAllPassports(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Passport> passports = (List<Passport>) entityManager.createNamedQuery("Passport.findAllOrderedByLastName").getResultList();
        entityManager.close();
        return passports;
    }

    public void mergePassport(Passport passportToEdit){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(passportToEdit);
        System.out.println("Updated to: "+passportToEdit.toString());
        System.out.println("=============================================================================");
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removePassport(Passport passportToRemove){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(passportToRemove));
        System.out.println(passportToRemove.toString() + " was removed!");
        System.out.println("=============================================================================");
        entityManager.getTransaction().commit();
        entityManager.close();
    }

//    public List<Object> getAll(String query){
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        List<Object> objects = (List<Object>) entityManager.createNamedQuery(query).getResultList();
//        entityManager.close();
//        return objects;
//    }

    //    public void mergePassport(String passportNo,String newNumberPassport){
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//       Passport passport = (Passport) entityManager.createNamedQuery("Passport.findByPassportNumber").setParameter("passportNumber", passportNo).getSingleResult();
//
//        entityManager.detach(passport);
//
//        passport.setPassportNumber(newNumberPassport);
//
//        entityManager.getTransaction().begin();
//        entityManager.merge(passport);
//        System.out.println("Your passport number was successfuly updated to: "+passport.getPassportNumber());
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }
}
