package com.service;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.model.VilleModel;

@Service
public class APIService {
	
	private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(5);
	
	private final WebClient localApiClient;
	
	@Autowired
	public APIService() {
		this.localApiClient = WebClient.create("http://localhost:8181");
	}
	
	public List<VilleModel> getAllVilles(){
		return localApiClient
                .get()
                .uri("/villes")
                .retrieve()
                .toEntityList(VilleModel.class)
                .block(REQUEST_TIMEOUT)
                .getBody();	
	}
	
	public VilleModel getOneVille(String codeCommune){
		return (VilleModel) localApiClient
                .get()
                .uri("/ville?codePostal=" + codeCommune)
                .retrieve()
                .toEntity(VilleModel.class)
                .block(REQUEST_TIMEOUT)
                .getBody();
	}
	
}
