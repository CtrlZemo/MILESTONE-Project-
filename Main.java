import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        Inputter inputter = new Inputter();
        Validator validator = new Validator(); // To validate user inputs
        Displayer displayer = new Displayer();
        RemoveProduct remover = new RemoveProduct();
        UpdateProduct updater = new UpdateProduct();
        SearchProduct searcher = new SearchProduct();
        FilterProducts filter = new FilterProducts(); // Create an instance of Filter

        
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) { // Print Main Menu
            System.out.println("\n|---PRODUCT MANAGER SYSTEM---|");
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Display All Products");
            System.out.println("5. Display Products by Category"); // 1st mew option
            System.out.println("6. Search Product"); // 2nd new option 
            System.out.println("7. Exit Program");            
            int choice = validator.validateInt("Enter your choice: "); // Validate user choice

            switch (choice) { // we implement switch case for code simplicity, a bit long but easier to understand
                case 1:
                    // Add a product
                    Product newProduct = inputter.getProductDetails();
                    productList.add(newProduct);
                    System.out.println("Product added successfully.");
                    break;

                case 2:
                    // Update the product
                    int updateId = validator.validateInt("Enter Product ID to update: ");
                    System.out.println("1. Update Name");
                    System.out.println("2. Update Price");
                    int updateChoice = validator.validateInt("Enter your choice: ");
                    
                    if (updateChoice == 1) {
                        String newName = validator.validateString("Enter new Product Name: ");
                        updater.updateProductName(updateId, newName, productList);
                        System.out.println("Product name updated successfully.");
                    } else if (updateChoice == 2) {
                        double newPrice = validator.validateDouble("Enter new Product Price: ");
                        updater.updateProductPrice(updateId, newPrice, productList);
                        System.out.println("Product price updated successfully.");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 3:
                    // Remove a product in the list
                    int removeId = validator.validateInt("Enter Product ID to remove: ");
                    remover.removeProductByID(removeId, productList);
                    System.out.println("Product removed successfully.");
                    break;

                case 4:
                    // Display all products 
                    if (productList.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        displayer.displayAllProducts(productList);
                    }
                    break;

                case 5: // Display products by category
                    System.out.println("\n--Product Categories--\n");
                    System.out.println("Enter the NAME of the category you wish to view:");
                    System.out.println("(Perishable, Electronics, Clothing, Skincare");
                    System.out.print("\nEnter category to view: ");
                    String category = scanner.nextLine(); 
                    filter.filterProductsByCategory(category, productList);
                    break;

                case 6:
                    // Search functionality
                    System.out.println("Search by:");
                    System.out.println("1. Item Name");
                    System.out.println("2. Item ID");
                    System.out.print("Enter your choice: ");
                    int searchChoice = validator.validateInt(""); // Use validator for input

                    if (searchChoice == 1) {
                        System.out.print("Enter product name to search: ");
                        String searchName = scanner.nextLine();
                        Product foundProduct = searcher.searchByName(searchName, productList);
                        if (foundProduct != null) {
                            System.out.println("Product found: " + foundProduct.getProductName());
                            System.out.println();
                        } else {
                            System.out.println("Product not found.");
                        }
                    } else if (searchChoice == 2) {
                        int searchID = validator.validateInt("Enter product ID to search: "); // Use validator for input
                        Product foundProductID = searcher.searchByID(searchID, productList);
                        if (foundProductID != null) {
                            System.out.println("Product found: " + foundProductID.getProductName());
                        } else {
                            System.out.println("Product not found.");
                        }
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                

                case 7:
                    // Exit yey
                    exit = true;
                    System.out.println("Exiting program.");
                    break;

                default: // exception again if choice invalid
                    System.out.println("Invalid choice, please try again."); 
            }
        }

        scanner.close();
    }
}
