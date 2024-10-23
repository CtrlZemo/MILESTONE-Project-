import java.util.List;

public class SearchProduct {

    // Search for a product by name (case insensitive)
    public Product searchByName(String name, List<Product> productList) {
        for (Product product : productList) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                product.displayProduct();
                return product; 
            }
        }
        return null; 
    }

    // Search for a product by ID
    public Product searchByID(int productID, List<Product> productList) {
        for (Product product : productList) {
            if (product.getProductID() == productID) {
                product.displayProduct();
                return product; 
            }
        }
        return null; 
    }
}
