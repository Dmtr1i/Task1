import java.time.LocalDate;
import java.util.Scanner;

public class Blank {
    private static int id = 0;
    public static void add() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите ФИО клиента: ");
        String name = in.nextLine();
        System.out.print("Введите дату рождения клиента(день, месяц, год, через пробел): ");
        int day = in.nextInt();
        int month = in.nextInt();
        int year = in.nextInt();
        LocalDate birthdate = LocalDate.of(year, month, day);
        System.out.print("Введите пол клиента: ");
        String sex = in.next();
        System.out.print("Введите серию паспорта клиента: ");
        int pasSeries = in.nextInt();
        System.out.print("Введите номер паспорта клиента: ");
        int pasNum = in.nextInt();
        Person owner = new Person(id, name, birthdate, sex, pasSeries, pasNum);
        id += 1;

    }
}
