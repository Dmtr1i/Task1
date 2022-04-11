package Contracts;
import Person.Person;

import java.time.LocalDate;
import java.util.Objects;

public class MobileContract extends Contract {
    /*
    private fields for data storage
     */
    private int minutes;
    private int messages;
    private int internet;

    @Override
    public String toString() {
        return "MobileContract{" +
                "minutes=" + minutes +
                ", messages=" + messages +
                ", internet=" + internet +
                "} " + super.toString();
    }

    /*
        Constructor
         */
    public MobileContract(int id, LocalDate start, LocalDate end, int number, Person owner, int minutes, int messages, int internet) {
        super(id, start, end, number, owner);
        this.minutes = minutes;
        this.messages = messages;
        this.internet = internet;
    }

    public MobileContract(){
        super(0, null, null, 0, null);
        this.minutes = 0;
        this.messages = 0;
        this.internet = 0;
    }
    /*
    This method returns minutes of contract
     */
    public int getMinutes() {
        return minutes;
    }
    /*
    This method returns messages of contract
     */
    public int getMessages() {
        return messages;
    }
    /*
    This method returns internets of contract
     */
    public int getInternet() {
        return internet;
    }
    /*
    This method set minutes of contract
    */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    /*
    This method set messages of contract
     */
    public void setMessages(int messages) {
        this.messages = messages;
    }
    /*
    This method set internet of contract
     */
    public void setInternet(int internet) {
        this.internet = internet;
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), minutes, messages, internet); }

}
