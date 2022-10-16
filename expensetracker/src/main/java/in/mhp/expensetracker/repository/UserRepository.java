package in.mhp.expensetracker.repository;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> 61f889b2224b04a03ad5d59af8655ba63be6d6d6
import org.springframework.data.jpa.repository.JpaRepository;

import in.mhp.expensetracker.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByMailId(String name);
<<<<<<< HEAD
	
=======
>>>>>>> 61f889b2224b04a03ad5d59af8655ba63be6d6d6

}
