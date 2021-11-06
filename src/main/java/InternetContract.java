import java.time.LocalDate;
import java.util.Scanner;

public class InternetContract extends Contract {
    private static int connectionSpeed;
    InternetContract() {
        connectionSpeed = -1;
    }
    InternetContract(long id, LocalDate start, LocalDate end, long num, Object owner, int connectionSpeed) {
        this.id = id;
        this.startDate = start;
        this.endDate = end;
        this.number = num;
        this.owner = owner;
        this.connectionSpeed = connectionSpeed;
    }





    public static void result() {
        System.out.println("id = " + id + "\nstart = " + startDate + "\nend = " + endDate + "\nnumber = " + number +
                "\nowner = " + owner + "\nspeed = " + connectionSpeed);
    }
}