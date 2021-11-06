import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {
    private long id;
    private String name;
    private LocalDate birthDate;
    private String gender;
    private int pasportSeries;
    private int pasportNumber;
    private int age;
    Person(long id, String name, LocalDate birthDate, String gender, int pasportNumber, int pasportSeries) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.pasportNumber = pasportNumber;
        this.pasportSeries = pasportSeries;
        LocalDate time = LocalDate.now();
        LocalDate result = time.minus(birthDate.getDayOfMonth() - 1, ChronoUnit.DAYS);
        result = result.minus(birthDate.getMonthValue(), ChronoUnit.MONTHS);
        result = result.minus(birthDate.getYear(), ChronoUnit.YEARS);
        age = result.getYear();
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public String getGender() {
        return gender;
    }
    public int getPasportSeries() {
        return pasportSeries;
    }
    public int getPasportNumber() {
        return pasportNumber;
    }
    public int getAge() {
        return age;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setPasportNumber(int pasportNumber) {
        this.pasportNumber = pasportNumber;
    }
    public void setPasportSeries(int pasportSeries) {
        this.pasportSeries = pasportSeries;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
