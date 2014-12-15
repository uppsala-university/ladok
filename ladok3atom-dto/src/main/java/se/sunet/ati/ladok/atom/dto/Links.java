package se.sunet.ati.ladok.atom.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Lankar", namespace = "http://schemas.ladok.se")
public class Links implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    List<Link> links;
    
    @XmlElement(name = "link", namespace = "http://schemas.ladok.se")
    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "Links [links=" + links + "]";
    }

}
