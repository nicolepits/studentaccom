package gr.hua.dit.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import gr.hua.dit.dao.ServiceDAO;
import gr.hua.dit.entity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	private ServiceDAO serviceDAO;
	
	@Override
	@Transactional
	public List<Services> getServices() {
		
		return serviceDAO.getServices();
	}

	@Override
	@Transactional
	public void saveService(Services service) {
		serviceDAO.saveService(service);
	}

	@Override
	@Transactional
	public Services getService(int id) {
		return serviceDAO.getService(id);
	}

	@Override
	@Transactional
	public void deleteService(int id) {
		serviceDAO.deleteService(id);

	}

	@Override
	@Transactional
	public void updateService(Services service) {
		serviceDAO.updateService(service);

	}

}
