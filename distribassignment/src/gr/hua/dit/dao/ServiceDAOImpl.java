package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Authorities;
import gr.hua.dit.entity.Services;
import gr.hua.dit.entity.User;

@Repository
public class ServiceDAOImpl implements ServiceDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Services> getServices() {
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query
        Query<Services> query = currentSession.createQuery("from service", Services.class);
        
     // execute the query and get the results list
        List<Services> services = query.getResultList();
                        
        //return the results
        return services;
	}

	@Override
	public void saveService(Services service) {
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // save the user
        currentSession.save(service);
	}

	@Override
	public Services getService(int id) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// get and return User
				Services service = currentSession.get(Services.class, id);
				return service;
	}

	@Override
	public void deleteService(int id) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// find the User
				Services service = currentSession.get(Services.class, id);

				// delete User
				currentSession.delete(service);
	}

	@Override
	public void updateService(Services service) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// update service
				currentSession.update(service);
	}

}
