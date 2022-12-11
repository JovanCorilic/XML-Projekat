package Parser;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import Patent.P1;

public class Patent_Ucitavanje_I_Ispis {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Ucitavanje_I_Ispis("P-1-1");
		Ucitavanje_I_Ispis("P-1-2");
	}
	
	public static void Ucitavanje_I_Ispis(String text) throws Exception {
		try {
			System.out.println("[INFO] "+text+"\n");
			JAXBContext context = JAXBContext.newInstance("Patent");
			Unmarshaller unmarshaller = context.createUnmarshaller();
			P1 p1 = (P1)unmarshaller.unmarshal(new File("./data/"+text+".xml"));
			
			System.out.println("Uspešno učitan! \n");
			
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(p1, System.out);
			marshaller.marshal(p1, new FileOutputStream(new File("./data/marshal/"+text+".xml")));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	

}
