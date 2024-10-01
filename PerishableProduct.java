import java.time.LocalDate;

public class PerishableProduct extends Product {
    private LocalDate dateExpiry;
    private int shelfLife;

    public PerishableProduct(int productID, String productName, String category, double price, LocalDate dateEntered, LocalDate dateExpiry, int shelfLife) {
        super(productID, productName, category, price, dateEntered);
        this.dateExpiry = dateExpiry;
        this.shelfLife = shelfLife;
    }

    public boolean checkExpiry() {
        return LocalDate.now().isAfter(dateExpiry);
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public LocalDate getDateExpiry() {
        return dateExpiry;
    }
}

