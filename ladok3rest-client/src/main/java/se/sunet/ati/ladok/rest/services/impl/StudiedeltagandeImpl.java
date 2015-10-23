package se.sunet.ati.ladok.rest.services.impl;

import javax.ws.rs.client.WebTarget;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import se.sunet.ati.ladok.rest.dto.studiedeltagande.Student;
import se.sunet.ati.ladok.rest.services.Studiedeltagande;
import se.sunet.ati.ladok.rest.util.ClientUtil;

public class StudiedeltagandeImpl implements Studiedeltagande {
	
	private static Log log = LogFactory.getLog(StudiedeltagandeImpl.class);

    private static final String STUDIEDELTAGANDE_URL = "/studiedeltagande";
	private static final String STUDIEDELTAGANDE_RESPONSE_TYPE = "application/vnd.ladok-studiedeltagande";
	private static final String STUDIEDELTAGANDE_MEDIATYPE = "xml";

    WebTarget studiedeltagande;
	
    public StudiedeltagandeImpl() throws Exception {
    	this.studiedeltagande = ClientUtil.newClient(STUDIEDELTAGANDE_URL);
    }

    @Override
    public Student hamtaStudentViaPersonnummer(String personnummer) throws Exception {
    	String path = "/student/personnummer" + "/" + personnummer;
    	String responseType = STUDIEDELTAGANDE_RESPONSE_TYPE + "+" + STUDIEDELTAGANDE_MEDIATYPE;
    	log.info("Query URL: " + studiedeltagande.getUri() + path + ", response type: " + responseType);
    	return studiedeltagande.path(path).request(responseType).get(Student.class);
    }
}
