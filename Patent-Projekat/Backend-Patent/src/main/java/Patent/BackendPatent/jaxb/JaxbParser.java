package Patent.BackendPatent.jaxb;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

@Component
public class JaxbParser {

    public String insertString(
            String originalString,
            String stringToBeInserted,
            int index)
    {

        // Create a new string
        String newString = new String();

        for (int i = 0; i < originalString.length(); i++) {

            // Insert the original string character
            // into the new string
            newString += originalString.charAt(i);

            if (i == index) {

                // Insert the string to be inserted
                // into the new string
                newString += stringToBeInserted;
            }
        }

        // return the modified String
        return newString;
    }
    public <T> T unmarshall(Class genericClass, String text) throws JAXBException {
        text = insertString(text," xmlns=\"http://www.ftn.uns.rs/P-1\" ",118);
        JAXBContext context = JAXBContext.newInstance(genericClass);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        T createdObject = (T) unmarshaller.unmarshal(new StringReader(text));
        return createdObject;
    }

    public <T> T unmarshallFile(Class genericClass, String path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(genericClass);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        T createdObject = (T) unmarshaller.unmarshal(new File(path));
        return createdObject;
    }

    public <T> void marshallFile(Class genericClass,T objectToMarshall, String path) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(genericClass);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(objectToMarshall, System.out);
        marshaller.marshal(objectToMarshall, new FileOutputStream(new File(path)));
    }

    public <T> String marshallString(Class genericClass,T objecToMarshall) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(genericClass);
        Marshaller marshaller = context.createMarshaller();
        StringWriter sw = new StringWriter();
        marshaller.marshal(objecToMarshall, sw);
        return sw.toString();
    }
}
