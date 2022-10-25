package in.mhp.expensetracker.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class ExpenseList {
	
	private List<Expense> expenseListObj;

}
