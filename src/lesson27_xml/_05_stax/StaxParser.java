package lesson27_xml._05_stax;

import lesson27_xml._02_base_xml.XmlCat;

import javax.net.ssl.X509KeyManager;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StaxParser {
    public static List<XmlCat> parseXml() {
        var cats = new ArrayList<XmlCat>();
        try {
            var factory = XMLInputFactory.newInstance();
            var schemaReader = factory
                    .createXMLStreamReader(new FileReader("src/lesson27_xml/_05_stax/cats.xml"));
            XmlCat cat = null;
            while (schemaReader.hasNext()) {
                schemaReader.next();
                if (schemaReader.getEventType() == XMLStreamConstants.START_ELEMENT) {
                    if (schemaReader.getLocalName().equalsIgnoreCase("cat")) {
                        cat = new XmlCat();
                        if (schemaReader.getAttributeCount() > 0) {
                            var id = schemaReader.getAttributeValue(null, "id");
                            cat.setId(Integer.parseInt(id));
                        }
                    }
                    if (schemaReader.getLocalName().equalsIgnoreCase("name")) {
                        cat.setName(schemaReader.getElementText());
                    }
                    if (schemaReader.getLocalName().equalsIgnoreCase("age")) {
                        cat.setAge(Integer.parseInt(schemaReader.getElementText()));
                    }
                }
                if (schemaReader.getEventType() == XMLStreamConstants.END_ELEMENT) {
                    if (schemaReader.getLocalName().equalsIgnoreCase("cat")) {
                        cats.add(cat);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return cats;
    }
}
