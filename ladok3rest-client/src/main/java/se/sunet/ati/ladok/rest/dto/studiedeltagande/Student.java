package se.sunet.ati.ladok.rest.dto.studiedeltagande;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Student", namespace = "http://schemas.ladok.se")
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "Uid", namespace = "http://schemas.ladok.se")
	String uid;
	
	@XmlElement(name = "Personnummer", namespace = "http://schemas.ladok.se") 
	String personnummer;

	@XmlElement(name = "Fornamn", namespace = "http://schemas.ladok.se") 	
	String fornamn;

	@XmlElement(name = "Efternamn", namespace = "http://schemas.ladok.se") 
	String efternamn;
		
	@XmlElement(name = "link", namespace = "http://schemas.ladok.se/dap")  
	List<Link> links;


//	@XmlElement(name = "Uid", namespace = "http://schemas.ladok.se")
//	public void setUid(String uid) {
//		this.uid = uid;
//	}
//	
//	public String getUid() {
//		return uid;
//	}

//	@XmlElement(name = "Personnummer", namespace = "http://schemas.ladok.se") 
//	public String getPersonnummer() {
//		return personnummer;
//	}
//
//	public void setPersonnummer(String personnummer) {
//		this.personnummer = personnummer;
//	}

//	@XmlElement(name = "Fornamn", namespace = "http://schemas.ladok.se") 	
//	public String getFornamn() {
//		return fornamn;
//	}
//
//	public void setFornamn(String fornamn) {
//		this.fornamn = fornamn;
//	}

//	@XmlElement(name = "Efternamn", namespace = "http://schemas.ladok.se") 
//	public String getEfternamn() {
//		return efternamn;
//	}
//
//	public void setEfternamn(String efternamn) {
//		this.efternamn = efternamn;
//	}

//	@XmlElement(name = "link", namespace = "http://schemas.ladok.se/dap") 
//	public List<Link> getLink() {
//		return links;
//	}
//
//	public void setLink(List<Link> links) {
//		this.links = links;
//	}


//	public List<Link> getLink() {
//		return links;
//	}

//	@XmlElement(name = "link", namespace = "http://schemas.ladok.se/dap")  
//	public void setLink(List<Link> links) {
//		System.out.println("No of links: " + links.size());
//		this.links = links;
//	}	
//	
//	public List<Link> getLink() {
//		return links;
//	}
	
	@Override
	public String toString() {
		return "Student [uid=" + uid + ", personnummer=" + personnummer
				+ ", fornamn=" + fornamn + ", efternamn=" + efternamn
				+ ", links=" + links + "]";
	}
}
