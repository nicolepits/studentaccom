package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Application;

public interface ApplicationService {
	
	public List<Application> getApplications();
	
	public void saveApp(Application app);

	public Application getApp(int id);
	
	void updateApp(Application app);
}
