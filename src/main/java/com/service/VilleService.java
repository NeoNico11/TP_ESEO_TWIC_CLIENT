package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.model.VilleModel;

@Service
public class VilleService {

	@Autowired
	APIService api;
	
	public void villes(int page, Model model) {
		VilleModel[] villesAffichees = new VilleModel[50];
        List<VilleModel> villes= api.getAllVilles();

        for(int i=0; i<50; i++) {
        	villesAffichees[i] = villes.get((50*(page-1)) + i);
        }

        model.addAttribute("pages", villes.size() / 50);
        model.addAttribute("villes", villesAffichees);
	}
	
}
