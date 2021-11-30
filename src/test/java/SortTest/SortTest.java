package SortTest;

import Contracts.Contract;
import Contracts.InternetContract;
import Contracts.MobileContract;
import Contracts.TelevisionContract;
import Person.Person;
import Repository.Repository;
import Sorts.BubbleSort;
import Sorts.SelectionSort;
import Sorts.ShakerSort;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SortTest {
    @Test
    public void sort() {
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
        data.setSorter(new BubbleSort<>());
        Repository<Contract> data2 = new Repository<>();
        data2.add(contract);
        data2.add(contract2);
        data2.add(contract3);
        data2.add(contract4);
        data2.add(contract5);
        data2.add(contract6);
        data.sort((o1, o2) -> Integer.compare(o2.getNumber(),o1.getNumber()));
        assertEquals(data.getByIndex(0), data2.getByIndex(0));
        assertEquals(data.getByIndex(1), data2.getByIndex(2));
        assertEquals(data.getByIndex(2), data2.getByIndex(3));
        assertEquals(data.getByIndex(3), data2.getByIndex(1));
        assertEquals(data.getByIndex(4), data2.getByIndex(4));
        assertEquals(data.getByIndex(5), data2.getByIndex(5));
        data.clear();
        data.add(contract);
        data.add(contract2);
        data.add(contract3);
        data.add(contract4);
        data.add(contract5);
        data.add(contract6);
        data.setSorter(new ShakerSort<>());
        data.sort((o1, o2) -> Integer.compare(o2.getNumber(), o1.getNumber()));
        assertEquals(data.getByIndex(0), data2.getByIndex(0));
        assertEquals(data.getByIndex(1), data2.getByIndex(2));
        assertEquals(data.getByIndex(2), data2.getByIndex(3));
        assertEquals(data.getByIndex(3), data2.getByIndex(1));
        assertEquals(data.getByIndex(4), data2.getByIndex(4));
        assertEquals(data.getByIndex(5), data2.getByIndex(5));
        data.clear();
        data.add(contract);
        data.add(contract2);
        data.add(contract3);
        data.add(contract4);
        data.add(contract5);
        data.add(contract6);
        data.setSorter(new SelectionSort<>());
        data.sort((o1, o2) -> Integer.compare(o2.getNumber(), o1.getNumber()));
        assertEquals(data.getByIndex(0), data2.getByIndex(0));
        assertEquals(data.getByIndex(1), data2.getByIndex(2));
        assertEquals(data.getByIndex(2), data2.getByIndex(3));
        assertEquals(data.getByIndex(3), data2.getByIndex(1));
        assertEquals(data.getByIndex(4), data2.getByIndex(4));
        assertEquals(data.getByIndex(5), data2.getByIndex(5));
    }
}
