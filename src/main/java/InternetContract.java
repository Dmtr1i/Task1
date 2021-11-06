import java.time.LocalDate;

public class InternetContract extends Contract {
    private int connectionSpeed;
    InternetContract(long id, LocalDate start, LocalDate end, long number, Person owner, int speed){
        super(id, start, end, number, owner);
        this.connectionSpeed = speed;
    }
    public int getConnectionSpeed() {
        return connectionSpeed;
    }

    public void setConnectionSpeed(int connectionSpeed) {
        this.connectionSpeed = connectionSpeed;
    }
}
