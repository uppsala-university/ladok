package se.sunet.ati.ladok.rest.dto.utbildningsinformation;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import se.sunet.ati.ladok.rest.dto.studiedeltagande.Link;

@XmlRootElement(name = "Utbildningstillfalle", namespace = "http://schemas.ladok.se/utbildningsinformation")
public class Utbildningstillfalle implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "Uid", namespace = "http://schemas.ladok.se")
	String uid;
	
	@XmlElement(name = "link", namespace = "http://schemas.ladok.se/dap")  
	List<Link> links;	
	
	@XmlElement(name = "Tillfalleskod", namespace = "http://schemas.ladok.se")
	String tillfalleskod;

	public String getUid() {
		return uid;
	}
	
	public String gerTillfalleskod() {
		return tillfalleskod;
	}
}
