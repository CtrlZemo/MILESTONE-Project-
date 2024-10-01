import java.util.List;

public class Displayer {

    public void displayAllProducts(List<Product> productList) {
        int perishableCount = 0;
        int electronicsCount = 0;
        int clothingCount = 0;
        int skincareCount = 0;

        System.out.println("\nProducts in inventory:\n");

        // Loop through the product list and count products by category
        for (Product product : productList) {
            switch (product.getCategory()) {
                case "Perishable":
                    System.out.println("Category: Perishable");
                    displayProductInfo(product);
                    perishableCount++;
                    break;
                case "Electronics":
                    System.out.println("Category: Electronics");
                    displayProductInfo(product);
                    electronicsCount++;
                    break;
                case "Clothing":
                    System.out.println("Category: Clothing");
                    displayProductInfo(product);
                    clothingCount++;
                    break;
                case "Skincare":
                    System.out.println("Category: Skincare");
                    displayProductInfo(product);
                    skincareCount++;
                    break;
                default:
                    System.out.println("Unknown category for product: " + product.getProductName());
                    break;
            }
        }

        // prints out number of items IN THAT category
        System.out.println("\nSummary of Products by Category:");
        System.out.println("Perishable Products: " + perishableCount);
        System.out.println("Electronics Products: " + electronicsCount);
        System.out.println("Clothing Products: " + clothingCount);
        System.out.println("Skincare Products: " + skincareCount);

    }

    // print format for displaying item info
    public void displayProductInfo(Product product) {
        System.out.println("Product ID: " + product.getProductID());
        System.out.println("Name: " + product.getProductName());
        System.out.println("Category: " + product.getCategory());
        System.out.println("Price: PHP" + product.getPrice());
        System.out.println("Date Entered: " + product.getDateEntered());

        //if statements to display different and unique attribute of each category
        if (product instanceof PerishableProduct) {
            PerishableProduct perishable = (PerishableProduct) product;
            System.out.println("Shelf Life: " + perishable.getShelfLife() + " days");
            System.out.println("Expiry Date: " + perishable.getDateExpiry());
            System.out.println("Expired: " + (perishable.checkExpiry() ? "Yes" : "No")); // automatically identifies if item is expired or nah

        } else if (product instanceof ElectronicsProduct) {
            ElectronicsProduct electronics = (ElectronicsProduct) product;
            System.out.println("Warranty Period: " + electronics.getWarrantyPeriod() + " years");

        } else if (product instanceof ClothingProduct) {
            ClothingProduct clothing = (ClothingProduct) product;
            System.out.println("Size: " + clothing.getSize());
            System.out.println("Material: " + clothing.getMaterial());

        } else if (product instanceof SkincareProduct) {
            SkincareProduct skincare = (SkincareProduct) product;
            System.out.println("Skin Type Recommendation: " + skincare.getSkinTypeRecommendation());
        }

        System.out.println(); 
    }
}
