//package dao;
//
//import entities.Passport;
//import entities.Ticket;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import java.util.HashSet;
//import java.util.List;
//
//public class ServiceDAO {
//    protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
//    private EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//    public void save(Object object){
//
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(object);
//
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }
//
//    public List<Object> getAllObjects(String query){
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        List<Object> objects = (List<Object>) entityManager.createNamedQuery(query).getResultList();
//
//        entityManager.close();
//        return objects;
//    }
//
//
//    public void update(Object objectToUpdate){
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        entityManager.getTransaction().begin();
//        entityManager.merge(objectToUpdate);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//
//
//    }
//
//    public void delete(Object Object){
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//
//        entityManager.remove(entityManager.merge(Object));
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }
//
//    public void test(){
//        List<Passport> passports = (List) getAllObjects("test");
//        passports.forEach(p ->{
//            if(p.getPassportNumber().equalsIgnoreCase("p124")){
//                p.setFirstName("Edit");
//                update(p);
//            }
//        });
//    }
//}
