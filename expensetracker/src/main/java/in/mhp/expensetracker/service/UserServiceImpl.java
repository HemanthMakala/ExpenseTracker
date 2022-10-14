package in.mhp.expensetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mhp.expensetracker.model.User;
import in.mhp.expensetracker.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getUsers() {

		return userRepository.findAll();

	}

	@Override
	public Boolean verifyUser(User user) {
		if (userRepository.findByMailId(user.getMailId()) != null && user.getPassword().equals(user.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User getByMailId(String mailID) {
		// TODO Auto-generated method stub
		return userRepository.findByMailId(mailID);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
		
	}

}
