package se.sunet.ati.ladok.rest.studiedeltagande.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import se.sunet.ati.ladok.rest.dto.studiedeltagande.Student;
import se.sunet.ati.ladok.rest.studiedeltagande.StudentTjanst;
import se.sunet.ati.ladok.rest.studiedeltagande.impl.StudentTjanstImpl;

public class StudentTjanstTest {
	
	@Test
	public void test() throws Exception {
		StudentTjanst st = new StudentTjanstImpl();
		Student student = st.hamtaStudentViaPersonnummer("194502051230");
		assertNotNull(student);
		System.out.println("\n" + student.toString());
	}
	
}
