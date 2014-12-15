package se.sunet.ati.ladok.atom.dto.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "link", namespace = "http://schemas.ladok.se")
public class Link implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    String method;
    String uri;
    String mediaType;
    String rel;
    
    @XmlElement(name = "method", namespace = "http://schemas.ladok.se")
    public String getMethod() {
        return method;
    }
    
    public void setMethod(String method) {
        this.method = method;
    }
    
    @XmlElement(name = "uri", namespace = "http://schemas.ladok.se")
    public String getUri() {
        return uri;
    }
    
    public void setUri(String uri) {
        this.uri = uri;
    }
    
    @XmlElement(name = "mediaType", namespace = "http://schemas.ladok.se")
    public String getMediaType() {
        return mediaType;
    }
    
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
    
    @XmlElement(name = "rel", namespace = "http://schemas.ladok.se")
    public String getRel() {
        return rel;
    }
    
    public void setRel(String rel) {
        this.rel = rel;
    }
    
    @Override
    public String toString() {
        return "Link [method=" + method + ", uri=" + uri + ", mediaType="
                + mediaType + ", rel=" + rel + "]";
    }
}
