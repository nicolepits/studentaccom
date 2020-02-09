package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Authorities;
import gr.hua.dit.entity.Student;


public interface AuthoritiesDAO {

	
	List<Authorities> getAuthorities();

	void saveAuthority(Authorities authorities);

	Authorities getAuthority(String username);

	void deleteAuthority(String username);
	
	void updateAuthority(Authorities authorities);
}
