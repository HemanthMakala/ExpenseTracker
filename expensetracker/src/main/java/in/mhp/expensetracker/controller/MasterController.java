package in.mhp.expensetracker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public ModelAndView login(@ModelAttribute("user") User user, HttpSession session) {
		ModelAndView mav = new ModelAndView("login");
		System.out.println(userService.getUsers());
		session.setAttribute("isLogin", false);
		return mav;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mavLogout = new ModelAndView("logout");
		System.out.println("Session Details --------------------------------->");
		System.out.println(session.getMaxInactiveInterval());
		System.out.println(session.getValueNames().toString());
		System.out.println(session.getId());
		
		session.invalidate();
		return mavLogout;
	}
	
	
	@RequestMapping(value="/expenses")
	public ModelAndView home(@ModelAttribute("user") User user,HttpSession session) {
		ModelAndView mav = new ModelAndView("home");
		List<Expense> expenses = expenseService.findAll();
		mav.addObject("message","List of expenses");
		mav.addObject("expenses",expenses);
		mav.addObject("user",user);
		if(session.getAttribute("isLogin") != null){
		    value = (Boolean) session.getAttribute("isLogin");
		}else {
			value = false;
		}
		if(userService.verifyUser(user) == true || value) {
			session.setAttribute("isLogin", true);
			return mav;
		}else {
			ModelAndView mavLin = new ModelAndView("login");
			return mavLin;
		}
		
	}
	
	
	 @RequestMapping(value="/expense", method=RequestMethod.GET) public
	 ModelAndView addExpense() { ModelAndView mavExp = new
	 ModelAndView("expense"); mavExp.addObject("expense",new Expense()); return
	 mavExp; }
	 
	
	@RequestMapping(value="/expense", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("expense") Expense expense) {
		ModelAndView mavSave = new ModelAndView("save");
		expenseService.save(expense);	
		return mavSave;
	}
	
	
	@RequestMapping(value="/expense/{id}/delete")
	public ModelAndView delete(@PathVariable("id") Long id) {
		expenseService.delete(id);
		ModelAndView mavDelete = new ModelAndView("delete");
		mavDelete.addObject("id",id);
		return mavDelete;
	}
	
}
