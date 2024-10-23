import java.time.LocalDate;

public class ElectronicsProduct extends Product implements IElectronics {
    private int warrantyPeriod;

    public ElectronicsProduct(int productID, String productName, String category, double price, LocalDate dateEntered, int warrantyPeriod) {
        super(productID, productName, category, price, dateEntered);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public boolean checkWarrantyExpiry() {
        LocalDate warrantyExpiryDate = getDateEntered().plusMonths(warrantyPeriod);
        return LocalDate.now().isAfter(warrantyExpiryDate);
    }

    @Override
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }
}
