package JDBC;

import Contracts.Contract;
import Contracts.InternetContract;
import Contracts.MobileContract;
import Contracts.TelevisionContract;
import Person.Person;
import Repository.Repository;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class JDBCWorkerTest {

    @Test
    public void writeRepo() throws SQLException {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        String[] channel = {"Первый", "Второй", "Третий"};
        List<String> channel1 = Arrays.stream(channel).toList();
        String[] channel2 = {"Четвертый", "Пятый", "Шестой", "Седьмой", "Восьмой"};
        List<String> channel3 = Arrays.stream(channel2).toList();
        InternetContract contract = new InternetContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 12);
        InternetContract contract2 = new InternetContract(2, LocalDate.of(2021, 10, 6), LocalDate.of(2021, 11, 6), 456, person, 16);
        MobileContract contract3 = new MobileContract(3, LocalDate.of(2021, 8, 23), LocalDate.of(2021, 9, 23), 235, person, 600, 20, 30);
        MobileContract contract4 = new MobileContract(4, LocalDate.of(2021, 10, 23), LocalDate.of(2021, 11, 23), 258, person, 500, 200, 10);
        TelevisionContract contract5 = new TelevisionContract(5, LocalDate.of(2021, 4, 23), LocalDate.of(2021, 10, 23), 666, person, channel1);
        TelevisionContract contract6 = new TelevisionContract(6, LocalDate.of(2021, 11, 24), LocalDate.of(2022, 4, 24), 999, person, channel3);
        Repository<Contract> data = new Repository<>();
        data.add(contract);
        data.add(contract2);
        data.add(contract3);
        data.add(contract4);
        data.add(contract5);
        data.add(contract6);
        JDBCWorker worker = new JDBCWorker(JDBCWorker.connectionUrl, JDBCWorker.user, JDBCWorker.password);
        worker.writeRepo(data);
    }

    @Test
    public void readRepo() throws SQLException {
        JDBCWorker worker = new JDBCWorker(JDBCWorker.connectionUrl, JDBCWorker.user, JDBCWorker.password);
        Repository<Contract> data2 = worker.readRepo();
        System.out.println(data2.toString());
    }

    @Test
    public void personExist() throws SQLException {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        JDBCWorker worker = new JDBCWorker(JDBCWorker.connectionUrl, JDBCWorker.user, JDBCWorker.password);
        worker.personExist(person.getId());
    }

    @Test
    public void clearRepo() throws SQLException {
        JDBCWorker worker = new JDBCWorker(JDBCWorker.connectionUrl, JDBCWorker.user, JDBCWorker.password);
        worker.clearRepo();
    }
}