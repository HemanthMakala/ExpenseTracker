package in.mhp.expensetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mhp.expensetracker.model.User;
import in.mhp.expensetracker.repository.UserRepository;

@Service
<<<<<<< HEAD
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getUsers() {

		return userRepository.findAll();

=======
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getUsers() {
		
		return userRepository.findAll();
		
>>>>>>> 61f889b2224b04a03ad5d59af8655ba63be6d6d6
	}

	@Override
	public Boolean verifyUser(User user) {
<<<<<<< HEAD
		if (userRepository.findByMailId(user.getMailId()) != null && user.getPassword().equals(user.getPassword())) {
			return true;
		} else {
=======
		if(userRepository.findByMailId(user.getMailId()) != null && user.getPassword().equals(user.getPassword())) {
			return true;
		}else {
>>>>>>> 61f889b2224b04a03ad5d59af8655ba63be6d6d6
			return false;
		}
	}

<<<<<<< HEAD
	@Override
	public User getByMailId(String mailID) {
		// TODO Auto-generated method stub
		return userRepository.findByMailId(mailID);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
		
	}

=======
>>>>>>> 61f889b2224b04a03ad5d59af8655ba63be6d6d6
}
