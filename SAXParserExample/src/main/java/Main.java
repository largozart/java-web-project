import Doctors.Doctors;
import com.sun.xml.internal.ws.developer.SerializationFeature;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.StringWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author vsasaeva
 */
public class Main {

    public static void main(String args[]) {
        String dir = "/home/valeria/IdeaProjects/SAXParserExample";
        File file = new File(dir, "file.xml");
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAXPars saxp = new SAXPars();

            parser.parse(file, saxp);

            Doctors doc = saxp.getResult();
            //писать результат сериализации будем во Writer(StringWriter)
            StringWriter writer = new StringWriter();

            //это объект Jackson, который выполняет сериализацию
            ObjectMapper mapper = new ObjectMapper();

            // сама сериализация: 1-куда, 2-что
            mapper.writeValue(writer, doc);

            //преобразовываем все записанное во StringWriter в строку
            String result = writer.toString();
            System.out.println(result);

        } catch (Exception e) {
            System.out.println("failed parsing");
        }
    }
}
