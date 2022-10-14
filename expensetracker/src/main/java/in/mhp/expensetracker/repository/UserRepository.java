package in.mhp.expensetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mhp.expensetracker.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByMailId(String name);

}
