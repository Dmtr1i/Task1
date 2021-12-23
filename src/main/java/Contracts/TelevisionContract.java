package Contracts;
import Person.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class TelevisionContract extends Contract {
    /*
    private field for data storage
     */
    private List<String> channels;
    /*
    Constructor
     */
    public TelevisionContract(int id, LocalDate start, LocalDate end, int number, Person owner, List<String> channels) {
        super(id, start, end, number, owner);
        this.channels = channels;
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

    @Override
    public String toString() {
        String stringChannels = channels.toString();
        stringChannels = stringChannels.replaceAll(",", ".");
        return String.format("%s, %s", super.toString(), stringChannels);
    }
}
