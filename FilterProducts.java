import java.util.List;

public class FilterProducts {
    public void filterProductsByCategory(String category, List<Product> productList) {
        boolean found = false; // To check if any products are found in the category
        for (Product product : productList) {
            if (product.getCategory().equalsIgnoreCase(category)) { // Case insensitive comparison
                product.displayProduct(); // Display the product
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found in the category: " + category);
        }
    }
}
