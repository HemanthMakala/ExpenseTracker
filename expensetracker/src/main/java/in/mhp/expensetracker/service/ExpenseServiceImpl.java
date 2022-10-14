package in.mhp.expensetracker.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mhp.expensetracker.model.Expense;
import in.mhp.expensetracker.model.User;
import in.mhp.expensetracker.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;

	@Override
	public List<Expense> findAll() {
		List<Expense> srtList = expenseRepository.findAll();
		Collections.sort(srtList, Comparator.comparing(s -> s.getAmount()));
		Collections.reverse(srtList);
		return srtList;

	}

	@Override
	public void save(Expense expense) {
		expense.setCreatedAt(System.currentTimeMillis());
		System.out.println("Inside Expense Repository");
		System.out.println(expense.getExpensename());
		System.out.println(expense.getAmount());
		System.out.println(expense.getNote());
		System.out.println(expense.getCreatedAt());
		expenseRepository.save(expense);

	}

	@Override
	public void delete(Long id) {
		expenseRepository.deleteById(id);
	}


}
