package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Authorities;
import gr.hua.dit.entity.Services;

public interface ServiceDAO {
	
	List<Services> getServices();

	void saveService(Services service);

	Services getService(int id);

	void deleteService(int id);
	
	void updateService(Services service);
}
