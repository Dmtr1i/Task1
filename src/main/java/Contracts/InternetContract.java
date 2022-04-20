package Contracts;
import Person.Person;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;
import java.util.Objects;

@XmlRootElement(name = "InternetContract")
@XmlType(propOrder = {"connectionSpeed"})
@XmlAccessorType(XmlAccessType.FIELD)
public class InternetContract extends Contract {
    /*
    private fields for data storage
     */
    @XmlElement
    private int connectionSpeed;
    /*
    Constructor
     */
    public InternetContract(int id, LocalDate start, LocalDate end, int number, Person owner, int speed){
        super(id, start, end, number, owner);
        this.connectionSpeed = speed;
    }

    public InternetContract(){
    }
    /*
    This method reurns connection speed of contract
     */
    public int getConnectionSpeed() {
        return connectionSpeed;
    }
    /*
    This method set connection speed of contract
    */
    public void setConnectionSpeed(int connectionSpeed) {
        this.connectionSpeed = connectionSpeed;
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), connectionSpeed); }

    @Override
    public String toString() {
        return "InternetContract{" +
                "connectionSpeed=" + connectionSpeed +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InternetContract that = (InternetContract) o;
        return connectionSpeed == that.connectionSpeed;
    }
}
