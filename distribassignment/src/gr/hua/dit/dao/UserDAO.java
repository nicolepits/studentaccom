package gr.hua.dit.dao;

import java.util.List;


import gr.hua.dit.entity.User;

public interface UserDAO {

	List<User> getUsers();

	void saveUser(User user);

	User getUser(String username);

	void deleteUser(String username);

	void updateUser(User user);
}
