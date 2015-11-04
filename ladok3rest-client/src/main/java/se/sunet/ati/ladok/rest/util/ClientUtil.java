package se.sunet.ati.ladok.rest.util;

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

public class ClientUtil {

	private static Log log = LogFactory.getLog(ClientUtil.class);
	
	static public WebTarget newClient(String path) throws Exception { 
		
	    WebTarget client;
		Class<ClientUtil> thisClass = ClientUtil.class;
		String certificateFile = null;
		String certificatePwd = null;
		String restBase;
		Properties properties = new Properties();

		try {
			InputStream in = thisClass.getClassLoader().getResourceAsStream("restclient.properties");
			if (in == null) {
				throw new Exception("Unable to find restclient.properties (see restclient.properties.sample)");
			}

			properties.load(in);

			// Check certificate and password.
			certificateFile = properties.getProperty("certificateFile");
			if (certificateFile == null || certificateFile.equals("")) {
				throw new Exception("Missing property \"certificateFile\".");					
			}
			if (thisClass.getClassLoader().getResourceAsStream(certificateFile) == null) {
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

		if ((restBase = properties.getProperty("restbase")) == null) {
			throw new Exception("Missing property \"restbase\"");
		}
		
		KeyStore keystore;
		SSLContext sc = SSLContext.getInstance("SSLv3");
		KeyManagerFactory kmf = KeyManagerFactory.getInstance( KeyManagerFactory.getDefaultAlgorithm() );			
		
		keystore = KeyStore.getInstance("PKCS12");
		keystore.load(thisClass.getClassLoader().getResourceAsStream(certificateFile), certificatePwd.toCharArray());
		
		kmf.init( keystore, certificatePwd.toCharArray() );
		sc.init( kmf.getKeyManagers(), null, null );
		
		ClientBuilder cb = ClientBuilder.newBuilder();
		cb.keyStore(keystore, certificatePwd);

		client = cb.build().target(stripEndSlash(restBase) + "/" + stripStartSlash(path));
		
		return client;
	}
	
	static private String stripEndSlash(String path) {
		return path.replaceFirst("/$", "");
	}

	static private String stripStartSlash(String path) {
		return path.replaceFirst("^/", "");
	}
}
