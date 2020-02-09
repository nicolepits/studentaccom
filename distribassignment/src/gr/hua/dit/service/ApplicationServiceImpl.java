package gr.hua.dit.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.hua.dit.dao.ApplicationDAO;
import gr.hua.dit.entity.Application;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationDAO applicationDAO;
	
	@Override
	@Transactional
	public void saveApp(Application app) {
		applicationDAO.saveApp(app);
	}

	@Override
	@Transactional
	public Application getApp(int id) {
		return applicationDAO.getApp(id);
	}

	@Override
	@Transactional
	public void updateApp(Application app) {
		applicationDAO.updateApp(app);
		
	}

	@Override
	@Transactional
	public List<Application> getApplications() {
		return applicationDAO.getApplications();
	}

}
