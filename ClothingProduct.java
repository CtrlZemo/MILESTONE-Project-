import java.time.LocalDate;

public class ClothingProduct extends Product implements IClothing {
    private String size;
    private String material;

    public ClothingProduct(int productID, String productName, String category, double price, LocalDate dateEntered, String size, String material) {
        super(productID, productName, category, price, dateEntered);
        this.size = size;
        this.material = material;
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public void getFitRecommendation() {
        System.out.println("Fit recommendation for size: " + size);
    }
}

