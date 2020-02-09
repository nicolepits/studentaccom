package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Services;

public interface ServiceService {
	List<Services> getServices();

	void saveService(Services service);

	Services getService(int id);

	void deleteService(int id);
	
	void updateService(Services service);
}
