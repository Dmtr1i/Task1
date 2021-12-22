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
import java.time.LocalDate;
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
                if (data[0].contains("InternetContract")) {
                    //Person owner;
                    int ownerId = Integer.parseInt(data[5].replaceAll("\\s", ""));
                    String ownerName = data[6].replaceAll("^\\s", "");
                    String dateTemp = data[7].replaceAll("\\s", "");
                    String[] dateTemp2 = dateTemp.split("\\.");
                    int ownerBirthDateDay = Integer.parseInt(dateTemp2[0].replaceAll("\\s", ""));
                    int ownerBirthDateMonth = Integer.parseInt(dateTemp2[1].replaceAll("\\s", ""));
                    int ownerBirthDateYear = Integer.parseInt(dateTemp2[2].replaceAll("\\s", ""));
                    String ownerGender = data[8].replaceAll("\\s", "");
                    int ownerPasSeries = Integer.parseInt(data[9].replaceAll("\\s", ""));
                    int ownerPasNumber = Integer.parseInt(data[10].replaceAll("\\s", ""));
                    Person me = new Person(ownerId, ownerName, LocalDate.of(ownerBirthDateYear, ownerBirthDateMonth, ownerBirthDateDay), ownerGender, ownerPasNumber, ownerPasSeries);
                    System.out.println(me.toString());
                }
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
                data2[1] = data[0].format("\s%s", data[0]);
                for (int j = 1; j < data.length; j++) data2[j + 1] = data[j];
                writer.writeNext(data2);
            }
            writer.close();
        } catch(IOException ex) {
            System.out.println("Error: " + ex);
        }
    }
}
