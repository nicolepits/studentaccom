package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Authorities;

public interface AuthoritiesService 
{
	List<Authorities> getAuthorities();

	void saveAuthority(Authorities authorities);

	Authorities getAuthority(String username);

	void deleteAuthority(String username);
	
	void updateAuthority(Authorities authorities);
}
