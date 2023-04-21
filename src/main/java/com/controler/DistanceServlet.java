package com.controler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.service.DistanceService;

@Controller
public class DistanceServlet {
	
	@Autowired
	DistanceService service;

	@GetMapping(value = "/distance")
	public String choixVilles(Model model) {
		service.choix(model);
		return "distance";
	}
	
	@PostMapping(value = "/distance")
	public String calcul(HttpServletRequest request, Model model) {
		service.calcul(request, model);
		return "distance";
	}
	
}
