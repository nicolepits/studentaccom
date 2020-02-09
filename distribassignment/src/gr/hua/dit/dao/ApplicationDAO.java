package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Application;
import gr.hua.dit.entity.Student;


public interface ApplicationDAO {
	
	public List<Application> getApplications();
	
	public void saveApp(Application app);

	public Application getApp(int id);
	
	void updateApp(Application app);
}
