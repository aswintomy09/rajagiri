package com.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.location.entities.Location;
import com.location.service.LocationService;
import com.location.util.EmailUtil;

@Controller
public class LocationController {
	
	
	@Autowired
	LocationService service;
	
	@Autowired
	EmailUtil emailUtil;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location,ModelMap modelMap) {
		Location locationSaved =service.saveLocation(location);
		String msg="Location saved with id:"+locationSaved.getId();
		modelMap.addAttribute("msg",msg);
		//emailUtil.sendEmail("aswintomy09@gmail.com", "Location Saved", "Successfully complted");
		return "createLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations",locations);
		return "displayLocations";
	}
	
	@RequestMapping("deleteLocation")
	public String deleteLocation(@RequestParam("id") int id,ModelMap modelMap) {
		Location location=service.getLocationById(id);
		service.deleteLocation(location);
		List<Location> locations =service.getAllLocations();
		modelMap.addAttribute("locations",locations);

		return "displayLocations";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id,ModelMap modelMap) {
		Location location=service.getLocationById(id);
		modelMap.addAttribute("location",location);
		return "updateLocation";
	}
	
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location")Location location,ModelMap modelMap) {
		service.updateLocation(location);
		List<Location> locations =service.getAllLocations();
		modelMap.addAttribute("locations",locations);
		return "displayLocation";
	}
}
