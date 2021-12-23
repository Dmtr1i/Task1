package CSVWorkerTest;
import CSVWorker.CSVWorker;

import Contracts.Contract;
import Contracts.InternetContract;
import Contracts.MobileContract;
import Contracts.TelevisionContract;
import Person.Person;
import Repository.Repository;
import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CSVWorkerTest {
    @Test
    public void CSVWorker() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        InternetContract contract = new InternetContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 12);
        InternetContract contract2 = new InternetContract(2, LocalDate.of(2021, 10, 6), LocalDate.of(2021, 11, 6), 456, person, 16);
        MobileContract contract3 = new MobileContract(3, LocalDate.of(2021, 8, 23), LocalDate.of(2021, 9, 23), 235, person, 600, 20, 30);
        MobileContract contract4 = new MobileContract(4, LocalDate.of(2021, 10, 23), LocalDate.of(2021, 11, 23), 258, person, 500, 200, 10);
        String[] channel = {"Первый", "Второй", "Третий"};
        List<String> channel1 = Arrays.stream(channel).toList();
        TelevisionContract contract5 = new TelevisionContract(5, LocalDate.of(2021, 4, 23), LocalDate.of(2021, 10, 23), 666, person, channel1);
        String[] channel2 = {"Четвертый", "Пятый", "Шестой", "Седьмой", "Восьмой"};
        List<String> channel3 = Arrays.stream(channel2).toList();
        TelevisionContract contract6 = new TelevisionContract(6, LocalDate.of(2021, 11, 24), LocalDate.of(2022, 4, 24), 999, person, channel3);
        Repository<Contract> data = new Repository<>();
        data.add(contract);
        data.add(contract2);
        data.add(contract3);
        data.add(contract4);
        data.add(contract5);
        data.add(contract6);
        try {
            FileWriter file = new FileWriter("D:\\test.txt");
            CSVWorker me = new CSVWorker();
            me.writeFile(file, data);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        Repository<Contract> repo = new Repository<Contract>();
        try {
            FileReader file = new FileReader("D:\\test.txt");
            CSVWorker me = new CSVWorker();
            repo = me.readFile(file, repo);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        assertEquals(repo.getByIndex(0).toString(), data.getByIndex(0).toString());
        assertEquals(repo.getByIndex(1).toString(), data.getByIndex(1).toString());
        assertEquals(repo.getByIndex(2).toString(), data.getByIndex(2).toString());
        assertEquals(repo.getByIndex(3).toString(), data.getByIndex(3).toString());
        assertEquals(repo.getByIndex(4).toString(), data.getByIndex(4).toString());
        assertEquals(repo.getByIndex(5).toString(), data.getByIndex(5).toString());
    }
}
