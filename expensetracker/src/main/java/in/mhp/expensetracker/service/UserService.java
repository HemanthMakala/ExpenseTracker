package in.mhp.expensetracker.service;

import java.util.List;

import in.mhp.expensetracker.model.User;

public interface UserService {
	
	List<User> getUsers();
	
	Boolean verifyUser(User user);
<<<<<<< HEAD
	
	User getByMailId(String mailId);
	
	void save(User user);
=======
>>>>>>> 61f889b2224b04a03ad5d59af8655ba63be6d6d6

}
