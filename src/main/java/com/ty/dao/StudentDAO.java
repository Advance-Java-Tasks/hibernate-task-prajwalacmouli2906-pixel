import java.util.List;

import com.ty.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class StudentDAO {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("student-unit");

	public void saveStudent(Student student) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(student);
		et.commit();

	}

	public Student getStudentById(int id) {

		EntityManager em = emf.createEntityManager();

		Student student = em.find(Student.class, id);

		return student;
	}

	public List<Student> getAllStudents() {

		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT s FROM Student s");

		List<Student> students = query.getResultList();

		return students;
	}
}