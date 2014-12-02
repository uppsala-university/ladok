package se.sunet.ati.ladok.atom;

import java.util.List;

import org.apache.abdera.model.Entry;
import org.junit.Test;

import se.sunet.ati.ladok.atom.AtomClient;

public class AtomClientTest {
	
	@Test
	public void testAtomClient() throws Exception {
		AtomClient ac = new AtomClient();
		
//		List<Entry> entries = ac.getEntries("1", "f95da4a8-c6e7-434c-b2a0-33d6d5ab978a");
		List<Entry> entries = ac.getEntries(null);
		
		if (entries != null) {
			System.out.println("Found " + entries.size() + " entries");
			for(Entry e : entries) {
				System.out.println(e.getId() + ", baseuri: " + e.getBaseUri());
			}
		} else {
			System.out.println("No entries found.");
		}
	}

}
