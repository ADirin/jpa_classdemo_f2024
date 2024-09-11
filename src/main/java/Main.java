import com.example.jpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // Create an EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAExamplePU");

        // Create an EntityManager
        EntityManager em = emf.createEntityManager();

        // Begin transaction
        em.getTransaction().begin();

        // Create a new Student entity
        Student student = new Student("John Doe", "john.doe@example.com");

        // Persist the student entity
        em.persist(student);

        // Commit the transaction
        em.getTransaction().commit();

        // Retrieve and print all students from the database
        System.out.println("All students in the database:");
        em.createQuery("SELECT s FROM Student s", Student.class).getResultList().forEach(System.out::println);

        // Close the EntityManager and EntityManagerFactory
        em.close();
        emf.close();
    }
}