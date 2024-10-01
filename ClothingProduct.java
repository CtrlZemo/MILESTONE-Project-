import java.time.LocalDate;

public class ClothingProduct extends Product {
    private String size;
    private String material;

    public ClothingProduct(int productID, String productName, String category, double price, LocalDate dateEntered, String size, String material) {
        super(productID, productName, category, price, dateEntered);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    public void getFitRecommendation() {
        System.out.println("Fit recommendation for size: " + size);
    }
}
