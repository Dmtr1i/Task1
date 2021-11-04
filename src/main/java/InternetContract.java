import java.time.LocalDate;
import java.util.Scanner;

public class InternetContract extends Contract {
    private double connection_speed;
    InternetContract() {
        connection_speed = -1;
    }
    InternetContract(long id, LocalDate start, LocalDate end, long num, Object owner) {
        this.id = id;
        this.startDate = start;
        this.endDate = end;
        this.number = num;
        this.owner = owner;
        System.out.print("Введите скорость проводного интернет соединения: ");
        Scanner in = new Scanner(System.in);
        connection_speed = in.nextDouble();
    }
}