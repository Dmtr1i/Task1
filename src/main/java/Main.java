import CSVWorker.CSVWorker;
import Contracts.TelevisionContract;
import Person.Person;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            CSVWorker a = new CSVWorker();
            a.readFile(new FileReader("D:\\test.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("Something wrong: " + ex);
        }
    }
}
