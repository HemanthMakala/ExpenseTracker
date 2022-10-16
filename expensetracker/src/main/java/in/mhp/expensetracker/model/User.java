package in.mhp.expensetracker.model;

<<<<<<< HEAD
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
=======
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
>>>>>>> 61f889b2224b04a03ad5d59af8655ba63be6d6d6
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_users")
@Setter
@Getter
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fullName;
	
	private String mailId;
	
	private String password;
	
	private Long mobileNumber;
	
<<<<<<< HEAD
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
	private List<Expense> expenses;
	
=======
>>>>>>> 61f889b2224b04a03ad5d59af8655ba63be6d6d6
}
