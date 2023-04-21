package com.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.model.VilleModel;

@Service
public class DistanceService {

	@Autowired
	APIService api;
	
	public void choix(Model model) {
		model.addAttribute("villes", api.getAllVilles());
	}
	
	public void calcul(HttpServletRequest request, Model model) {
		model.addAttribute("villes", api.getAllVilles());
		
		double distance;		
		if(request.getParameter("ville1").equals(request.getParameter("ville2"))){
			distance = 0;
			
			VilleModel ville1 = api.getOneVille(request.getParameter("ville1"));
            model.addAttribute("ville1", ville1);
            
			VilleModel ville2 = api.getOneVille(request.getParameter("ville2"));
            model.addAttribute("ville2", ville2);
            
    		model.addAttribute("distance", distance);
		} else {
			VilleModel ville1 = api.getOneVille(request.getParameter("ville1"));
            model.addAttribute("ville1", ville1);
            double lat1 = Double.parseDouble(ville1.getLatitude());
            double long1 = Double.parseDouble(ville1.getLongitude());
            
            VilleModel ville2 = api.getOneVille(request.getParameter("ville2"));
            model.addAttribute("ville2", ville2);
            double lat2 = Double.parseDouble(ville2.getLatitude());
            double long2 = Double.parseDouble(ville2.getLongitude());

            // https://geodesie.ign.fr/contenu/fichiers/Distance_longitude_latitude.pdf
            double dAngulaire = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(long2-long1));
            distance = dAngulaire * 6378.137;		
    		model.addAttribute("distance", distance);
		}		
	}
	
}
