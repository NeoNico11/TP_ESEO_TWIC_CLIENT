package com.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilServlet {

	@GetMapping(value = "/")
	public String accueil() {
		return "accueil";
	}
	
}
