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

import com.ittraning.shresh.daos.BusDao;
import com.ittraning.shresh.daos.LocationDao;
import com.ittraning.shresh.daos.SetRouteDao;
import com.ittraning.shresh.models.Bus;
import com.ittraning.shresh.models.Location;
import com.ittraning.shresh.models.SetRoute;

@Controller
public class RouteController {

	@Autowired
	private SetRouteDao setRouteDao;

	@Autowired
	private BusDao busDao;

	@Autowired
	private LocationDao locationDao;

	@RequestMapping(value = "addRoute", method = RequestMethod.GET)
	public String setRoute(Model model, SetRoute setroute, HttpSession session) {
		String loginUser = (String) session.getAttribute("activeUser");
		if (StringUtils.isEmpty(loginUser)) {
			return "redirect:login";
		} else {
			model.addAttribute("setroute", new SetRoute());
			List<Bus> busList = busDao.getAll();
			model.addAttribute("bsList", busList);
			List<Location> locationList = locationDao.getAll();
			model.addAttribute("locationList", locationList);
			return "addRoute";
		}
	}

	@RequestMapping(value = "addRoute", method = RequestMethod.POST)
	public String insert(@ModelAttribute SetRoute setroute, Model model) {
		try {
			setRouteDao.insert(setroute);
			model.addAttribute("successAdd", "Value succesfully added");
		} catch (Exception e) {
			model.addAttribute("failAdd", "Value not added!!!!!!!");
		}
		// model.addAttribute("setroute",new SetRoute());
		// List<Bus> busList = busDao.getAll();
		// model.addAttribute("bsList",busList);
		// List<Location> locationList = locationDao.getAll();
		// model.addAttribute("locationList",locationList);
		return "redirect:addRoute";
	}

	@RequestMapping(value = "viewRoute", method = RequestMethod.GET)
	public String view(Model model, HttpSession session) {
		// if not active user then redirect to the login page
		String loginUser = (String) session.getAttribute("activeUser");
		if (StringUtils.isEmpty(loginUser)) {
			return "redirect:login";
		} else {
			List<SetRoute> setRoute = setRouteDao.getAll();
			model.addAttribute("routeList", setRoute);
			return "viewRoute";
		}
	}

	@RequestMapping(value = "/{id}/editSr", method = RequestMethod.GET)
	public String updateSetRoute(Model model, @PathVariable("id") Long id, HttpSession session) {
		String loginUser = (String) session.getAttribute("activeUser");
		if (StringUtils.isEmpty(loginUser)) {
			return "redirect:../login";
		} else {
			model.addAttribute("setRoute", setRouteDao.get(id));
			List<Bus> busList = busDao.getAll();
			model.addAttribute("bsList", busList);
			List<Location> locationList = locationDao.getAll();
			model.addAttribute("locationList", locationList);
			return "editRoute";
		}
	}

	@RequestMapping(value = "/{id}/deleteSr", method = RequestMethod.GET)
	public String deleteSetRoute(Model model, @PathVariable("id") Long id, HttpSession session) {
		String loginUser = (String) session.getAttribute("activeUser");
		if (StringUtils.isEmpty(loginUser)) {
			return "redirect:../login";
		} else {
			setRouteDao.delete(id);
			return "redirect:../viewRoute";
		}
	}

	@RequestMapping(value = "/updateRoute", method = RequestMethod.POST)
	public String updateSetRoute(Model model, @ModelAttribute SetRoute setRoute) {
		setRouteDao.insertUpdate(setRoute);
		return "redirect:viewRoute";
	}

}
