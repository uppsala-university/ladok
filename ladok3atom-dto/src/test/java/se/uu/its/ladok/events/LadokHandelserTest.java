package se.uu.its.ladok.events;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import se.sunet.ati.ladok.atom.dto.common.Handelse;
import se.sunet.ati.ladok.atom.dto.studiedeltagande.ForstagangsregistreringsHandelse;
import se.sunet.ati.ladok.atom.dto.util.XmlUnmarshaller;

public class LadokHandelserTest {
    
    @Test
    public void test() throws Exception {
        String xml = 
                "<sd:ForstagangsregistreringHandelse" + 
                "    xmlns:sd=\"http://schemas.ladok.se/studiedeltagande\"" + 
                "    xmlns:base=\"http://schemas.ladok.se\"" + 
                "    xmlns:dap=\"http://schemas.ladok.se/dap\">" + 
                "<base:EventContext>" + 
                "    <base:LarosateID>52</base:LarosateID>" + 
                "</base:EventContext>" + 
                "<base:Handelsetid>2013-11-11T01:18:02.797</base:Handelsetid>" + 
                "<base:HandelseUID>ab4a581c-bb73-4df3-81df-bc50fb72c307</base:HandelseUID>" + 
                "<base:Lankar>" +
                "    <base:link>" +
                "        <base:rel>http://relations.ladok.se/student</base:rel>" + 
                "        <base:method>GET</base:method>" + 
                "        <base:uri>http://api.ladok.se/studentinformation/student/6090c950-c90e-4208-9992-ea189f7ba225</base:uri>" + 
                "        <base:mediaType>application/vnd.ladok+xml</base:mediaType>" + 
                "    </base:link>" +
                "    <base:link>" +
                "        <base:rel>http://relations.ladok.se/student</base:rel>" + 
                "        <base:method>GET</base:method>" + 
                "        <base:uri>http://api.ladok.se/studentinformation/student/6090c950-c90e-4208-9992-ea189f7ba226</base:uri>" + 
                "        <base:mediaType>application/vnd.ladok+xml</base:mediaType>" + 
                "    </base:link>" +
                "</base:Lankar>" +
                "<sd:KurstillfalleUID>d250bf25-f78b-4dc6-8d19-31411716f584</sd:KurstillfalleUID>" + 
                "<sd:Period>1</sd:Period>" + 
                "<sd:StudentUID>f590ab8f-5b38-4a4b-a23e-13d0c77950a7</sd:StudentUID>" + 
                "<sd:TillfallesdeltagandeUID>c7fe9d98-3c85-4e5d-9a8b-34d6b64bba3b</sd:TillfallesdeltagandeUID>" + 
                "</sd:ForstagangsregistreringHandelse>";
        Handelse handelse = XmlUnmarshaller.unmarshal(
        		ForstagangsregistreringsHandelse.TYPE, xml);
        assertNotNull(handelse);
        System.out.println("\n" + handelse.toString());
    }
}
