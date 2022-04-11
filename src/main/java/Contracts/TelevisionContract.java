package Contracts;
import Person.Person;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TelevisionContract extends Contract {
    /*
    private field for data storage
     */
    private List<String> channels;

    @Override
    public String toString() {
        return "TelevisionContract{" +
                "channels=" + channels +
                "} " + super.toString();
    }

    /*
        Constructor
         */
    public TelevisionContract(int id, LocalDate start, LocalDate end, int number, Person owner, List<String> channels) {
        super(id, start, end, number, owner);
        this.channels = channels;
    }

    public TelevisionContract() {
        super(0, null, null, 0, null);
        String[] temp = {"one"};
        this.channels = Arrays.stream(temp).toList();
    }
    /*
    This method set channel list of contract
     */
    public void setChannels(List<String> channels) {
        this.channels = channels;
    }
    /*
    This method set channel list of contract
     */
    public List<String> getChannels() {
        return channels;
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), channels);}

}
