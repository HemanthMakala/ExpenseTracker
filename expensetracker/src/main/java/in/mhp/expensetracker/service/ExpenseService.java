package in.mhp.expensetracker.service;

import java.util.List;

import in.mhp.expensetracker.model.Expense;
import in.mhp.expensetracker.model.User;

public interface ExpenseService {
	
	List<Expense> findAll();
	
	void save(Expense expense);
	
	void delete(Long id);

}
