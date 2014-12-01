package se.sunet.ati.ladok.atom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.abdera.model.Entry;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileBasedEventPersistance implements EventPersistance {
	
	private Log log = LogFactory.getLog(this.getClass());
	private static String FILENAME="ladok.log";
	private static String PROPERTY="last";
	
	static {
		File f = new File("ladok.log");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public synchronized Entry saveEntry(Entry e) throws Exception{
		// TODO: Feed id? :
		String feedIdAndEventId = e.getDocument().getBaseUri().getPath().replaceAll("^.*/", "")
				+ AtomClient.FEED_ENTRY_SEPARATOR + e.getId().toString();
		log.info("saveEntry feedIdAndEventId=" + feedIdAndEventId);
		Properties prop = new Properties();
		prop.setProperty(PROPERTY, feedIdAndEventId);
		try {
			prop.store(new FileOutputStream(FILENAME), null);
			log.info("Saving message: " + e.getId().toString());
			return(e);
		} catch (Exception e1) {
			e1.printStackTrace();
			return(null);
		}
	}

	@Override
	public boolean isUnseenEntry(Entry e) {
		// TODO
		return false;
	}
	
	@Override
	public String getLastReadEntryId() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(FILENAME));
			if (prop.containsKey(PROPERTY)) {
				return (prop.getProperty(PROPERTY));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
