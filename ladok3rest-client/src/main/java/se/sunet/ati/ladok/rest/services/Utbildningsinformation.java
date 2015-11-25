package se.sunet.ati.ladok.rest.services;

import se.sunet.ati.ladok.rest.dto.utbildningsinformation.Utbildningstillfalle;

public interface Utbildningsinformation {

	public Utbildningstillfalle hamtaUtbildningstillfalleViaUtbildningsUtbildningstillfalleUID(String utbildningstillfalleUID);
	
}
