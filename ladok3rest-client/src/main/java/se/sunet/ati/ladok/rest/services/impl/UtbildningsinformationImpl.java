package se.sunet.ati.ladok.rest.services.impl;

import javax.ws.rs.client.WebTarget;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import se.sunet.ati.ladok.rest.services.Utbildningsinformation;
import se.sunet.ati.ladok.rest.util.ClientUtil;

public class UtbildningsinformationImpl implements Utbildningsinformation{

    private static Log log = LogFactory.getLog(UtbildningsinformationImpl.class);

    private static final String UTBILDNINGSINFORMATION_URL = "/utbildningsinformation";
    private static final String UTBILDNINGSINFORMATION_RESPONSE_TYPE = "application/vnd.ladok-utbildningsinformation";
    private static final String UTBILDNINGSINFORMATION_MEDIATYPE = "xml";

    WebTarget utbildningsinformation;
    
    public UtbildningsinformationImpl() throws Exception {
        this.utbildningsinformation = ClientUtil.newClient(UTBILDNINGSINFORMATION_URL);
    }
}
