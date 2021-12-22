package CSVWorker;
import Contracts.*;
import Person.*;
import Repository.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Predicate;

public class CSVWorker <T extends Contract> {

    public CSVWorker() {
    }

    public void readFile(FileReader file) {
        if (file == null) {
            System.out.println("No file selected");
            return;
        }
        try {
            CSVReader reader = new CSVReader(file);
            String[] data;
            while ((data = reader.readNext()) != null) {
                for (int i = 0; i < data.length; i++) System.out.print(data[i]);
                System.out.println();
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        } catch (CsvValidationException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void writeFile (FileWriter file, Repository<T> repo) {
        if (file == null) {
            System.out.println("No file selected");
            return;
        }
        /*try {
            CSVWriter writer = new CSVWriter(file);

        }*/
    }
}


/*
        try {
            CSVReader reader = new CSVReader(read);
            String[] text;
            while ((text = reader.readNext()) != null) {
                for (int i = 0; i < text.length; i++) System.out.print(text[i]);
                System.out.println();
            }
        } catch (CsvValidationException ex) {
            System.out.println("Something wrong: " + ex);
        } catch (IOException ex) {
            System.out.println("Something wrong: " + ex);
        }
         */