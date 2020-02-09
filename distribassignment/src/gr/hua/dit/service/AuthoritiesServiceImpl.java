package gr.hua.dit.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.hua.dit.dao.AuthoritiesDAO;
import gr.hua.dit.entity.Authorities;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {
	
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	
	@Override
	@Transactional
	public List<Authorities> getAuthorities() {
		return authoritiesDAO.getAuthorities();
	}

	@Override
	@Transactional
	public void saveAuthority(Authorities authorities) {
		authoritiesDAO.saveAuthority(authorities);
	}

	@Override
	@Transactional
	public Authorities getAuthority(String username) {
		return authoritiesDAO.getAuthority(username);
	}

	@Override
	@Transactional
	public void deleteAuthority(String username) {
		authoritiesDAO.deleteAuthority(username);
	}

	@Override
	@Transactional
	public void updateAuthority(Authorities authorities) {
		authoritiesDAO.updateAuthority(authorities);
	}

}
