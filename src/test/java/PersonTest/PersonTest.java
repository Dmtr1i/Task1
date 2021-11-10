package PersonTest;

import Person.Person;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PersonTest {

    /*
    Test all methods of the class Person.Person
     */
    @Test
    public void getId() {
        Person boi = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        long actual = boi.getId();
        long expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void getName() {
        Person boi = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        String actual = boi.getName();
        String expected = "Klimenko Dmitry Sergeevitch";
        assertEquals(expected, actual);
    }

    @Test
    public void getBirthDate() {
        Person boi = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        LocalDate actual = boi.getBirthDate();
        LocalDate expected = LocalDate.of(2001, 8, 24);
        assertEquals(expected, actual);
    }

    @Test
    public void getGender() {
        Person boi = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        String actual = boi.getGender();
        String expected = "male";
        assertEquals(expected, actual);
    }

    @Test
    public void getPassportSeries() {
        Person boi = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        int actual = boi.getPassportSeries();
        int expected = 1618;
        assertEquals(expected, actual);
    }

    @Test
    public void getPassportNumber() {
        Person boi = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        int actual = boi.getPassportNumber();
        int expected = 152634;
        assertEquals(expected, actual);
    }

    @Test
    public void getAge() {
        Person boi = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        int actual = boi.getAge();
        int expected = 20;
        assertEquals(expected, actual);
    }

    @Test
    public void setId() {
        Person boi = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        boi.setId(20);
        long actual = boi.getId();
        long expected = 20;
        assertEquals(expected, actual);
    }

    @Test
    public void setName() {
        Person boi = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        boi.setName("Semenov Petr Ivanovitch");
        String actual = boi.getName();
        String expected = "Semenov Petr Ivanovitch";
        assertEquals(expected, actual);
    }

    @Test
    public void setBirthDate() {
        Person boi = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        boi.setBirthDate(LocalDate.of(2002, 6, 13));
        LocalDate actual = boi.getBirthDate();
        LocalDate expected = LocalDate.of(2002, 6, 13);
        assertEquals(expected, actual);
    }

    @Test
    public void setGender() {
        Person boi = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        boi.setGender("Male");
        String actual = boi.getGender();
        String expected = "Male";
        assertEquals(expected, actual);
    }

    @Test
    public void setPassportNumber() {
        Person boi = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        boi.setPassportNumber(205613);
        int actual = boi.getPassportNumber();
        int expected = 205613;
        assertEquals(expected, actual);
    }

    @Test
    public void setPassportSeries() {
        Person boi = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        boi.setPassportSeries(1826);
        long actual = boi.getPassportSeries();
        long expected = 1826;
        assertEquals(expected, actual);
    }

    @Test
    public void setAge() {
        Person boi = new Person(0, "Klimenko Dmitry Sergeevitch", LocalDate.of(2001, 8, 24), "male", 152634, 1618);
        boi.setAge(46);
        int actual = boi.getAge();
        int expected = 46;
        assertEquals(expected, actual);
    }
}