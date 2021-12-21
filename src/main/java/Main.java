import CSVWorker.CSVWorker;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            CSVWorker a = new CSVWorker(new FileReader("D:\\test.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("Something wrong: " + ex);
        }
    }
}
