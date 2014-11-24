package se.sunet.ati.ladok.rest.dto.studiedeltagande;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name = "link", namespace = "http://schemas.ladok.se/dap")
public class Link implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name = "method", namespace = "http://schemas.ladok.se/dap")
	String method;

	@XmlAttribute(name = "uri", namespace = "http://schemas.ladok.se/dap")
	String uri;

	@XmlAttribute(name = "mediaType", namespace = "http://schemas.ladok.se/dap")
	String mediaType;

	@XmlAttribute(name = "rel", namespace = "http://schemas.ladok.se/dap")
	String rel;
	
//	@XmlAttribute(name = "method", namespace = "http://schemas.ladok.se/dap")
//	public String getMethod() {
//		return method;
//	}
//	
//	public void setMethod(String method) {
//		this.method = method;
//	}
	
//	@XmlAttribute(name = "uri", namespace = "http://schemas.ladok.se/dap")
//	public String getUri() {
//		return uri;
//	}
//	
//	public void setUri(String uri) {
//		this.uri = uri;
//	}
	
//	@XmlAttribute(name = "mediaType", namespace = "http://schemas.ladok.se/dap")
//	public String getMediaType() {
//		return mediaType;
//	}
//	
//	public void setMediaType(String mediaType) {
//		this.mediaType = mediaType;
//	}
	
//	@XmlAttribute(name = "rel", namespace = "http://schemas.ladok.se/dap")
//	public String getRel() {
//		return rel;
//	}
//	
//	public void setRel(String rel) {
//		this.rel = rel;
//	}
	
	@Override
	public String toString() {
		return "Link [method=" + method + ", uri=" + uri + ", mediaType="
				+ mediaType + ", rel=" + rel + "]";
	}
}
