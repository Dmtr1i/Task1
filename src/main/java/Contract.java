import java.time.LocalDate;

public class Contract {
    long id;
    LocalDate startDate;
    LocalDate endDate;
    long number;
    Object owner;
    Contract() {
        id = number = -1;
        startDate = endDate = null;
        owner = null;
    }
}
