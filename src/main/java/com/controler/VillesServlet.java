package com.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.VilleService;

@Controller
public class VillesServlet {
	
	@Autowired
	VilleService service;

	@GetMapping(value = "/villes")
	public String villes(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model) {
		service.villes(page, model);
		return "villes";
	}
	
}
