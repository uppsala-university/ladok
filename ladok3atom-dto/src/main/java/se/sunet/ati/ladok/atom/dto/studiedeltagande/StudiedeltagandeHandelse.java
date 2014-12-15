package se.sunet.ati.ladok.atom.dto.studiedeltagande;

import se.sunet.ati.ladok.atom.dto.Handelse;

public abstract class StudiedeltagandeHandelse extends Handelse {

	@Override
	public String toString() {
		return "StudiedeltagandeHandelse [handelseUid=" + getHandelseUid()
				+ ", handelseTid=" + getHandelseTid() + ", links=" + getLinks() + "]";
	}

	
	
}
