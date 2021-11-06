import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {
    private static long id;
    private static String name;
    private static LocalDate birth_date;
    private static String sex;
    private static int pasNum;
    private static int pasSeries;
    private static int age;
    Person() {
        id = pasNum = pasSeries = age = 0;
        name = sex = null;
        birth_date = LocalDate.now();
        findAge();
    }
    Person(long id, String name, LocalDate birth_date, String sex, int pasSeries, int pasNum) {
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





    public static void result(){
        System.out.println("\nID = " + id + "\nName = " + name + "\nBirthday = " + birth_date +
                "\nSex = " + sex + "\nPasSer = " + pasSeries + "\nPasNum = " + pasNum +
                "\nAge = " + age);
    }

}
