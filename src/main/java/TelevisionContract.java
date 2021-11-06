import java.time.LocalDate;
import java.util.Scanner;

public class TelevisionContract extends Contract {
    private static int channels;
    TelevisionContract() {
        channels = -1;
    }
    TelevisionContract(long id, LocalDate start, LocalDate end, long num, Object owner, int channels) {
        this.id = id;
        this.startDate = start;
        this.endDate = end;
        this.number = num;
        this.owner = owner;
        this.channels = channels;
    }






    public static void result() {
        System.out.println("id = " + id + "\nstart = " + startDate + "\nend = " + endDate + "\nnum = " + number +
                "\nowner = " + owner + "\ncha = " + channels);
    }
}
