import java.time.LocalDate;

public class ElectronicsProduct extends Product {
    private int warrantyPeriod;

    public ElectronicsProduct(int productID, String productName, String category, double price, LocalDate dateEntered, int warrantyPeriod) {
        super(productID, productName, category, price, dateEntered);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }
}
