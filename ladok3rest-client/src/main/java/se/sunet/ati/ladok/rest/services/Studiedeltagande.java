package se.sunet.ati.ladok.rest.services;

import se.sunet.ati.ladok.rest.dto.studiedeltagande.Student;

public interface Studiedeltagande {
	
	public Student hamtaStudentViaPersonnummer(String personnummer) throws Exception;

}
