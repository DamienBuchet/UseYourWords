package com.init.use_your_words2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UseYourWords2Application {

	public static void main(String[] args) {
		SpringApplication.run(UseYourWords2Application.class, args);
		createFile();
	}
	
	
    public static void jaxbObjectToXML(Joueur obj) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Joueur.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(obj, sw);
            String xmlContent = sw.toString();
            writeFile(xmlContent);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String str) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Temp\\leaderboard.xml", true));
            out.write(str);
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile() {
        BufferedWriter out;
        try {
            out = new BufferedWriter(new FileWriter("C:\\Temp\\leaderboard.xml"));
            try {
                out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                out.close();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
