package se.sunet.ati.ladok.rest.dto.studiedeltagande;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="Uid") 
	String uid;
	
	@XmlElement(name="Personnummer") 
	String personnummer;
	
	@XmlElement(name="Fornamn") 
	String fornamn;
	
	@XmlElement(name="Efternamn") 
	String efternamn;
	
	@XmlElement(name="link") 
	List<Link> links;
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPersonnummer() {
		return personnummer;
	}

	public void setPersonnummer(String personnummer) {
		this.personnummer = personnummer;
	}

	public String getFornamn() {
		return fornamn;
	}

	public void setFornamn(String fornamn) {
		this.fornamn = fornamn;
	}

	public String getEfternamn() {
		return efternamn;
	}

	public void setEfternamn(String efternamn) {
		this.efternamn = efternamn;
	}

	public List<Link> getLink() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return "Student [uid=" + uid + ", personnummer=" + personnummer
				+ ", fornamn=" + fornamn + ", efternamn=" + efternamn
				+ ", links=" + links + "]";
	}
}
