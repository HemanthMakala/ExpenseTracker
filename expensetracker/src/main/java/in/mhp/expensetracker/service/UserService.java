package in.mhp.expensetracker.service;

import java.util.List;

import in.mhp.expensetracker.model.User;

public interface UserService {
	
	List<User> getUsers();
	
	Boolean verifyUser(User user);

}
