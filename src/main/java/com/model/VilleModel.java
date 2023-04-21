package com.model;

import lombok.Data;

@Data
public class VilleModel {

	private Long id;
	private String codeCommune;
	private String nomCommune;
	private String codePostal;
	private String libelleAcheminement;
	private String ligne;
	private String longitude;
	private String latitude;
	
	public Long getId() {
		return id;
	}

	public String getCode_commune_INSEE() {
		return codeCommune;
	}

	public void setCode_commune_INSEE(String code_commune_INSEE) {
		this.codeCommune = code_commune_INSEE;
	}

	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}

	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getLigne() {
		return ligne;
	}

	public void setLigne(String ligne) {
		this.ligne = ligne;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}
}