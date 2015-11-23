package se.sunet.ati.ladok.atom;

import java.util.List;

import org.apache.abdera.model.Entry;
import org.junit.Test;

public class AtomClientTest {
	
	@Test
	public void testAtomClientGetAllEntriesFromStart() throws Exception {
		AtomClient ac = new AtomClient();
		
		List<Entry> entries = ac.getEntries(null);
		
		if (entries != null) {
			System.out.println("Found " + entries.size() + " entries");
			for (Entry e : entries) {
				System.out.println("entryid: " + e.getId() + ", baseuri: " + e.getBaseUri());
			}
		} else {
			System.out.println("No entries found.");
		}
	}

}
