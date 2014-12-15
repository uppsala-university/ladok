package se.sunet.ati.ladok.atom.dto.util;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;

import se.sunet.ati.ladok.atom.dto.studiedeltagande.ForstagangsregistreringsHandelse;
import se.sunet.ati.ladok.atom.dto.utbildningsinformation.KursTillStatus3Handelse;
import se.sunet.ati.ladok.atom.dto.common.Handelse;

public class XmlUnmarshaller  {
    
    public static Map<String, Class<? extends Handelse>> typeToEvent = new HashMap<String, Class<? extends Handelse>>();

    static {
        typeToEvent.put(KursTillStatus3Handelse.TYPE, KursTillStatus3Handelse.class);
        typeToEvent.put(ForstagangsregistreringsHandelse.TYPE, ForstagangsregistreringsHandelse.class);
        typeToEvent.put(ForstagangsregistreringsHandelse.TYPE, ForstagangsregistreringsHandelse.class);
    }

    public static Handelse unmarshal(String eventType, String xmlContent) throws Exception {
        if (typeToEvent.containsKey(eventType)) {
            Handelse h = (Handelse) JAXBContext
                    .newInstance(typeToEvent.get(eventType))
                    .createUnmarshaller()
                    .unmarshal(new ByteArrayInputStream(xmlContent.getBytes("UTF-8")));
            return h;
        } else {
            return null;
        }
    }
}
