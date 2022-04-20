package Contracts;
import Person.Person;

import javax.xml.bind.annotation.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "TelevisionContract")
@XmlType(propOrder = {"channels"})
@XmlAccessorType(XmlAccessType.FIELD)
public class TelevisionContract extends Contract {
    /*
    private field for data storage
     */
    @XmlElement
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TelevisionContract tv = (TelevisionContract) o;
        return Objects.equals(channels, tv.channels);
    }
}
