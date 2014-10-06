package se.sunet.ati.ladok.rest.studiedeltagande;

import se.sunet.ati.ladok.rest.dto.studiedeltagande.Student;

public interface StudentTjanst {
	
	public Student hamtaStudentViaPersonnummer(String personnummer) throws Exception;

}
