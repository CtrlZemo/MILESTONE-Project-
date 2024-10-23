import java.time.LocalDate;

public class SkincareProduct extends Product implements ISkincare {
    private String skinTypeRecommendation;

    public SkincareProduct(int productID, String productName, String category, double price, LocalDate dateEntered, String skinTypeRecommendation) {
        super(productID, productName, category, price, dateEntered);
        this.skinTypeRecommendation = skinTypeRecommendation;
    }

    @Override
    public String getSkinTypeRecommendation() {
        return skinTypeRecommendation;
    }

    @Override
    public void getUsageInstructions() {
        System.out.println("Usage instructions for " + getProductName() + ": Suitable for " + skinTypeRecommendation + " skin.");
    }
}

