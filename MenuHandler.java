import java.util.List;
import java.util.Scanner;

public class MenuHandler {
    private final Scanner scanner;
    private final Validator validator;
    private final Inputter inputter;
    private final Displayer displayer;
    private final RemoveProduct remover;
    private final UpdateProduct updater;
    private final SearchProduct searcher;
    private final FilterProducts filter;

    public MenuHandler(Validator validator, Inputter inputter, Displayer displayer,
                       RemoveProduct remover, UpdateProduct updater,
                       SearchProduct searcher, FilterProducts filter) {
        this.scanner = new Scanner(System.in);
        this.validator = validator;
        this.inputter = inputter;
        this.displayer = displayer;
        this.remover = remover;
        this.updater = updater;
        this.searcher = searcher;
        this.filter = filter;
    }

    public void handleMenu(List<Product> productList) {
        boolean exit = false;
        while (!exit) {
            Menu menu = new Menu();
            menu.displayMainMenu();

            int choice = validator.validateInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    Product newProduct = inputter.getProductDetails();
                    productList.add(newProduct);
                    System.out.println("Product added successfully.");
                    break;

                case 2:
                    updateProduct(productList);
                    break;

                case 3:
                    removeProduct(productList);
                    break;

                case 4:
                    displayAllProducts(productList);
                    break;

                case 5:
                    displayProductsByCategory(productList);
                    break;

                case 6:
                    searchProduct(productList);
                    break;

                case 7:
                    exit = true;
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
    }

    private void updateProduct(List<Product> productList) {
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
    }

    private void removeProduct(List<Product> productList) {
        int removeId = validator.validateInt("Enter Product ID to remove: ");
        remover.removeProductByID(removeId, productList);
    }

    private void displayAllProducts(List<Product> productList) {
        if (productList.isEmpty()) {
            System.out.println("No products available.");
        } else {
            displayer.displayAllProducts(productList);
        }
    }

    private void displayProductsByCategory(List<Product> productList) {
        System.out.println("\n--Product Categories--\n");
        System.out.println("Enter the NAME of the category you wish to view:");
        System.out.println("(Perishable, Electronics, Clothing, Skincare");
        System.out.print("\nEnter category to view: ");
        String category = scanner.nextLine();
        filter.filterProductsByCategory(category, productList);
    }

    private void searchProduct(List<Product> productList) {
        System.out.println("Search by:");
        System.out.println("1. Item Name");
        System.out.println("2. Item ID");
        System.out.print("Enter your choice: ");
        int searchChoice = validator.validateInt("");

        if (searchChoice == 1) {
            System.out.print("Enter product name to search: ");
            String searchName = scanner.nextLine();
            Product foundProduct = searcher.searchByName(searchName, productList);
            if (foundProduct != null) {
                System.out.println("Product found: " + foundProduct.getProductName());
            } else {
                System.out.println("Product not found.");
            }
        } else if (searchChoice == 2) {
            int searchID = validator.validateInt("Enter product ID to search: ");
            Product foundProductID = searcher.searchByID(searchID, productList);
            if (foundProductID != null) {
                System.out.println("Product found: " + foundProductID.getProductName());
            } else {
                System.out.println("Product not found.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
}

