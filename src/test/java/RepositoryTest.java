import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class RepositoryTest {

    @Test
    public void add() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        InternetContract contract = new InternetContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 12);
        Repository data = new Repository();
        data.add(contract);
        int actualSize = data.getSize();
        int expectedSize = 1;
        assertEquals(actualSize, expectedSize);
    }

    @Test
    public void isEmpty() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        InternetContract contract = new InternetContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 12);
        Repository data = new Repository();
        data.add(contract);
        boolean actual = data.isEmpty();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void getSize() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        InternetContract contract = new InternetContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 12);
        Repository data = new Repository();
        InternetContract contract2 = new InternetContract(2, LocalDate.of(2021, 10, 6), LocalDate.of(2021, 11, 6), 456, person, 16);
        data.add(contract);
        data.add(contract2);
        int actualSize = data.getSize();
        int expectedSize = 2;
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void get() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        InternetContract contract = new InternetContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 12);
        Repository data = new Repository();
        InternetContract contract2 = new InternetContract(2, LocalDate.of(2021, 10, 6), LocalDate.of(2021, 11, 6), 456, person, 16);
        data.add(contract);
        data.add(contract2);
        Contract actual = data.get(1);
        assertEquals(contract, actual);
    }

    @Test
    public void clear() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        InternetContract contract = new InternetContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 12);
        Repository data = new Repository();
        data.add(contract);
        data.clear();
        int actual = data.getSize();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        InternetContract contract = new InternetContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 12);
        Repository data = new Repository();
        InternetContract contract2 = new InternetContract(2, LocalDate.of(2021, 10, 6), LocalDate.of(2021, 11, 6), 456, person, 16);
        data.add(contract);
        data.add(contract2);
        data.remove(1);
        int actual = data.getSize();
        int expected = 1;
        assertEquals(expected, actual);
    }
}