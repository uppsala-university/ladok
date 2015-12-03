package se.sunet.ati.ladok.rest.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.util.Properties;
import java.io.FileInputStream;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ClientUtil {

	private static Log log = LogFactory.getLog(ClientUtil.class);
	
	static public WebTarget newClient(String path) throws Exception { 
		
		Class<ClientUtil> thisClass = ClientUtil.class;
		String clientCertificateFile = null;
		String clientCertificatePwd = null;
		String trustStoreFile = null;
		String trustStorePwd = null;
		String restBase;
		Properties properties = new Properties();
		
		try {
			InputStream in = thisClass.getClassLoader().getResourceAsStream("restclient.properties");
			if (in == null) {
				throw new Exception("Unable to find restclient.properties (see restclient.properties.sample)");
			}

			properties.load(in);

			// Check client certificate key store and password.
			clientCertificateFile = properties.getProperty("clientCertificateFile");
			if (clientCertificateFile == null || clientCertificateFile.equals("")) {
				throw new Exception("Missing property \"clientCertificateFile\".");					
			}
			if (!clientCertificateFile.substring(0, 1).equalsIgnoreCase("/")) {
				clientCertificateFile = System.getProperty("user.home") + "/" + clientCertificateFile;
				log.info("Using client certificate keystore path relative to home directory '" + System.getProperty("user.home")  + "'.");
			}
			if (!Files.exists(Paths.get(clientCertificateFile))) {
				throw new Exception("Property \"clientCertificateFile\" (\"" + clientCertificateFile + "\") does not exist.");
			}
			clientCertificatePwd = properties.getProperty("clientCertificatePwd");
			if (clientCertificatePwd == null || clientCertificatePwd.equals("")) {
				throw new Exception("Missing property \"clientCertificatePwd\".");					
			}
			log.info("Using client certificate keystore: " + clientCertificateFile);

			// Check certificate trust store and password.
			trustStoreFile = properties.getProperty("trustStoreFile");
			if (trustStoreFile == null || trustStoreFile.equals("")) {
				throw new Exception("Missing property \"trustStoreFile\".");					
			}
			if (!trustStoreFile.substring(0, 1).equalsIgnoreCase("/")) {
				trustStoreFile = System.getProperty("user.home") + "/" + trustStoreFile;
				log.info("Using certificate trust store path relative to home directory '" + System.getProperty("user.home")  + "'.");
			}
			if (!Files.exists(Paths.get(trustStoreFile))) {
				throw new Exception("Property \"trustStoreFile\" have no corresponding resource.");
			}
			
			trustStorePwd = properties.getProperty("trustStorePwd");
			if (trustStorePwd == null || trustStorePwd.equals("")) {
				throw new Exception("Missing property \"trustStorePwd\".");					
			}	
			log.info("Using certificate trust store: " + trustStoreFile);			
			
			if ((restBase = properties.getProperty("restbase")) == null) {
				throw new Exception("Missing property \"restbase\"");
			}			
			
		} catch (IOException e) {
			log.error("Unable to read restclient.properties");
			throw e;
		}

		SSLContext sslContext = SSLContext.getInstance("SSLv3");
		KeyManagerFactory kmf = KeyManagerFactory.getInstance( KeyManagerFactory.getDefaultAlgorithm() );	
		
		// Initiate client certificate key store and certificate trust store.
		KeyStore clientKeystore;
		clientKeystore = KeyStore.getInstance("PKCS12");
		clientKeystore.load(new FileInputStream(clientCertificateFile), clientCertificatePwd.toCharArray());
		KeyStore trustStore = KeyStore.getInstance("JKS");
		trustStore.load(new FileInputStream(trustStoreFile), trustStorePwd.toCharArray());
	
		// Assign and initiate client builder.
		kmf.init( clientKeystore, clientCertificatePwd.toCharArray() );
		sslContext.init( kmf.getKeyManagers(), null, null );
		ClientBuilder cb = ClientBuilder.newBuilder();
		cb.keyStore(clientKeystore, clientCertificatePwd);		
		cb.trustStore(trustStore);

		return cb.build().target(stripEndSlash(restBase) + "/" + stripStartSlash(path));
	}
	
	static private String stripEndSlash(String path) {
		return path.replaceFirst("/$", "");
	}

	static private String stripStartSlash(String path) {
		return path.replaceFirst("^/", "");
	}

	public static final String CONTENT_TYPE_HEADER_NAME = "Content-Type";
	public static final String CONTENT_TYPE_HEADER_VALUE = "application/vnd.ladok+xml";
	
}