import java.time.LocalDate;

public interface IPerishable {
    boolean checkExpiry();
    LocalDate getDateExpiry();
}

