import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Inputter inputter = new Inputter();
        Displayer displayer = new Displayer();
        RemoveProduct remover = new RemoveProduct();
        UpdateProduct updater = new UpdateProduct();
        
        List<Product> productList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) { // Print Main Menu
            System.out.println("\n|---PRODUCT MANAGER SYSTEM---|");
            
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Display All Products");
            System.out.println("5. Exit Program");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) { // we implement switch case for code simplicity, a bit long but easier to understand
                case 1:
                    // Add a product
                    Product newProduct = inputter.getProductDetails();
                    productList.add(newProduct);
                    System.out.println("Product added successfully.");
                    break;

                case 2:
                    // Update the product
                    System.out.print("Enter product ID to update: ");
                    int updateID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("1. Update Name"); // give options what to update in the product (can add more soon like item number etc)
                    System.out.println("2. Update Price"); // but for simplicity's sake, for now two options only
                    int updateChoice = scanner.nextInt();
                    scanner.nextLine(); 
                    switch (updateChoice) { // switch case for updating name and price
                        case 1:
                            System.out.print("Enter new product name: ");
                            String newName = scanner.nextLine();
                            updater.updateProductName(updateID, newName, productList);
                            System.out.println("Product name updated.");
                            break;
                        case 2:
                            System.out.print("Enter new product price: ");
                            double newPrice = scanner.nextDouble();
                            updater.updateProductPrice(updateID, newPrice, productList);
                            System.out.println("Product price updated.");
                            break;
                        default:
                            System.out.println("Invalid update choice."); // exception if invalid lol
                            break;
                    }
                    break;

                case 3:
                    // Remove a product in the list
                    System.out.print("Enter product ID to remove: ");
                    int removeID = scanner.nextInt();
                    remover.removeProductByID(removeID, productList);
                    System.out.println("Product removed.");
                    break;

                case 4:
                    // Display all products 
                    if (productList.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        displayer.displayAllProducts(productList);
                    }
                    break;

                case 5:
                    // Exit yey
                    running = false;
                    System.out.println("Exiting program.");
                    break;

                default: // exception again if choice invalid
                    System.out.println("Invalid choice, please try again."); 
            }
        }

        scanner.close();
    }
}
