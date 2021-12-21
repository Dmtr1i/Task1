package CSVWorker;
import Contracts.*;
import Person.*;
import Repository.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class CSVWorker {

    public CSVWorker(FileReader read) {
        try {
            CSVReader reader = new CSVReader(read);
            String[] text;
            while ((text = reader.readNext()) != null) {
                for (int i = 0; i < text.length; i++) System.out.println(text[i]);
            }
        } catch (CsvValidationException ex) {
            System.out.println("Something wrong: " + ex);
        } catch (IOException ex) {
            System.out.println("Something wrong: " + ex);
        }
    }
}
