package in.mhp.expensetracker.service;

import java.util.List;

import in.mhp.expensetracker.model.Expense;
<<<<<<< HEAD
import in.mhp.expensetracker.model.User;
=======
>>>>>>> 61f889b2224b04a03ad5d59af8655ba63be6d6d6

public interface ExpenseService {
	
	List<Expense> findAll();
	
	void save(Expense expense);
	
	void delete(Long id);

}
