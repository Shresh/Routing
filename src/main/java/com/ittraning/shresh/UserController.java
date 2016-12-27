package com.ittraning.shresh;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ittraning.shresh.daos.SetRouteDao;
import com.ittraning.shresh.daos.UsersDao;
import com.ittraning.shresh.models.SetRoute;
import com.ittraning.shresh.models.Users;

@Controller
public class UserController {
	
	@Autowired
	private SetRouteDao setRouteDao;
	
	@Autowired
	private UsersDao userDao;
	
	@RequestMapping(value = "userhome", method = RequestMethod.GET)
	private String userHome(Model model,HttpSession session){
		String loginUser = (String) session.getAttribute("activeUser");
		if(StringUtils.isEmpty(loginUser)){
			return "redirect:login";
		} else{
			List<SetRoute> setRoute = setRouteDao.getAll();
			model.addAttribute("routeList", setRoute);
			return "userDashboard";
		}
	}
	
	@RequestMapping(value = "userViewRoute", method = RequestMethod.GET)
	private String userViewRoute(Model model, @ModelAttribute Users user, HttpSession session){
		String loginUser = (String) session.getAttribute("activeUser");
		if(StringUtils.isEmpty(loginUser)){
			return "redirect:login";
		} else{
			List<SetRoute> setRoute = setRouteDao.getAll();
			model.addAttribute("routeList", setRoute);
			return "userViewRoute";
		}
	}
	
	@RequestMapping(value = "userVProfile", method = RequestMethod.GET)
	private String userViewProfile(Model model, @ModelAttribute Users user, HttpSession session){
		String loginUser = (String) session.getAttribute("activeUser");
		if(StringUtils.isEmpty(loginUser)){
			return "redirect:login";
		} else{
			user = (Users) session.getAttribute("user");
			model.addAttribute("user", user);
			return "userVProfile";
		}
	}
	
	@RequestMapping (value = "userEProfile", method = RequestMethod.GET)
	private String userEditProfile(Model model, @ModelAttribute Users user,HttpSession session){
		String loginUser = (String) session.getAttribute("activeUser");
		if(StringUtils.isEmpty(loginUser)){
			return "redirect:login";
		} else{
			user = (Users) session.getAttribute("user");
			model.addAttribute("user", user);
		return "userEProfile";
		}
	}
	
	@RequestMapping(value = "userProfile", method = RequestMethod.POST)
	private String userProfile() {
		return "redirect:userEProfile";
	}
	
	@RequestMapping(value = "/updateUserProfile", method = RequestMethod.POST)
	public String userEditProfile(Model model, @ModelAttribute Users user){
		try {
			userDao.insertUpdate(user);
			model.addAttribute("successAdd", "Value succesfully changed");
		} catch (Exception e) {
			model.addAttribute("failAdd", "Value not changed");
		}
		return  "redirect:userVProfile";
	}
	
	@RequestMapping(value = "/{id}/viewBRoute",method = RequestMethod.GET)
	private String userBusRoute(Model model,@PathVariable("id") Long id, @ModelAttribute Users user, HttpSession session){
		String loginUser = (String) session.getAttribute("activeUser");
		if(StringUtils.isEmpty(loginUser)){
			return "redirect:login";
		} else{
			model.addAttribute("userBusRoute", setRouteDao.get(id));
			return "userBusRoute";
		}
	}
}
