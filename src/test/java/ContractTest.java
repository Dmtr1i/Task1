import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ContractTest {

    /*
    Test all methods of the class Contract
     */

    @Test
    public void getId() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        Contract contract = new Contract(0, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 6, person);
        long actual = contract.getId();
        long expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void getStartContract() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        Contract contract = new Contract(0, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 6, person);
        LocalDate actual = contract.getStartContract();
        LocalDate expected = LocalDate.of(2021, 5, 6);
        assertEquals(expected, actual);
    }

    @Test
    public void getEndContract() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        Contract contract = new Contract(0, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 6, person);
        LocalDate actual = contract.getEndContract();
        LocalDate expected = LocalDate.of(2021, 6, 6);
        assertEquals(expected, actual);
    }

    @Test
    public void getNumber() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        Contract contract = new Contract(0, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 6, person);
        long actual = contract.getNumber();
        long expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void getOwner() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        Contract contract = new Contract(0, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 6, person);
        Person actual = contract.getOwner();
        Person expected = person;
        assertEquals(expected, actual);
    }

    @Test
    public void setId() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        Contract contract = new Contract(0, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 6, person);
        contract.setId(16);
        long actual = contract.getId();
        long expected = 16;
        assertEquals(expected, actual);
    }

    @Test
    public void setStartContract() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        Contract contract = new Contract(0, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 6, person);
        contract.setStartContract(LocalDate.of(2021, 10, 3));
        LocalDate actual = contract.getStartContract();
        LocalDate expected = LocalDate.of(2021, 10, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void setEndContract() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        Contract contract = new Contract(0, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 6, person);
        contract.setEndContract(LocalDate.of(2021, 6, 3));
        LocalDate actual = contract.getEndContract();
        LocalDate expected = LocalDate.of(2021, 6, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void setNumber() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        Contract contract = new Contract(0, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 6, person);
        contract.setNumber(4215);
        long actual = contract.getNumber();
        long expected = 4215;
        assertEquals(expected, actual);
    }

    @Test
    public void setOwner() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        Contract contract = new Contract(0, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 6, person);
        Person person1 = new Person(1, "Klimenko Dmitry Sergeevitch", LocalDate.of(2004, 2, 14), "male", 152634, 1618);
        contract.setOwner(person1);
        Person actual = contract.getOwner();
        Person expected = person1;
        assertEquals(expected, actual);
    }
}