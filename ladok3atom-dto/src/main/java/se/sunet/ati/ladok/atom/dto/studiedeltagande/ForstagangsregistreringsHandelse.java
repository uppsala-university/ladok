package se.sunet.ati.ladok.atom.dto.studiedeltagande;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ForstagangsregistreringHandelse", namespace = "http://schemas.ladok.se/studiedeltagande")
public class ForstagangsregistreringsHandelse extends StudiedeltagandeHandelse {
    
    String period;
    String tillfallesdeltagandeUid;
    String kurstillfalleUid;
    String studentUid;

    @XmlElement(name = "TillfallesdeltagandeUID", namespace = "http://schemas.ladok.se/studiedeltagande")
    public String getTillfallesdeltagandeUid() {
        return tillfallesdeltagandeUid;
    }

    public void setTillfallesdeltagandeUid(String tillfallesdeltagandeUid) {
        this.tillfallesdeltagandeUid = tillfallesdeltagandeUid;
    }

    @XmlElement(name = "StudentUID", namespace = "http://schemas.ladok.se/studiedeltagande")
    public String getStudentUid() {
        return studentUid;
    }

    public void setStudentUid(String studentUid) {
        this.studentUid = studentUid;
    }

    @XmlElement(name = "KurstillfalleUID", namespace = "http://schemas.ladok.se/studiedeltagande")
    public String getKurstillfalleUid() {
        return kurstillfalleUid;
    }

    public void setKurstillfalleUid(String kurstillfalleUid) {
        this.kurstillfalleUid = kurstillfalleUid;
    }

    @XmlElement(name = "Period", namespace = "http://schemas.ladok.se/studiedeltagande")
    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

	@Override
	public String toString() {
		return "ForstagangsregistreringsHandelse [period=" + period
				+ ", tillfallesdeltagandeUid=" + tillfallesdeltagandeUid
				+ ", kurstillfalleUid=" + kurstillfalleUid + ", studentUid="
				+ studentUid + ", handelseUid=" + getHandelseUid()
				+ ", handelseTid=" + getHandelseTid() + ", links=" + getLinks() + "]";
	}
    
}
