import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {
    int id;
    String name;
    LocalDate birth_date;
    String sex;
    int pasNum;
    int pasSeries;
    int age;
    Person() {
        id = pasNum = pasSeries = age = 0;
        name = sex = null;
        birth_date = LocalDate.of(2001,8,24);
        findAge();
    }
    public void findAge() {
        LocalDate time = LocalDate.now();
        LocalDate result = time.minus(birth_date.getDayOfMonth() - 1, ChronoUnit.DAYS);
        result = result.minus(birth_date.getMonthValue(), ChronoUnit.MONTHS);
        result = result.minus(birth_date.getYear(), ChronoUnit.YEARS);
        age = result.getYear();
    }
    public int returnAge() {return age;}
}
