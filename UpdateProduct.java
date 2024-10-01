import java.util.List;

public class UpdateProduct {
    public void updateProductName(int productID, String newName, List<Product> productList) {
        for (Product product : productList) {
            if (product.productID == productID) {
                product.productName = newName;
                break;
            }
        }
    }

    public void updateProductPrice(int productID, double newPrice, List<Product> productList) {
        for (Product product : productList) {
            if (product.productID == productID) {
                product.price = newPrice;
                break;
            }
        }
    }
}
