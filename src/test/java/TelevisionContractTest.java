import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TelevisionContractTest {

    /*
    Test all methods of the class TelevisionContract
     */
    @Test
    public void setChannels() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        String[] channel = {"Первый", "Второй", "Третий"};
        List<String> channel1 = Arrays.stream(channel).toList();
        TelevisionContract contract = new TelevisionContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, channel1);
        String[] channel2 = {"Четвертый", "Пятый", "Шестой", "Седьмой", "Восьмой"};
        List<String> channel3 = Arrays.stream(channel2).toList();
        contract.setChannels(channel3);
        List<String> actual = contract.getChannels();
        List<String> expected = Arrays.stream(channel2).toList();
        assertEquals(expected, actual);
    }

    @Test
    public void getChannels() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        String[] channel = {"Первый", "Второй", "Третий"};
        List<String> channel1 = Arrays.stream(channel).toList();
        TelevisionContract contract = new TelevisionContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, channel1);
        List<String> actual = contract.getChannels();
        List<String> expected = Arrays.stream(channel).toList();
        assertEquals(expected, actual);
    }
}