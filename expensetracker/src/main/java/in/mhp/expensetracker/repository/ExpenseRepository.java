package in.mhp.expensetracker.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.mhp.expensetracker.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{
	
	@Query(value = "select * from tbl_expenses where description like %:keyword% and user = :id" , nativeQuery = true)
	 List<Expense> findByKeyword(@Param("keyword") String keyword, @Param("id") Long id);

}
