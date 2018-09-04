import Doctors.Doctors;
import org.xml.sax.helpers.DefaultHandler;

import org.xml.sax.*;

/**
 * @author vsasaeva
 */
public class SAXPars extends DefaultHandler {

    Doctors doc = new Doctors();
    String thisElement = "";


    public Doctors getResult(){
        return doc;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("id")) {
            doc.setId(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("fam")) {
            doc.setFam(new String(ch, start, length));
        }
        if (thisElement.equals("name")) {
            doc.setName(new String(ch, start, length));
        }
        if (thisElement.equals("otc")) {
            doc.setOtc(new String(ch, start, length));
        }
        if (thisElement.equals("dateb")) {
            doc.setDateb(new String(ch, start, length));
        }
        if (thisElement.equals("datep")) {
            doc.setDatep(new String(ch, start, length));
        }
        if (thisElement.equals("datev")) {
            doc.setDatev(new String(ch, start, length));
        }
        if (thisElement.equals("datebegin")) {
            doc.setDatebegin(new String(ch, start, length));
        }
        if (thisElement.equals("dateend")) {
            doc.setDateend(new String(ch, start, length));
        }
        if (thisElement.equals("vdolid")) {
            doc.setVdolid(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("specid")) {
            doc.setSpecid(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("klavid")) {
            doc.setKlavid(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("stav")) {
            doc.setStav(new Float(new String(ch, start, length)));
        }
        if (thisElement.equals("progid")) {
            doc.setProgid(new Integer(new String(ch, start, length)));
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void endDocument() {
        getResult();
        System.out.println("Stop parse XML...");
    }
}
