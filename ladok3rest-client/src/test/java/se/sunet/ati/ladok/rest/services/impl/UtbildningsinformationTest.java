package se.sunet.ati.ladok.rest.services.impl;

import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import se.sunet.ati.ladok.rest.dto.utbildningsinformation.Utbildningstillfalle;
import se.sunet.ati.ladok.rest.services.Utbildningsinformation;
import se.sunet.ati.ladok.rest.util.ClientUtil;

public class UtbildningsinformationTest {

	private static Log log = LogFactory.getLog(ClientUtil.class);
	
	@Test
	public void testHamtaUtbildningstillfalle() throws Exception {
		Utbildningsinformation ui = new UtbildningsinformationImpl();
				
		String utbildningstillfalleUID = "3b652cd1-9a77-11e5-acb6-05a8d0524f2f";
		
		Utbildningstillfalle utbildningstillfalle = ui.hamtaUtbildningstillfalleViaUtbildningsUtbildningstillfalleUID(utbildningstillfalleUID);

		log.debug("Hämtat kurstillfälleskod: " + utbildningstillfalle.getTillfalleskod());
		log.debug("Hämtat utbildningstillfälle uid: " + utbildningstillfalle.getUid());
		
		assertTrue("Verkar inte ha funkat.", utbildningstillfalleUID.equalsIgnoreCase(utbildningstillfalle.getUid()));

		log.debug("Utbildningstillfälle: " + utbildningstillfalle.toString());

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
