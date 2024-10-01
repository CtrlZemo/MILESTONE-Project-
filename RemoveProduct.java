import java.util.List;

public class RemoveProduct {
    public void removeProductByID(int productID, List<Product> productList) {
        productList.removeIf(product -> product.productID == productID);
    }
}
