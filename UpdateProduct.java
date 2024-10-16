import java.util.List;

public class UpdateProduct {
    public void updateProductName(int productID, String newName, List<Product> productList) {
        for (Product product : productList) {
            if (product.getProductID() == productID) {
                product.setProductName(newName); // Assuming you have a setter
                return; // Exit after updating
            }
        }
        System.out.println("Product ID not found.");
    }

    public void updateProductPrice(int productID, double newPrice, List<Product> productList) {
        for (Product product : productList) {
            if (product.getProductID() == productID) {
                product.setPrice(newPrice); // Assuming you have a setter
                return; // Exit after updating
            }
        }
        System.out.println("Product ID not found.");
    }
}
