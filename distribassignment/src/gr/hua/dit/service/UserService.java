package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.User;

public interface UserService {
	List<User> getUsers();

	void saveUser(User user);

	User getUser(String username);

	void deleteUser(String username);
	
	void updateUser(User user);
}
