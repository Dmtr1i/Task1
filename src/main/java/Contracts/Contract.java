package Contracts;
import Person.Person;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;
import java.util.Objects;

@XmlRootElement(name = "contract")
@XmlSeeAlso({InternetContract.class, MobileContract.class, TelevisionContract.class})
@XmlType(propOrder = {"id","startContract", "endContract", "number", "owner"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Contract{

    /*
    private fields for data storage
    */
    @XmlElement
    private int id;
    @XmlElement
    private LocalDate startContract;
    @XmlElement
    private LocalDate endContract;
    @XmlElement
    private int number;
    @XmlElement
    private Person owner;

    /*
    Constructor
    */

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", startContract=" + startContract +
                ", endContract=" + endContract +
                ", number=" + number +
                ", owner=" + owner +
                '}';
    }

    public Contract(int id, LocalDate start, LocalDate end, int number, Person owner){
        this.id = id;
        this.startContract = start;
        this.endContract = end;
        this.number = number;
        this.owner = owner;
    }

    public Contract(){}

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return id == contract.id && number == contract.number && Objects.equals(startContract, contract.startContract) && Objects.equals(endContract, contract.endContract) && Objects.equals(owner, contract.owner);
    }
}
