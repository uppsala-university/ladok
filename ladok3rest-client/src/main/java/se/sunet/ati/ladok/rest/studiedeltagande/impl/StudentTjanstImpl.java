package se.sunet.ati.ladok.rest.studiedeltagande.impl;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.Properties;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import se.sunet.ati.ladok.rest.dto.studiedeltagande.Student;
import se.sunet.ati.ladok.rest.studiedeltagande.StudentTjanst;

public class StudentTjanstImpl implements StudentTjanst {
	
	private static final String RESPONSE_TYPE_STUDIEDELTAGANDE = "application/vnd.ladok-studiedeltagande";
	
	private Log log = LogFactory.getLog(this.getClass());
	
	private String certificateFile = null;
	private String certificatePwd = null;
	private String restBase;
	private String mediaType = "+xml";
	private Properties properties;

    String studiedeltagandeUrl = "studiedeltagande/";
    WebTarget studiedeltagande;

    public StudentTjanstImpl() throws Exception {
		properties = new Properties();
		try {
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("restclient.properties");
			if (in == null) {
				throw new Exception("Unable to find restclient.properties (see restclient.properties.sample)");
			}

			properties.load(in);

			if ((restBase = properties.getProperty("restbase")) == null) {
				throw new Exception("Missing property \"restbase\"");
			}

			// Check certificate and password.
			certificateFile = properties.getProperty("certificateFile");
			if (certificateFile == null || certificateFile.equals("")) {
				throw new Exception("Missing property \"certificateFile\".");					
			}
			if (this.getClass().getClassLoader().getResourceAsStream(certificateFile) == null) {
				throw new Exception("Property \"certificateFile\" have no corresponding resource.");
			}
			log.info("certificate=" + certificateFile);

			certificatePwd = properties.getProperty("certificatePwd");
			if (certificatePwd == null || certificatePwd.equals("")) {
				throw new Exception("Missing property \"certificatePwd\".");					
			}

		} catch (IOException e) {
			log.error("Unable to read feedfetcher.properties");
			throw e;
		}

		KeyStore keystore;
		try {
			SSLContext sc = SSLContext.getInstance("SSLv3");
			KeyManagerFactory kmf = KeyManagerFactory.getInstance( KeyManagerFactory.getDefaultAlgorithm() );			
			
			keystore = KeyStore.getInstance("PKCS12");
			keystore.load(this.getClass().getClassLoader().getResourceAsStream(certificateFile), certificatePwd.toCharArray());
			
			kmf.init( keystore, certificatePwd.toCharArray() );
			sc.init( kmf.getKeyManagers(), null, null );
			
			ClientBuilder cb = ClientBuilder.newBuilder();
			cb.keyStore(keystore, certificatePwd);
			studiedeltagande = cb.build().target(restBase + studiedeltagandeUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

    }

    @Override
    public Student hamtaStudentViaPersonnummer(String personnummer) throws Exception {
    
    	log.info("Query URL: " +  restBase + studiedeltagandeUrl + "student/personnummer/" + personnummer);
    	log.info("Requested response type: " + RESPONSE_TYPE_STUDIEDELTAGANDE.toString() + mediaType);
    	
    	return studiedeltagande.path("student/personnummer/" + personnummer)
                .request(RESPONSE_TYPE_STUDIEDELTAGANDE + mediaType).get(Student.class);
//    	return studiedeltagande.path("student/personnummer/" + personnummer)
//                .request(RESPONSE_TYPE_STUDIEDELTAGANDE + mediaType).get(String.class);    	
    }

    
}
