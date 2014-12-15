package se.sunet.ati.ladok.atom.dto.common;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class Handelse {

    String handelseUid;
    Date handelseTid;
    Links links;
    
    @XmlElement(name = "Lankar", namespace = "http://schemas.ladok.se")
    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    @XmlElement(name = "HandelseUID", namespace = "http://schemas.ladok.se")
    public String getHandelseUid() {
        return handelseUid;
    }

    public void setHandelseUid(String handelseUid) {
        this.handelseUid = handelseUid;
    }

    @XmlElement(name = "Handelsetid", namespace = "http://schemas.ladok.se")
    public Date getHandelseTid() {
        return handelseTid;
    }

    public void setHandelseTid(Date handelseTid) {
        this.handelseTid = handelseTid;
    }

	@Override
	public String toString() {
		return "Handelse [handelseUid=" + handelseUid + ", handelseTid="
				+ handelseTid + ", links=" + links + "]";
	}
}
