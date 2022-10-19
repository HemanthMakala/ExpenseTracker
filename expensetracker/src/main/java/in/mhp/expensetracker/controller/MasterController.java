package in.mhp.expensetracker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.mhp.expensetracker.model.Expense;
import in.mhp.expensetracker.model.User;
import in.mhp.expensetracker.service.ExpenseService;
import in.mhp.expensetracker.service.UserService;

@Controller
public class MasterController {

	public boolean value;

	@Autowired
	ExpenseService expenseService;

	@Autowired
	UserService userService;

	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute("user") User user) {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mavLogout = new ModelAndView("logout");
		session.invalidate();
		return mavLogout;
	}

	@RequestMapping(value = "/expenses")
	public ModelAndView home(@ModelAttribute("user") User user, HttpSession session, @Param("keyword") String keyword) {
		ModelAndView mav = new ModelAndView("home");
		if (user != null && user.getMailId() != null && userService.verifyUser(user)) {
			session.setAttribute("userMail", user.getMailId());

		}
		if (session.getAttribute("userMail") != null) {
			User userPrsnt = userService.getByMailId((String) session.getAttribute("userMail"));
			List<Expense> expenses;
			if(keyword != null) {
				expenses = expenseService.findByKeyword(keyword, userPrsnt.getId());
			}else {
				expenses = userPrsnt.getExpenses();
			}
			
			/* List<Expense> expenses = expenseService.findAll(); */
			mav.addObject("totalExpense", userService.getTotalExpense(userPrsnt));
			mav.addObject("expenses", expenses);
			mav.addObject("user", userPrsnt);
			return mav;
		} else {
			ModelAndView mavLin = new ModelAndView("login");
			return mavLin;
		}

	}

	@RequestMapping(value = "/expense", method = RequestMethod.GET)
	public ModelAndView addExpense(HttpSession session, @ModelAttribute("user") User user) {
		if (session.getAttribute("userMail") != null) {
			ModelAndView mavExp = new ModelAndView("expense");
			mavExp.addObject("expense", new Expense());
			return mavExp;
		} else {
			return login(user);
		}

	}

	@RequestMapping(value = "/expense", method = RequestMethod.POST)
	public String save(@ModelAttribute("expense") Expense expense, HttpSession session) {
		/* ModelAndView mavSave = new ModelAndView("save"); */
		User user = userService.getByMailId((String) session.getAttribute("userMail"));
		expense.setCreatedAt(System.currentTimeMillis());
		user.getExpenses().add(expense);
		userService.save(user);
		/* expenseService.save(expense); */
		return "redirect:/expenses";
	}

	@RequestMapping(value = "/expense/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		expenseService.delete(id);
		ModelAndView mavDelete = new ModelAndView("delete");
		mavDelete.addObject("id", id);
		return "redirect:/expenses";
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public ModelAndView registerUser(@ModelAttribute("user") User user, HttpSession session) {
		ModelAndView mavReg = new ModelAndView("register");
		return mavReg;
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user, HttpSession session) {
		userService.save(user); 
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
	public ModelAndView updateExpense(@PathVariable("id") Long id, HttpSession session) {
		ModelAndView mavExpUp = new ModelAndView("updateExp");
		Expense exp = expenseService.getExpById(id);
		System.out.println(exp);
		System.out.println(exp.getExpensename());
		mavExpUp.addObject("expenseUp", exp);
		return mavExpUp;
	}

	@RequestMapping(value = "/expenseUp/{id}", method = RequestMethod.POST)
	public String updateExp(@PathVariable("id") Long id,@ModelAttribute("expenseUp") Expense expenseUp, HttpSession session) {
		Expense expense = expenseService.getExpById(id);
		expense.setAmount(expenseUp.getAmount());
		expense.setExpensename(expenseUp.getExpensename());
		expense.setNote(expenseUp.getNote());
		expenseService.save(expense);
		return "redirect:/expenses";
	}
	
	@RequestMapping(value = "/searchKey",method = RequestMethod.GET)
	public void searchKey(Model model, @Param("keyword") String keyword, HttpSession session) {
	}
	
}