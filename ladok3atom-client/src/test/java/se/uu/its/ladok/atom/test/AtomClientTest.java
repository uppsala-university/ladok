package se.uu.its.ladok.atom.test;

import java.util.List;

import org.apache.abdera.model.Entry;
import org.junit.Test;

import se.sunet.ati.ladok.atom.EventUtils;
import se.sunet.ati.ladok.atom.AtomClient;

public class AtomClientTest {
	
	@Test
	public void testAtomClient() throws Exception {
		AtomClient ac = new AtomClient();
		
		// Hmm. här måste vi skicka in URI till senast hämtade
		// Innebär det att vi sen hämtar alla därifrån å framåt eller vill vi kunna ange hur många?
		// När vi sen hittar rätt feed så måst vi hitta vårt senaste lästa entry å fortsätta därifrån
		
		List<Entry> entries = ac.getEntries(0, 43);
		
		if (entries != null) {
			System.out.println("Found " + entries.size() + " entries");
			for(Entry e : entries) {
				System.out.println(e.getId());
			}
		} else {
			System.out.println("No entries found.");
		}
	}

}
