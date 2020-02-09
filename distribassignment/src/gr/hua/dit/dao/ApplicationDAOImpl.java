package gr.hua.dit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Application;
import gr.hua.dit.entity.Student;

@Repository
public class ApplicationDAOImpl implements ApplicationDAO {

	@Autowired
    private SessionFactory sessionFactory;
	

	@Override
	public void saveApp(Application app) {
		 // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // save the application
        currentSession.save(app);
	}

	@Override
	public Application getApp(int id) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// get and return Application
				Application app= currentSession.get(Application.class, id);
				return app;
	}

	@Override
	public void updateApp(Application app) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// update User
				currentSession.update(app);
	}

	@Override
	public List<Application> getApplications() {
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query
        Query<Application> query = currentSession.createQuery("from Application", Application.class);
        
        
        // execute the query and get the results list
        List<Application> applications = query.getResultList();
                        
        //return the results
        return applications;
	}

}
