package gr.hua.dit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Authorities;
import gr.hua.dit.entity.User;

@Repository
public class AuthoritiesDAOImpl implements AuthoritiesDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public List<Authorities> getAuthorities() {
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query
        Query<Authorities> query = currentSession.createQuery("from authorities", Authorities.class);
        
        
        // execute the query and get the results list
        List<Authorities> authorities= query.getResultList();
                        
        //return the results
        return authorities;
	}

	@Override
	public void saveAuthority(Authorities authorities) {
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // save the user
        currentSession.save(authorities);

	}

	@Override
	public Authorities getAuthority(String username) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// get and return User
				Authorities authorities= currentSession.get(Authorities.class, username);
				return authorities;
	}

	@Override
	public void deleteAuthority(String username) {
		Session currentSession = sessionFactory.getCurrentSession();

		// find the User
		Authorities auth = currentSession.get(Authorities.class, username);

		// delete User
		currentSession.delete(auth);
	}

	@Override
	public void updateAuthority(Authorities authorities) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// update Role
				currentSession.update(authorities);
	}

}
