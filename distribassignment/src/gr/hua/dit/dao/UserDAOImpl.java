package gr.hua.dit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<User> getUsers() {
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query
        Query<User> query = currentSession.createQuery("from User", User.class);
        
        
        // execute the query and get the results list
        List<User> users = query.getResultList();
                        
        //return the results
        return users;
	}
	
	@Override
	public void saveUser(User user) {
		 // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        User user1 = new User();
		user1.setUsername(user.getUsername());
		user1.setEnabled(user.getEnabled());
		user1.setPassword(passwordEncoder.encode(user.getPassword()));
        // save the user
        currentSession.save(user1);
	}

	@Override
	public User getUser(String username) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return User
		User user = currentSession.get(User.class, username);
		return user;
	}

	@Override
	public void deleteUser(String username) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the User
		User user = currentSession.get(User.class, username);

		// delete User
		currentSession.delete(user);

	}
	
	@Override
	public void updateUser(User user) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		User user1 = new User();
		user1.setUsername(user.getUsername());
		user1.setEnabled(user.getEnabled());
		user1.setPassword(passwordEncoder.encode(user.getPassword()));
		// update User
		currentSession.update(user1);
	}	
}
