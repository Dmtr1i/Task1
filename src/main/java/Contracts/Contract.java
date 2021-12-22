package Contracts;
import Person.Person;

import java.time.LocalDate;
import java.util.Objects;

public class Contract{

    /*
    private fields for data storage
    */

    private int id;
    private LocalDate startContract;
    private LocalDate endContract;
    private int number;
    private Person owner;

    /*
    Constructor
    */

    public Contract(int id, LocalDate start, LocalDate end, int number, Person owner){
        this.id = id;
        this.startContract = start;
        this.endContract = end;
        this.number = number;
        this.owner = owner;
    }

    /*
    This method returns ID of contract
     */

    public int getId() {
        return id;
    }
    /*
    This method returns Start Date of contract
     */
    public LocalDate getStartContract() {
        return startContract;
    }
    /*
    This method returns End Date of contract
     */
    public LocalDate getEndContract() {
        return endContract;
    }
    /*
    This method returns number of contract
     */
    public int getNumber() {
        return number;
    }
    /*
    This method returns owner of contract
     */
    public Person getOwner() {
        return owner;
    }
    /*
    This method set ID of contract
     */
    public void setId(int id) {
        this.id = id;
    }
    /*
    This method set start date of contract
     */
    public void setStartContract(LocalDate startContract) {
        this.startContract = startContract;
    }
    /*
    This method set end date of contract
     */
    public void setEndContract(LocalDate endContract) {
        this.endContract = endContract;
    }
    /*
    This method set number of contract
     */
    public void setNumber(int number) {
        this.number = number;
    }
    /*
    This method set owner of contract
     */
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public int hashCode() { return Objects.hash(id, startContract, endContract, number, owner); }

    @Override
    public String toString() {
        return String.format("%d, %d.%d.%d, %d.%d.%d, %d, %d, %s, %d.%d.%d, %s, %d, %d, %d", id, startContract.getDayOfMonth(), startContract.getMonthValue(),
                startContract.getYear(), endContract.getDayOfMonth(), endContract.getMonthValue(),
                endContract.getYear(), number, owner.getId(), owner.getName(), owner.getBirthDate().getDayOfMonth(), owner.getBirthDate().getMonthValue(),owner.getBirthDate().getYear(),
                owner.getGender(), owner.getPassportSeries(), owner.getPassportNumber(), owner.getAge());
    }
}
