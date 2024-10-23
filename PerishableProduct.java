import java.time.LocalDate;

public class PerishableProduct extends Product implements IPerishable {
    private LocalDate dateExpiry;
    private int shelfLife;

    public PerishableProduct(int productID, String productName, String category, double price, LocalDate dateEntered, LocalDate dateExpiry, int shelfLife) {
        super(productID, productName, category, price, dateEntered);
        this.dateExpiry = dateExpiry;
        this.shelfLife = shelfLife;
    }

    @Override
    public boolean checkExpiry() {
        return LocalDate.now().isAfter(dateExpiry);
    }

    @Override
    public LocalDate getDateExpiry() {
        return dateExpiry;
    }

    public int getShelfLife() {
        return shelfLife;
    }
}


