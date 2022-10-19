package in.mhp.expensetracker.service;

import java.util.List;

import in.mhp.expensetracker.model.Expense;


public interface ExpenseService {
	
	List<Expense> findAll();
	
	Expense getExpById(Long id);
	
	void save(Expense expense);
	
	void delete(Long id);
	
	List<Expense> findByKeyword(String keyword, Long id);

}
