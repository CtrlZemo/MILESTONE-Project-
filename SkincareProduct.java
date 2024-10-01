import java.time.LocalDate;

public class SkincareProduct extends Product {
    private String skinTypeRecommendation;

    public SkincareProduct(int productID, String productName, String category, double price, LocalDate dateEntered, String skinTypeRecommendation) {
        super(productID, productName, category, price, dateEntered);
        this.skinTypeRecommendation = skinTypeRecommendation;
    }

    public String getSkinTypeRecommendation() {
        return skinTypeRecommendation;
    }

    public void getUsageInstructions() {
        System.out.println("Usage instructions for " + productName + ": Suitable for " + skinTypeRecommendation + " skin.");
    }
}
