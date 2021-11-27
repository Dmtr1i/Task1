package Contracts;
import Person.Person;

import java.time.LocalDate;
import java.util.Objects;

public class Contract{

    /*
    private fields for data storage
    */

    private long id;
    private LocalDate startContract;
    private LocalDate endContract;
    private long number;
    private Person owner;

    /*
    Constructor
    */

    public Contract(long id, LocalDate start, LocalDate end, long number, Person owner){
        this.id = id;
        this.startContract = start;
        this.endContract = end;
        this.number = number;
        this.owner = owner;
    }

    /*
    This method returns ID of contract
     */

    public long getId() {
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
    public long getNumber() {
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
    public void setId(long id) {
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
    public void setNumber(long number) {
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
}
