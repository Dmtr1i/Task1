package ContractValidatorTest;

import Contracts.Contract;
import Contracts.InternetContract;
import Contracts.MobileContract;
import Contracts.TelevisionContract;
import Person.Person;
import Validation.ContractValidator;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ContractValidatorTest {

    @Test
    public void validate() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        Contract contract = new Contract(0, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 6, person);
        ContractValidator vali = new ContractValidator();
        vali.validate(contract);
        assertEquals("OK", vali.getStatus());
        Contract contract1 = new Contract(0, LocalDate.of(2021, 6, 6), LocalDate.of(2021, 5, 6), 6, person);
        vali.validate(contract1);
        assertEquals("Error", vali.getStatus());
    }

    @Test
    public void testValidate() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        MobileContract contract = new MobileContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 600, 20, 40);
        ContractValidator vali = new ContractValidator();
        vali.validate(contract);
        assertEquals("OK", vali.getStatus());
        MobileContract contract1 = new MobileContract(1, LocalDate.of(2021, 6, 6), LocalDate.of(2021, 5, 6), 123, person, 600, 20, 40);
        vali.validate(contract1);
        assertEquals("Error", vali.getStatus());
        MobileContract contract2 = new MobileContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, -3, 20, 40);
        vali.validate(contract2);
        assertEquals("Error", vali.getStatus());
        MobileContract contract3 = new MobileContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 600, -3, 40);
        vali.validate(contract3);
        assertEquals("Error", vali.getStatus());
        MobileContract contract4 = new MobileContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 600, 20, -3);
        vali.validate(contract4);
        assertEquals("Error", vali.getStatus());

    }

    @Test
    public void testValidate1() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        InternetContract contract = new InternetContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, 12);
        ContractValidator vali = new ContractValidator();
        vali.validate(contract);
        assertEquals("OK", vali.getStatus());
        InternetContract contract1 = new InternetContract(1, LocalDate.of(2021, 6, 6), LocalDate.of(2021, 5, 6), 123, person, 12);
        vali.validate(contract1);
        assertEquals("Error", vali.getStatus());
        InternetContract contract2 = new InternetContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, -6);
        vali.validate(contract2);
        assertEquals("Error", vali.getStatus());
    }

    @Test
    public void testValidate2() {
        Person person = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        String[] channel = {"Первый", "Второй", "Третий"};
        List<String> channel1 = Arrays.stream(channel).toList();
        TelevisionContract contract = new TelevisionContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, channel1);
        ContractValidator vali = new ContractValidator();
        vali.validate(contract);
        assertEquals("OK", vali.getStatus());
        String[] channels = {};
        List<String> channels1 = Arrays.stream(channels).toList();
        TelevisionContract contract1 = new TelevisionContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, channels1);
        vali.validate(contract1);
        assertEquals("Error", vali.getStatus());
        List<String> channels2 = null;
        TelevisionContract contract2 = new TelevisionContract(1, LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 6), 123, person, channels1);
        vali.validate(contract2);
        assertEquals("Error", vali.getStatus());
        TelevisionContract contract3 = new TelevisionContract(1, LocalDate.of(2021, 6, 6), LocalDate.of(2021, 5, 6), 123, person, channel1);
        vali.validate(contract3);
        assertEquals("Error", vali.getStatus());
    }
}