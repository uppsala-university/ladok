package se.sunet.ati.ladok.rest.services.impl;

import javax.ws.rs.client.WebTarget;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import se.sunet.ati.ladok.rest.services.Kataloginformation;
import se.sunet.ati.ladok.rest.util.ClientUtil;

public class KataloginformationImpl extends LadokServicePropertiesImpl implements Kataloginformation {

    private static Log log = LogFactory.getLog(KataloginformationImpl.class);

    private static final String KATALOGINFORMATION_URL = "/kataloginformation";
    private static final String KATALOGINFORMATION_RESPONSE_TYPE = "application/vnd.ladok-kataloginformation";
    private static final String KATALOGINFORMATION_MEDIATYPE = "xml";

    WebTarget kataloginformation;
    
    WebTarget getClient() throws Exception {
    	if (this.kataloginformation == null) {
            this.kataloginformation = ClientUtil.newClient(this, KATALOGINFORMATION_URL);
    	}
    	return this.kataloginformation;
    }
}
