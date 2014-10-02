package se.uu.its.ladok.atom.test;

import java.util.List;

import org.apache.abdera.model.Entry;
import org.junit.Test;

import se.sunet.ati.ladok.atom.EventUtils;
import se.sunet.ati.ladok.atom.AtomClient;

public class AtomClientTest {
	
	@Test
	public void testFetcher() throws Exception {
		AtomClient f1 = new AtomClient();	
		List<Entry> entries = f1.getEntries(0, 43);
		System.out.println("Found " + entries.size() + " entries");
		for(Entry e : entries) {
			System.out.println(e.getId());
		}
	}

}
