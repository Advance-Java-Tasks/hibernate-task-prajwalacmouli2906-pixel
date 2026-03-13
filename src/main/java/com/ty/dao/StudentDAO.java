package com.ty.dao;


import java.util.List;

import com.ty.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class StudentDAO {

    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("student-unit");

    public void saveStudent(Student student) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(student);
        tx.commit();

        em.close();
    }

    public Student getStudentById(int id) {

        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, id);

        em.close();

        return student;
    }

    public List<Student> getAllStudents() {

        EntityManager em = emf.createEntityManager();

        List<Student> list =
                em.createQuery("SELECT s FROM Student s", Student.class)
                        .getResultList();

        em.close();

        return list;
    }
}