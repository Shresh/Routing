package com.ittraning.shresh;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.engine.internal.TwoPhaseLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ittraning.shresh.daos.BusDao;
import com.ittraning.shresh.models.Bus;

@Controller
public class BusController {

	@Autowired
	private BusDao busDao;

	@RequestMapping(value = "adBus", method = RequestMethod.GET)
	public String addBus(Model model, HttpSession session) {
		String loginUser = (String) session.getAttribute("activeUser");
		if (StringUtils.isEmpty(loginUser)) {
			return "redirect:login";
		} else {
			model.addAttribute("bus", new Bus());
			return "addBus";
		}
	}

	@RequestMapping(value = "adBus", method = RequestMethod.POST)
	public String insert(@ModelAttribute Bus bus, Model model) {
		try {
			String b = bus.getBusNo().concat("A");
			bus.setBusNo(b);
			busDao.insert(bus);
			model.addAttribute("successAdd", "Bus succesfully added");
		} catch (Exception e) {
			model.addAttribute("failAdd", "Bus not added!!!!!!!");
		}
		model.addAttribute("bus", new Bus());
		return "addBus";
	}

	@RequestMapping(value = "viewBus", method = RequestMethod.GET)
	public String view(Model model, HttpSession session) {
		String loginUser = (String) session.getAttribute("activeUser");
		if (StringUtils.isEmpty(loginUser)) {
			return "redirect:login";
		} else {
			List<Bus> busList = busDao.getAll();
			model.addAttribute("bsList", busList);
			return "viewBus";
		}
	}

	@RequestMapping(value = "/{id}/viewB", method = RequestMethod.GET)
	public String updateBus(Model model, @PathVariable("id") Long id, HttpSession session) {
		String loginUser = (String) session.getAttribute("activeUser");
		if (StringUtils.isEmpty(loginUser)) {
			return "redirect:../login";
		} else {
			model.addAttribute("bus", busDao.get(id));
			//Bus bus = busDao.get(id);
			return "editBus";
		}
	}

	@RequestMapping(value = "/{id}/deleteB", method = RequestMethod.GET)
	public String deleteBus(Model model, @PathVariable("id") Long id, HttpSession session) {
		String loginUser = (String) session.getAttribute("activeUser");
		if (StringUtils.isEmpty(loginUser)) {
			return "redirect:../login";
		} else {
			try {
				busDao.delete(id);
			} catch (Exception e) {
				model.addAttribute("errorDelete","Sorry cannot delete this data because of the association with other table.");
			}
			return "redirect:../viewBus";
		}
	}

	@RequestMapping(value = "/updateBus", method = RequestMethod.POST)
	public String updateBus(Model model, @ModelAttribute Bus bus) {
		busDao.insertUpdate(bus);
		return "redirect:viewBus";
	}
}
