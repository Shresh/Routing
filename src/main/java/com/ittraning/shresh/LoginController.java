package com.ittraning.shresh;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ittraning.shresh.daos.UsersDao;
import com.ittraning.shresh.models.Users;
import com.ittraning.shresh.models.Users.Role;


@Controller
public class LoginController {
	
	@Autowired
	private UsersDao userDao;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginPage(Model model, HttpServletRequest request){
		return "login";
	}
	
	@RequestMapping(value = "profile", method = RequestMethod.POST)
	public String profile(@ModelAttribute Users users, Model model, HttpSession session){
		if (userDao.validateuser(users)) {

			session.setAttribute("activeUser", users.getUsername());
			session.setMaxInactiveInterval(30 * 60);
			Users user = userDao.get(users);
			session.setAttribute("user", user);
			model.addAttribute("user", user);
			if (user.getRole()==Role.Admin) {
				return "adminDashboard";
			}else{
				return "userDashboard";
			}
		} else {
			model.addAttribute("loginError", "Sorry Username/Password invalid!!Please try again.");
			return "login";
		}

	}
}
