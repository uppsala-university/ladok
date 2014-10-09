package se.sunet.ati.ladok.rest.dto.studiedeltagande;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Student", namespace = "http://schemas.ladok.se")
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String uid;
	String personnummer;
	String fornamn;
	String efternamn;
	List<Link> links;

	@XmlElement(name = "Uid", namespace = "http://schemas.ladok.se")
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String getUid() {
		return uid;
	}

	@XmlElement(name = "Personnummer", namespace = "http://schemas.ladok.se") 
	public String getPersonnummer() {
		return personnummer;
	}

	public void setPersonnummer(String personnummer) {
		this.personnummer = personnummer;
	}

	@XmlElement(name = "Fornamn", namespace = "http://schemas.ladok.se") 	
	public String getFornamn() {
		return fornamn;
	}

	public void setFornamn(String fornamn) {
		this.fornamn = fornamn;
	}

	@XmlElement(name = "Efternamn", namespace = "http://schemas.ladok.se") 
	public String getEfternamn() {
		return efternamn;
	}

	public void setEfternamn(String efternamn) {
		this.efternamn = efternamn;
	}

	@XmlElement(name = "link", namespace = "http://schemas.ladok.se") 
	public List<Link> getLink() {
		return links;
	}

	public void setLink(List<Link> links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return "Student [uid=" + uid + ", personnummer=" + personnummer
				+ ", fornamn=" + fornamn + ", efternamn=" + efternamn
				+ ", links=" + links + "]";
	}
}
