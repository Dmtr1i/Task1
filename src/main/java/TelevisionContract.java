import java.time.LocalDate;
import java.util.List;

public class TelevisionContract extends Contract {
    private List<String> channels;
    TelevisionContract(long id, LocalDate start, LocalDate end, long number, Person owner, List<String> channels) {
        super(id, start, end, number, owner);
        this.channels = channels;
    }
    public void setChannels(List<String> channels) {
        this.channels = channels;
    }
    public List<String> getChannels() {
        return channels;
    }
}
