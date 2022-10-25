package in.mhp.expensetracker.service;

import java.io.Writer;
import java.util.List;

import in.mhp.expensetracker.model.Expense;

public interface ExpenseCsvExport {
	
	void writeExpenseToCsv(Writer writer,List<Expense> expenses);
	
}
