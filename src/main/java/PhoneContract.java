import java.time.LocalDate;
import java.util.Scanner;

public class PhoneContract extends Contract{
    private int minutes, messages, internet;
    PhoneContract() {
        minutes = messages = internet = -1;
    }
    PhoneContract(long id, LocalDate start, LocalDate end, long num, Object owner) {
        this.id = id;
        this.startDate = start;
        this.endDate = end;
        this.number = num;
        this.owner = owner;
        System.out.print("Введите количество минут: ");
        Scanner in = new Scanner(System.in);
        minutes = in.nextInt();
        System.out.print("Введите количество сообщений: ");
        messages = in.nextInt();
        System.out.print("Введите оставшееся количество интернет трафика: ");
        internet = in.nextInt();
    }
}
