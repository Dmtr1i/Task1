import java.time.LocalDate;

public class MobileContract extends Contract {
    private int minutes;
    private int messages;
    private int internet;
    MobileContract(long id, LocalDate start, LocalDate end, long number, Person owner, int minutes, int messages, int internet) {
        super(id, start, end, number, owner);
        this.minutes = minutes;
        this.messages = messages;
        this.internet = internet;
    }
    public int getMinutes() {
        return minutes;
    }
    public int getMessages() {
        return messages;
    }
    public int getInternet() {
        return internet;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    public void setMessages(int messages) {
        this.messages = messages;
    }
    public void setInternet(int internet) {
        this.internet = internet;
    }
}
