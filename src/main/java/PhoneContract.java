import java.time.LocalDate;
import java.util.Scanner;

public class PhoneContract extends Contract{
    private static int minutes, messages, internet;
    PhoneContract() {
        minutes = messages = internet = -1;
    }
    PhoneContract(long id, LocalDate start, LocalDate end, long num, Object owner, int minutes, int messages, int internet) {
        this.id = id;
        this.startDate = start;
        this.endDate = end;
        this.number = num;
        this.owner = owner;
        this.minutes = minutes;
        this.messages = messages;
        this.internet = internet;
    }



    public static void result() {
        System.out.println("id = " + id + "\nStart = " + startDate + "\nend = " + endDate + "\nnumber = " +
                number + "\nowner = " + owner + "\nmin = " + minutes + "\nmes = " + messages + "\nint = " + internet);
    }
}
