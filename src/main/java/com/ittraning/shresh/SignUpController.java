package com.ittraning.shresh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ittraning.shresh.daos.UsersDao;
import com.ittraning.shresh.models.Users;

@Controller
public class SignUpController {
	
	@Autowired
	private UsersDao usersDao;
	
	@RequestMapping(value = "signUp", method = RequestMethod.GET)
	public String signUp(Model model){
		model.addAttribute("users", new Users());
		return "signUp";
	}
	
	@RequestMapping(value = "signUp", method = RequestMethod.POST)
	public String insert(@ModelAttribute Users users, Model model){
		try {
			usersDao.insert(users);
			model.addAttribute("successSignup", "Successfully registered user");
		} catch (Exception e) {
			model.addAttribute("failedSignup", "Failed to register user");
		}		
		model.addAttribute("users", new Users());
		return "signUp";
	}
}
