package in.mhp.expensetracker.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_expenses")
@Setter
@Getter
@ToString
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="description")
	private String expensename;
	
	private BigDecimal amount;
	
	private String note;
	
	private Long createdAt;
	
<<<<<<< HEAD
=======
	
>>>>>>> 61f889b2224b04a03ad5d59af8655ba63be6d6d6
}
