import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MobileContractTest {

    @Test
    public void getMinutes() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        MobileContract contract = new MobileContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 600, 20, 40);
        int actual = contract.getMinutes();
        int expected = 600;
        assertEquals(expected, actual);
    }

    @Test
    public void getMessages() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        MobileContract contract = new MobileContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 600, 20, 40);
        int actual = contract.getMessages();
        int expected = 20;
        assertEquals(expected, actual);
    }

    @Test
    public void getInternet() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        MobileContract contract = new MobileContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 600, 20, 40);
        int actual = contract.getInternet();
        int expected = 40;
        assertEquals(expected, actual);
    }

    @Test
    public void setMinutes() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        MobileContract contract = new MobileContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 600, 20, 40);
        contract.setMinutes(7500);
        int actual = contract.getMinutes();
        int expected = 7500;
        assertEquals(expected, actual);
    }

    @Test
    public void setMessages() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        MobileContract contract = new MobileContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 600, 20, 40);
        contract.setMessages(450);
        int actual = contract.getMessages();
        int expected = 450;
        assertEquals(expected, actual);
    }

    @Test
    public void setInternet() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        MobileContract contract = new MobileContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 600, 20, 40);
        contract.setInternet(10);
        int actual = contract.getInternet();
        int expected = 10;
        assertEquals(expected, actual);
    }
}