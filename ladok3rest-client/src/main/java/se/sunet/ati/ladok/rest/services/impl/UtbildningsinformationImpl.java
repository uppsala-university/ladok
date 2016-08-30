package se.sunet.ati.ladok.rest.services.impl;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import se.ladok.schemas.Organisationslista;
import se.ladok.schemas.utbildningsinformation.Modul2007GrundAvancerad;
import se.ladok.schemas.utbildningsinformation.ObjectFactory;
import se.ladok.schemas.utbildningsinformation.Utbildningsinstans;
import se.ladok.schemas.utbildningsinformation.Utbildningstillfalle;
import se.sunet.ati.ladok.rest.services.Utbildningsinformation;
import se.sunet.ati.ladok.rest.util.ClientUtil;

public class UtbildningsinformationImpl extends LadokServicePropertiesImpl implements Utbildningsinformation{

    private static Log log = LogFactory.getLog(UtbildningsinformationImpl.class);

    private static final String UTBILDNINGSINFORMATION_URL = "/utbildningsinformation";
    private static final String UTBILDNINGSINFORMATION_RESPONSE_TYPE = "application/vnd.ladok-utbildningsinformation";
    private static final String UTBILDNINGSINFORMATION_MEDIATYPE = "xml";
    private static final String RESOURCE_UTBILDNINGSTILFALLE = "utbildningstillfalle";
    private static final String RESOURCE_UTBILDNINGSINSSTANS = "utbildningsinstans";
    private static final String RESOURCE_ORGANISATION = "organisation";
	private static final String RESOURCE_UNDERLIGGANDE = "underliggande";

    WebTarget utbildningsinformation;
    
    /**
	 * This method makes it possible to lazily constructing the web client,
	 * which is needed in order to enable loading properties either from a
	 * properties file or via dependency injection in an OSGi environment.
	 */
    WebTarget getClient() {
    	if (this.utbildningsinformation == null) {
            this.utbildningsinformation = ClientUtil.newClient(this, UTBILDNINGSINFORMATION_URL);
    	}
    	return this.utbildningsinformation;
    }

	@Override
	public Utbildningstillfalle hamtaUtbildningstillfalleViaUtbildningsUtbildningstillfalleUID(
			String utbildningstillfalleUID) {
    	String responseType = UTBILDNINGSINFORMATION_RESPONSE_TYPE + "+" + UTBILDNINGSINFORMATION_MEDIATYPE;
    	WebTarget client = getClient().path(RESOURCE_UTBILDNINGSTILFALLE).path(utbildningstillfalleUID);
    	log.info("Query URL: " + client.getUri() + ", response type: " + responseType);
    	return client
    			.request()
    			.header(ClientUtil.CONTENT_TYPE_HEADER_NAME, ClientUtil.CONTENT_TYPE_HEADER_VALUE)
    			.accept(responseType)
    			.get(Utbildningstillfalle.class);
	}

	@Override
	public Utbildningsinstans hamtaUtbildningsinstansViaUtbildningsinstansUID(String utbildningsinstansUID)  {
    	String responseType = UTBILDNINGSINFORMATION_RESPONSE_TYPE + "+" + UTBILDNINGSINFORMATION_MEDIATYPE;
    	WebTarget client = getClient().path(RESOURCE_UTBILDNINGSINSSTANS).path(utbildningsinstansUID);
    	log.info("Query URL: " + client.getUri() + ", response type: " + responseType);
    	return client
    			.request()
    			.header(ClientUtil.CONTENT_TYPE_HEADER_NAME, ClientUtil.CONTENT_TYPE_HEADER_VALUE)
    			.accept(responseType)
    			.get(Utbildningsinstans.class);
	}

	@Override
	public Organisationslista sokAllaOrganisationer() {
    	String responseType = UTBILDNINGSINFORMATION_RESPONSE_TYPE + "+" + UTBILDNINGSINFORMATION_MEDIATYPE;
    	WebTarget client = getClient().path(RESOURCE_ORGANISATION);
    	log.info("Query URL: " + client.getUri() + ", response type: " + responseType);
    	return client
    			.request()
    			.header(ClientUtil.CONTENT_TYPE_HEADER_NAME, ClientUtil.CONTENT_TYPE_HEADER_VALUE)
    			.accept(responseType)
    			.get(Organisationslista.class);
	}

	@Override
	public Utbildningsinstans skapaUtbildningsinstans(Utbildningsinstans utbildningsinstans) {
    	String responseType = UTBILDNINGSINFORMATION_RESPONSE_TYPE + "+" + UTBILDNINGSINFORMATION_MEDIATYPE;
    	String requestType = responseType;
    	WebTarget client = getClient().path(RESOURCE_UTBILDNINGSINSSTANS);
    	return client
    			.request(MediaType.APPLICATION_XML_TYPE)
    			.header(ClientUtil.CONTENT_TYPE_HEADER_NAME, ClientUtil.CONTENT_TYPE_HEADER_VALUE)
    			.accept(responseType)
    			.post(Entity.entity(utbildningsinstans, MediaType.APPLICATION_XML_TYPE), Utbildningsinstans.class);
	}

	@Override
	public Modul2007GrundAvancerad skapaModul2007GrundAvanceradViaUtbildningsinstansUID(Modul2007GrundAvancerad modul, String utbildningsinstansUID) {
		JAXBElement<Utbildningsinstans> modulJAXBElement = new ObjectFactory().createUtbildningsinstans(modul);
		WebTarget client = getClient().path(RESOURCE_UTBILDNINGSINSSTANS).path(utbildningsinstansUID).path(RESOURCE_UNDERLIGGANDE);
		return client
				.request()
				.header(ClientUtil.CONTENT_TYPE_HEADER_NAME, ClientUtil.CONTENT_TYPE_HEADER_VALUE)
				.post(Entity.entity(modulJAXBElement, ClientUtil.CONTENT_TYPE_HEADER_VALUE), Modul2007GrundAvancerad.class);
	}
}
