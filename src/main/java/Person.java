import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {
    private int id;
    private String name;
    private LocalDate birth_date;
    private String sex;
    private int pasNum;
    private int pasSeries;
    private int age;
    Person() {
        id = pasNum = pasSeries = age = 0;
        name = sex = null;
        birth_date = LocalDate.now();
        findAge();
    }
    Person(int id, String name, LocalDate birth_date, String sex, int pasNum, int pasSeries, int age) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
        this.sex = sex;
        this.pasNum = pasNum;
        this.pasSeries = pasSeries;
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
