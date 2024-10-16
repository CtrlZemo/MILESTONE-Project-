import java.util.List;

public class RemoveProduct {
    public void removeProductByID(int productID, List<Product> productList) {
        boolean removed = productList.removeIf(product -> product.getProductID() == productID);
        if (removed) {
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product ID not found.");
        }
    }
}
