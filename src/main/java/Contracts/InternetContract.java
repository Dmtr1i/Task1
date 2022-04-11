package Contracts;
import Person.Person;

import java.time.LocalDate;
import java.util.Objects;

public class InternetContract extends Contract {
    /*
    private fields for data storage
     */
    private int connectionSpeed;
    /*
    Constructor
     */
    public InternetContract(int id, LocalDate start, LocalDate end, int number, Person owner, int speed){
        super(id, start, end, number, owner);
        this.connectionSpeed = speed;
    }

    public InternetContract(){
        super(0, null, null, 0, null);
        this.connectionSpeed = 0;
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
}
