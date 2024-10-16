import java.util.Scanner;
import java.time.LocalDate;

public class Inputter {
    private Scanner scanner = new Scanner(System.in);
    private Validator validator = new Validator(); // call our validator class 
    // user promt method to enter basic info abt the product 
    public Product getProductDetails() { 
        int id = validator.validateInt("Enter Product ID: ");
        String name = validator.validateString("Enter Product Name: ");
        double price = validator.validateDouble("Enter Price: ");
        // Further input can be added based on category (Perishable, Electronics, etc.)
        // For example, for perishable products:
        LocalDate dateEntered = LocalDate.now();

        // switch case again for indicating what category the item belongs to for easier identification when displaying
        System.out.println("\nChoose category:");
        System.out.println("1. Perishable");
        System.out.println("2. Electronics");
        System.out.println("3. Clothing");
        System.out.println("4. Skincare");
        int categoryChoice = validator.validateInt("Enter category[1-4]: ");

        switch (categoryChoice) {
            case 1:
                return addPerishableProduct(id, name, price, dateEntered);
            case 2:
                return addElectronicsProduct(id, name, price, dateEntered);
            case 3:
                return addClothingProduct(id, name, price, dateEntered);
            case 4:
                return addSkincareProduct(id, name, price, dateEntered);
            default:
                System.out.println("Invalid category, defaulting to generic product.");
                return new Product(id, name, "Unknown", price, dateEntered);
        }
    }

    //all items have 4 basic info such as id, name, price, date entered BUTTTT once category has been selected each(not all) item will have extra info prompts
    // UPDATED all of these have input validation now on dates, int , and double inputs
    private PerishableProduct addPerishableProduct(int id, String name, double price, LocalDate dateEntered) {
        LocalDate expiryDate = validator.validateDate("Enter expiry date (YYYY-MM-DD): ");
        int shelfLife = validator.validateInt("Enter shelf life (in days): ");
        //returns item info + additional info same goes to the rest of the priv methods following this one
        return new PerishableProduct(id, name, "Perishable", price, dateEntered, expiryDate, shelfLife);
    }

    private ElectronicsProduct addElectronicsProduct(int id, String name, double price, LocalDate dateEntered) {
        int warranty = validator.validateInt("Enter warranty period (in months): ");
        return new ElectronicsProduct(id, name, "Electronics", price, dateEntered, warranty);
    }

    private ClothingProduct addClothingProduct(int id, String name, double price, LocalDate dateEntered) {
        System.out.print("Enter size(xs, s, m, l, xl, xxl): ");
        String size = scanner.nextLine();
        System.out.print("Enter material: ");
        String material = scanner.nextLine();
        return new ClothingProduct(id, name, "Clothing", price, dateEntered, size, material);
    }

    private SkincareProduct addSkincareProduct(int id, String name, double price, LocalDate dateEntered) {
        System.out.print("Enter skin type recommendation: ");
        String skinType = scanner.nextLine();
        return new SkincareProduct(id, name, "Skincare", price, dateEntered, skinType);
    }

}
