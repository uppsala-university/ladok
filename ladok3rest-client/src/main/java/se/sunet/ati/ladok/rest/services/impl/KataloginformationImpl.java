package se.sunet.ati.ladok.rest.services.impl;

import javax.ws.rs.client.WebTarget;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import se.sunet.ati.ladok.rest.services.Kataloginformation;
import se.sunet.ati.ladok.rest.util.ClientUtil;

public class KataloginformationImpl implements Kataloginformation {

    private static Log log = LogFactory.getLog(KataloginformationImpl.class);

    private static final String KATALOGINFORMATION_URL = "/kataloginformation";
    private static final String KATALOGINFORMATION_RESPONSE_TYPE = "application/vnd.ladok-kataloginformation";
    private static final String KATALOGINFORMATION_MEDIATYPE = "xml";

    WebTarget kataloginformation;
    
    public KataloginformationImpl() throws Exception {
        this.kataloginformation = ClientUtil.newClient(KATALOGINFORMATION_URL);
    }
}
