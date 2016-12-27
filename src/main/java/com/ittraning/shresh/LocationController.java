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

import com.ittraning.shresh.daos.LocationDao;
import com.ittraning.shresh.models.Location;

@Controller
public class LocationController {

	@Autowired
	private LocationDao locationDao;

	@RequestMapping(value = "addLocation", method = RequestMethod.GET)
	public String addLocation(Model model, HttpSession session) {
		String loginUser = (String) session.getAttribute("activeUser");
		if (StringUtils.isEmpty(loginUser)) {
			return "redirect:login";
		} else {
			model.addAttribute("location", new Location());
			return "addLocation";
		}
	}

	@RequestMapping(value = "addLocation", method = RequestMethod.POST)
	public String insert(@ModelAttribute Location location, Model model) {
		
			try {
				locationDao.insert(location);
				model.addAttribute("successAdd", "Location successfully added");
			} catch (Exception e) {
				model.addAttribute("failAdd", "Location not added!!!!!");
			}
			model.addAttribute("location", new Location());
			return "addLocation";
	}

	@RequestMapping(value = "viewLocation", method = RequestMethod.GET)
	public String view(Model model, HttpSession session) {
		String loginUser = (String) session.getAttribute("activeUser");
		if (StringUtils.isEmpty(loginUser)) {
			return "redirect:login";
		} else {
			List<Location> locationList = locationDao.getAll();
			model.addAttribute("locationList", locationList);
			return "viewLocation";
		}
	}

	@RequestMapping(value = "/{id}/editL", method = RequestMethod.GET)
	public String updateRoute(Model model, @PathVariable("id") Long id, HttpSession session) {
		String loginUser = (String) session.getAttribute("activeUser");
		if (StringUtils.isEmpty(loginUser)) {
			return "redirect:../login";
		} else {
			model.addAttribute("location", locationDao.get(id));
			return "editLocation";
		}
	}

	@RequestMapping(value = "/{id}/deleteL", method = RequestMethod.GET)
	public String deleteDriver(Model model, @PathVariable("id") Long id, HttpSession session) {
		String loginUser = (String) session.getAttribute("activeUser");
		if (StringUtils.isEmpty(loginUser)) {
			return "redirect:../login";
		} else {
			try {
				locationDao.delete(id);
			} catch (Exception e) {
				model.addAttribute("errorDelete",
						"Sorry cannot delete this location because of the association with other table.");
			}
			return "redirect:../viewLocation";
		}
	}
	
	@RequestMapping(value = "/updateLocation",method = RequestMethod.POST)
	public String updateRoute(Model model,@ModelAttribute Location location){
		locationDao.insertUpdate(location);
		return "redirect:viewLocation";
	}
}
