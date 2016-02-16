package se.sunet.ati.ladok.rest.services;

import se.sunet.ati.ladok.rest.dto.studiedeltagande.Student;

public interface Studiedeltagande extends LadokServiceProperties {
	
	public Student hamtaStudentViaPersonnummer(String personnummer);

}
