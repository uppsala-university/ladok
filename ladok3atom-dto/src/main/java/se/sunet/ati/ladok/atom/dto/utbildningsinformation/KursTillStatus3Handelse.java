package se.sunet.ati.ladok.atom.dto.utbildningsinformation;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "KursTillStatus3Handelse", namespace = "http://schemas.ladok.se/utbildningsinformation")
public class KursTillStatus3Handelse extends UtbildningsinformationsHandelse {
	
	public static String TYPE = "http://schemas.ladok.se/utbildningsinformation/KursTillStatus3Handelse";
	
	String handelseUID;
	String kurskod;
	
	@XmlElement(name = "HandelseUID", namespace = "http://schemas.ladok.se")
	public String getHandelseUID() {
		return handelseUID;
	}
	
	public void setHandelseUID(String handelseUID) {
		this.handelseUID = handelseUID;
	}
	
	@XmlElement(name = "Kurskod", namespace = "http://schemas.ladok.se/utbildningsinformation")
	public String getKurskod() {
		return kurskod;
	}
	
	public void setKurskod(String kurskod) {
		this.kurskod = kurskod;
	}

	@Override
	public String toString() {
		return "KursTillStatus3Handelse [getHandelseUID()=" + getHandelseUID()
				+ ", getKurskod()=" + getKurskod() + ", toString()="
				+ super.toString() + ", getLinks()=" + getLinks()
				+ ", getHandelseUid()=" + getHandelseUid()
				+ ", getHandelseTid()=" + getHandelseTid() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
