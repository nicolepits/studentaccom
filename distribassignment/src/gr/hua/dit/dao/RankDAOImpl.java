package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Application;
import gr.hua.dit.entity.Rank;

@Repository
public class RankDAOImpl implements RankDAO {

	
	@Autowired
    private SessionFactory sessionFactory;
	
	
	@Override
	public List<Rank> getRanks() {
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query
        Query<Rank> query = currentSession.createQuery("from Rank", Rank.class);
        
        
        // execute the query and get the results list
        List<Rank> ranks = query.getResultList();
                        
        //return the results
        return ranks;
	}


	@Override
	public void saveRank(Rank rank) {
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // save the application
        currentSession.save(rank);
	}

}
