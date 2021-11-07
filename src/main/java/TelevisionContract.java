import java.time.LocalDate;
import java.util.List;

public class TelevisionContract extends Contract {
    /*
    private field for data storage
     */
    private List<String> channels;
    /*
    Constructor
     */
    TelevisionContract(long id, LocalDate start, LocalDate end, long number, Person owner, List<String> channels) {
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
}
