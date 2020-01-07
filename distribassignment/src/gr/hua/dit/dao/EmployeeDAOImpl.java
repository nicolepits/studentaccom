package gr.hua.dit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Employee;
import gr.hua.dit.entity.Student;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query
        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
        
        
        // execute the query and get the results list
        List<Employee> employees = query.getResultList();
                        
        //return the results
        return employees;
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // save the employee
        currentSession.save(employee);
	}
	
	@Override
	@Transactional
	public Employee getEmployee(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Employee
		Employee employee = currentSession.get(Employee.class, id);
		return employee;
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the Employee
		Employee employee = currentSession.get(Employee.class, id);

		// delete Employee
		currentSession.delete(employee);

	}

}
