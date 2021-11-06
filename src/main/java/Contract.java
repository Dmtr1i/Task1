import java.time.LocalDate;

public class Contract{
    private long id;
    private LocalDate startContract;
    private LocalDate endContract;
    private long number;
    private Person owner;
    Contract(long id, LocalDate start, LocalDate end, long number, Person owner){
        this.id = id;
        this.startContract = start;
        this.endContract = end;
        this.number = number;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }
    public LocalDate getStartContract() {
        return startContract;
    }
    public LocalDate getEndContract() {
        return endContract;
    }
    public long getNumber() {
        return number;
    }
    public Person getOwner() {
        return owner;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setStartContract(LocalDate startContract) {
        this.startContract = startContract;
    }
    public void setEndContract(LocalDate endContract) {
        this.endContract = endContract;
    }
    public void setNumber(long number) {
        this.number = number;
    }
    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
