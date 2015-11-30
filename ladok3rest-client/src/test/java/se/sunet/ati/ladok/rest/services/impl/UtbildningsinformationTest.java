package se.sunet.ati.ladok.rest.services.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import se.sunet.ati.ladok.rest.dto.utbildningsinformation.Utbildningstillfalle;
import se.sunet.ati.ladok.rest.services.Utbildningsinformation;

public class UtbildningsinformationTest {

	@Test
	public void testHamtaUtbildningstillfalle() throws Exception {
		Utbildningsinformation ui = new UtbildningsinformationImpl();
				
		String utbildningstillfalleUID = "be5946ae-9370-11e5-bd1e-85b610744f1a";
		
		Utbildningstillfalle utbildningstillfalle = ui.hamtaUtbildningstillfalleViaUtbildningsUtbildningstillfalleUID(utbildningstillfalleUID);

		assertTrue("Verkar inte ha funkat.", utbildningstillfalleUID.equalsIgnoreCase(utbildningstillfalle.getUid()));

		System.out.println("\nMeh:" + utbildningstillfalle.toString());

//		assertNotNull("");
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		JsonParser jp = new JsonParser();
//		JsonElement je = jp.parse(st.hamtaStudentViaPersonnummer("197209128672"));
//		String prettyJsonString = gson.toJson(je);
//
//		System.out.println(prettyJsonString);		
		
//		assertNotNull("");
//		Source xmlInput = new StreamSource(new StringReader(st.hamtaStudentViaPersonnummer("194502051230")));
//		StringWriter stringWriter = new StringWriter();
//		StreamResult xmlOutput = new StreamResult(stringWriter);
//		TransformerFactory transformerFactory = TransformerFactory
//				.newInstance();
//		Transformer transformer = transformerFactory.newTransformer();
//		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//		transformer.setOutputProperty(
//				"{http://xml.apache.org/xslt}indent-amount",
//				String.valueOf("4"));
//		transformer.transform(xmlInput, xmlOutput);
//		System.out.println(xmlOutput.getWriter().toString());		
		
	}	
	
}
