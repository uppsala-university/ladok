package se.sunet.ati.ladok.atom.dto.util;

import java.io.ByteArrayInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.reflections.Reflections;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import se.sunet.ati.ladok.atom.dto.Handelse;

public class XmlDeserializer  {

	static Log log = LogFactory.getLog(XmlDeserializer.class);

    public static Map<String, Class<? extends Handelse>> typeToEvent = new HashMap<String, Class<? extends Handelse>>();
    static {
    	Reflections r = new Reflections(Handelse.class.getPackage().getName());
    	Set<Class<? extends Handelse>> handelser = r.getSubTypesOf(Handelse.class);
    	for (Class<? extends Handelse> handelse : handelser) {
    		if (!Modifier.isAbstract(handelse.getModifiers())) {
        		registerEvent(handelse);
    		}
		}
    }
    
    private static void registerEvent(Class<? extends Handelse> c) {
    	Annotation[] annotations = c.getAnnotations();
    	for (Annotation annotation : annotations) {
			if (annotation instanceof XmlRootElement) {
				XmlRootElement xre = (XmlRootElement) annotation;
				String type = xre.namespace() + "/" + xre.name();
				typeToEvent.put(type, c);
				log.info("Registered event DTO class " + c.getName() + " with type " + type);
				return;
			}
		}
    	log.warn("Failed to register event DTO class " + c.getName());
    	// throw new RuntimeException("No name XmlRootElemnt annotation found on " + c.getName());
    }

    public static Handelse deserialize(String xmlContent) throws Exception {
    	String eventType = getEventType(xmlContent);
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
    
    public static String getEventType(String xmlContent)  {
    	String eventType = null;
        try {
			DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
			domFactory.setNamespaceAware(true);
			DocumentBuilder builder = domFactory.newDocumentBuilder();
			Document doc = builder.parse(new ByteArrayInputStream(xmlContent.getBytes(StandardCharsets.UTF_8)));
			Element root = doc.getDocumentElement();
			String namespaceURI = root.getNamespaceURI();
			String localName = root.getLocalName();
			eventType = namespaceURI + "/" + localName;
		} catch (Exception e) {
		}
        return eventType;
    }
}
