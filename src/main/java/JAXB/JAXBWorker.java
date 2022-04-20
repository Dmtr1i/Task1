package JAXB;

import Contracts.Contract;
import Repository.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JAXBWorker<T extends Contract>{

    public void write(Repository<T> repository, String fileName) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Repository.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(repository, new File("./"+fileName+".xml"));
    }

    public Repository<T> read(String fileName) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Repository.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Repository<T>) context.createUnmarshaller().unmarshal(new FileReader("./"+fileName+".xml"));
    }
}
