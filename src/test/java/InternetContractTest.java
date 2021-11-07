import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class InternetContractTest {

    @Test
    public void getConnectionSpeed() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        InternetContract contract = new InternetContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 12);
        int actual = contract.getConnectionSpeed();
        int expected = 12;
        assertEquals(expected, actual);
    }

    @Test
    public void setConnectionSpeed() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        InternetContract contract = new InternetContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 12);
        contract.setConnectionSpeed(16);
        int actual = contract.getConnectionSpeed();
        int expected = 16;
        assertEquals(expected, actual);
    }
}