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
        try {
            CSVWriter writer = new CSVWriter(file);
            T temp;
            String[] data;
            for (int i = 0; i < repo.getSize(); i++) {
                temp = repo.getByIndex(i);
                data = temp.toString().split(",");
                String[] data2 = new String[data.length + 1];
                data2[0] = temp.getClass().getSimpleName();
                for (int j = 0; j < data.length; j++) data2[j + 1] = data[j];
                writer.writeNext(data2);
            }
            writer.close();
        } catch(IOException ex) {
            System.out.println("Error: " + ex);
        }
    }
}
