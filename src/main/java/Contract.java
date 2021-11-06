import java.time.LocalDate;

public class Contract {
    public static long id;
    public static LocalDate startDate;
    public static LocalDate endDate;
    public static long number;
    public static Object owner;
    Contract() {
        id = number = -1;
        startDate = endDate = null;
        owner = null;
    }
}
