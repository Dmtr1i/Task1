import java.time.LocalDate;
import java.util.Scanner;

public class TelevisionContract extends Contract {
    private int channels;
    TelevisionContract() {
        channels = -1;
    }
    TelevisionContract(long id, LocalDate start, LocalDate end, long num, Object owner) {
        this.id = id;
        this.startDate = start;
        this.endDate = end;
        this.number = num;
        this.owner = owner;
        System.out.print("Введите количество каналов: ");
        Scanner in = new Scanner(System.in);
        channels = in.nextInt();
    }
}
