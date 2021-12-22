package Person;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Person {
    /*
    private field for data storage
     */
    private int id;
    private String name;
    private LocalDate birthDate;
    private String gender;
    private int passportSeries;
    private int passportNumber;
    private int age;
    /*
    Constructor
     */
    public Person(int id, String name, LocalDate birthDate, String gender, int passportNumber, int passportSeries) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.passportNumber = passportNumber;
        this.passportSeries = passportSeries;
        /*
        calculation age
         */
        LocalDate time = LocalDate.now();
        LocalDate result = time.minus(birthDate.getDayOfMonth() - 1, ChronoUnit.DAYS);
        result = result.minus(birthDate.getMonthValue(), ChronoUnit.MONTHS);
        result = result.minus(birthDate.getYear(), ChronoUnit.YEARS);
        age = result.getYear();
    }
    /*
    This method returns ID of person
     */
    public long getId() {
        return id;
    }
    /*
    This method returns name of person
     */
    public String getName() {
        return name;
    }
    /*
    This method returns birth date of person
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }
    /*
    This method returns gender of person
     */
    public String getGender() {
        return gender;
    }
    /*
    This method returns passport series of person
     */
    public int getPassportSeries() {
        return passportSeries;
    }
    /*
    This method returns passport number of person
     */
    public int getPassportNumber() {
        return passportNumber;
    }
    /*
    This method returns age of person
     */
    public int getAge() {
        return age;
    }
    /*
    This method set ID of person
    */
    public void setId(int id) {
        this.id = id;
    }
    /*
    This method set name of person
    */
    public void setName(String name) {
        this.name = name;
    }
    /*
    This method set birth date of person
    */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    /*
    This method set gender of person
    */
    public void setGender(String gender) {
        this.gender = gender;
    }
    /*
    This method set passport number of person
    */
    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }
    /*
    This method set passport series of person
    */
    public void setPassportSeries(int passportSeries) {
        this.passportSeries = passportSeries;
    }
    /*
    This method set Age of person
    */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() { return Objects.hash(id, name, birthDate, gender, passportNumber, passportSeries, age);}

    @Override
    public String toString() {
        return String.format("%d, %s, %d.%d.%d, %s, %d, %d, %d", id, name, birthDate.getDayOfMonth(), birthDate.getMonthValue(),
                birthDate.getYear(), gender, passportSeries, passportNumber, age);
    }
}
