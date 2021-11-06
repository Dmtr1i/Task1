import java.time.LocalDate;
import java.util.Scanner;

public class Blank {
    private static long id = 0;
    private static long number = 1;
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
        in.nextLine();
        String sex = in.nextLine();
        System.out.print("Введите серию паспорта клиента: ");
        int pasSeries = in.nextInt();
        System.out.print("Введите номер паспорта клиента: ");
        int pasNum = in.nextInt();
        Person owner = new Person(id, name, birthdate, sex, pasSeries, pasNum);
        id += 1;
        boolean check = true;
        System.out.print("Добавить клиенту " + /*name + */" контракт на мобильную связь?(1 - да,2 - нет) ");
        while (check) {
            int answer = in.nextInt();
            if (answer == 1) {
                phoneContract(owner);
                id += 1;
                number += 1;
                check = false;
            } else if (answer == 2)
                check = false;
            else {
                System.out.print("Введено некорректное значение, повторите попытку: ");
            }
        }
        System.out.print("Добавить клиенту " +/* name +*/ " контракт на проводной интернет?(1 - да,2 - нет) ");
        check = true;
        while (check) {
            int answer = in.nextInt();
            if (answer == 1) {
                internetContract(owner);
                id += 1;
                number += 1;
                check = false;
            } else if (answer == 2)
                check = false;
            else {
                System.out.print("Введено некорректное значение, повторите попытку: ");
            }
        }
        System.out.print("Добавить клиенту " +/* name +*/ " контракт на телевидиние?(1 - да,2 - нет) ");
        check = true;
        while (check) {
            int answer = in.nextInt();
            if (answer == 1) {
                tvContract(owner);
                id += 1;
                number += 1;
                check = false;
            } else if (answer == 2)
                check = false;
            else {
                System.out.print("Введено некорректное значение, повторите попытку: ");
            }
        }
    }
    private static void phoneContract(Object owner) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите дату начала действия контракта(день, месяц, год, через пробел): ");
        int day = in.nextInt();
        int month = in.nextInt();
        int year = in.nextInt();
        LocalDate phoneStart = LocalDate.of(year, month, day);
        System.out.print("Введите дату окончания действия контракта(день, месяц, год, через пробел): ");
        day = in.nextInt();
        month = in.nextInt();
        year = in.nextInt();
        LocalDate phoneEnd = LocalDate.of(year, month, day);
        System.out.print("Введите количество минут: ");
        int minutes = in.nextInt();
        System.out.print("Введите количество сообщений: ");
        int messages = in.nextInt();
        System.out.print("Введите оставшееся количество интернет трафика: ");
        int internet = in.nextInt();
        PhoneContract phone = new PhoneContract(id, phoneStart, phoneEnd, number, owner, minutes, messages, internet);
    }
    private static void internetContract(Object owner) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите дату начала действия контракта(день, месяц, год, через пробел): ");
        int day = in.nextInt();
        int month = in.nextInt();
        int year = in.nextInt();
        LocalDate internetStart = LocalDate.of(year, month, day);
        System.out.print("Введите дату окончания действия контракта(день, месяц, год, через пробел): ");
        day = in.nextInt();
        month = in.nextInt();
        year = in.nextInt();
        LocalDate internetEnd = LocalDate.of(year, month, day);
        System.out.print("Введите скорость проводного интернет соединения: ");
        int connectionSpeed = in.nextInt();
        InternetContract internet = new InternetContract(id, internetStart, internetEnd, number, owner, connectionSpeed);
    }
    private static void tvContract(Object owner) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите дату начала действия контракта(день, месяц, год, через пробел): ");
        int day = in.nextInt();
        int month = in.nextInt();
        int year = in.nextInt();
        LocalDate tvStart = LocalDate.of(year, month, day);
        System.out.print("Введите дату окончания действия контракта(день, месяц, год, через пробел): ");
        day = in.nextInt();
        month = in.nextInt();
        year = in.nextInt();
        LocalDate tvEnd = LocalDate.of(year, month, day);
        System.out.print("Введите количество каналов: ");
        int channels = in.nextInt();
        TelevisionContract tv = new TelevisionContract(id, tvStart, tvEnd, number, owner, channels);
    }
}
