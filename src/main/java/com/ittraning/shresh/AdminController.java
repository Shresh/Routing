package com.ittraning.shresh;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ittraning.shresh.daos.UsersDao;
import com.ittraning.shresh.models.Users;

@Controller
public class AdminController {

	@Autowired
	private UsersDao userDao;

	@RequestMapping(value = "adminHome", method = RequestMethod.GET)
	public String adminHome(Model model, HttpSession session) {
		String loginUser = (String) session.getAttribute("activeUser");
		if (StringUtils.isEmpty(loginUser)) {
			return "redirect:login";
		} else {
			return "adminDashboard";
		}
	}

	@RequestMapping(value = "adminVProfile", method = RequestMethod.GET)
	public String adminProfile(Model model, @ModelAttribute Users user, HttpSession session) {
		String loginUser = (String) session.getAttribute("activeUser");
		if (StringUtils.isEmpty(loginUser)) {
			return "redirect:login";
		} else {
			user = (Users) session.getAttribute("user");
			model.addAttribute("user", user);
			return "adminVProfile";
		}
	}

	@RequestMapping(value = "adminProfile", method = RequestMethod.POST)
	private String adminProfile() {
		return "redirect:adminEProfile";
	}

	@RequestMapping(value = "adminEProfile", method = RequestMethod.GET)
	private String editadminProfile(Model model, @ModelAttribute Users user, HttpSession session) {
		String loginUser = (String) session.getAttribute("activeUser");
		if (StringUtils.isEmpty(loginUser)) {
			return "redirect:login";
		} else {
			user = (Users) session.getAttribute("user");
			model.addAttribute("user", user);
			return "adminEProfile";
		}
	}

	@RequestMapping(value = "/updateAdminProfile", method = RequestMethod.POST)
	public String updateadminProfile(Model model, @ModelAttribute Users user,HttpSession session) {
		String loginUser = (String) session.getAttribute("activeUser");
		if (StringUtils.isEmpty(loginUser)) {
			return "redirect:login";
		} else {
		userDao.insertUpdate(user);
		return "redirect:adminVProfile";
		}
	}
}
