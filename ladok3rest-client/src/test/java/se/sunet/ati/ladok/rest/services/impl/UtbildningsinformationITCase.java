package se.sunet.ati.ladok.rest.services.impl;

import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import se.ladok.schemas.Benamning;
import se.ladok.schemas.Benamningar;
import se.ladok.schemas.Organisation;
import se.ladok.schemas.Organisationslista;
import se.ladok.schemas.utbildningsinformation.Kurs2007GrundAvancerad;
import se.ladok.schemas.utbildningsinformation.Modul2007GrundAvancerad;
import se.ladok.schemas.utbildningsinformation.PeriodID;
import se.ladok.schemas.utbildningsinformation.Utbildningsinstans;
import se.ladok.schemas.utbildningsinformation.Utbildningstillfalle;
import se.ladok.schemas.utbildningsinformation.Versionsinformation;
import se.sunet.ati.ladok.rest.services.Utbildningsinformation;

public class UtbildningsinformationITCase {

	private static Log log = LogFactory.getLog(UtbildningsinformationITCase.class);

	private static final String datavetenskapOrganisationUID = "00000000-3300-0000-0043-000000000010";
	private static final String utbildningsmallUID = "55555555-2007-0005-0001-000400000036";
	private static final String utbildningstillfalleUID = "01010101-2222-3333-0043-000000002910";
	private static final String utbildningstillfalleInstansUID = "01010101-2222-3333-0043-000000002371";


	Utbildningsinformation ui;

	@Before
	public void setUp() {
		ui = new UtbildningsinformationImpl();
	}

	@Test
	public void testSokAllaOrganisationer() {
		Organisationslista organisationer = ui.sokAllaOrganisationer();
		for (Organisation organisation : organisationer.getOrganisation()) {
			if ("0000".equals(organisation.getKod())) {
				for (Benamning benamn : organisation.getBenamningar().getBenamning()) {
					if (benamn.getSprakkod().equals("en")) {
						assertTrue(benamn.getText().equals("Computer Science"));
					} else if (benamn.getSprakkod().equals("sv")) {
						assertTrue(benamn.getText().equals("Datavetenskapliga institutionen"));
					}
				}
				assertTrue(datavetenskapOrganisationUID.equals(organisation.getUid()));
			}
		}
	}

	@Test
	public void testHamtaUtbildningstillfalle() throws Exception {

		Utbildningstillfalle utbildningstillfalle = ui
				.hamtaUtbildningstillfalleViaUtbildningsUtbildningstillfalleUID(utbildningstillfalleUID);

		assertTrue(utbildningstillfalleUID.equals(utbildningstillfalle.getUid()));
		assertTrue(utbildningstillfalleInstansUID.equals(utbildningstillfalle.getUtbildningsinstansUID()));
	}

	@Test
	public void testHamtaUtbildningsinstansViaUtbildningsinstansUID(){
		Utbildningsinstans utbildningsinstans = ui
				.hamtaUtbildningsinstansViaUtbildningsinstansUID(utbildningstillfalleInstansUID);

		assertTrue(utbildningstillfalleInstansUID.equalsIgnoreCase(utbildningsinstans.getUid()));

		for (Benamning benamn : utbildningsinstans.getBenamningar().getBenamning()) {
			if (benamn.getSprakkod().equals("en")) {
				assertTrue(benamn.getText().equals("ENG_Automatateori"));
			} else if (benamn.getSprakkod().equals("sv")) {
				assertTrue(benamn.getText().equals("Automatateori"));
			}
		}
	}

	@Test
	public void testSkapaUtbildningsinstans(){
		Utbildningsinstans uiToSave = new Utbildningsinstans();
		Benamningar benamningar = new Benamningar();
		Benamning svenska = new Benamning();
		svenska.setSprakkod("sv");
		svenska.setText("TEST_SVENSKA");
		benamningar.getBenamning().add(svenska);
		uiToSave.setBenamningar(benamningar);
		uiToSave.setOmfattning("10");
		uiToSave.setOrganisationUID(datavetenskapOrganisationUID);
		uiToSave.setStatus(1);
		uiToSave.setUtbildningstypID(24);

		Versionsinformation vInfo = new Versionsinformation();
		vInfo.setArSenasteVersion(true);
		vInfo.setVersionsnummer(1);
		PeriodID pid = new PeriodID();
		pid.setValue(43332);
		vInfo.setGiltigFranPeriodID(pid);

		uiToSave.setVersionsinformation(vInfo);

        /*Utbildningsinstans savedIu = ui.skapaUtbildningsinstans(uiToSave);	*/

		//uiToSave.setUtbildningskonfigurationUID(value);
	}

	@Test
	public void testSkapaModul2007GrundAvancerad(){
		Modul2007GrundAvancerad modul = new Modul2007GrundAvancerad();
		Benamningar benamningar = new Benamningar();
		Benamning svenska = new Benamning();
		svenska.setSprakkod("sv");
		svenska.setText("TEST_SVENSKA");
		benamningar.getBenamning().add(svenska);
		modul.setBenamningar(benamningar);
		modul.setOmfattning("1.0");
		modul.setOrganisationUID(datavetenskapOrganisationUID);
		modul.setStatus(1);
		modul.setUtbildningstypID(4);

		Versionsinformation vInfo = new Versionsinformation();
		vInfo.setArSenasteVersion(true);
		vInfo.setVersionsnummer(1);
		PeriodID pid = new PeriodID();
		pid.setValue(43332);
		vInfo.setGiltigFranPeriodID(pid);

		modul.setVersionsinformation(vInfo);

		//modul.setUtbildningsmallUID(utbildningsmallUID);

		Utbildningsinstans savedIu = ui.skapaModul2007GrundAvanceradViaUtbildningsinstansUID(modul, utbildningstillfalleInstansUID);
	}
}
