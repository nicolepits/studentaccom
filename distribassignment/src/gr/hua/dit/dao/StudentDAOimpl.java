package gr.hua.dit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import gr.hua.dit.entity.Student;

@Repository
public class StudentDAOimpl implements StudentDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query
        Query<Student> query = currentSession.createQuery("from Student", Student.class);
        
        
        // execute the query and get the results list
        List<Student> students = query.getResultList();
                        
        //return the results
        return students;
	}
	
	@Override
	@Transactional
	public void saveStudent(Student student) {
		 // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // save the employee
        currentSession.save(student);
	}

	@Override
	@Transactional
	public Student getStudent(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Student
		Student student = currentSession.get(Student.class, id);
		return student;
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the Student
		Student student = currentSession.get(Student.class, id);

		// delete Student
		currentSession.delete(student);

	}
}
