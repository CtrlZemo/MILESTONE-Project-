import java.time.LocalDate;

public class Product { // encapsulated parent class storing basic information abt the product
    protected int productID;
    protected String productName;
    protected String category;
    protected double price;
    protected LocalDate dateEntered;
    
    public Product(int productID, String productName, String category, double price, LocalDate dateEntered) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.dateEntered = dateEntered;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getDateEntered() {
        return dateEntered;
    }

    public void displayProduct() {
        System.out.println("Product ID: " + productID + ", Name: " + productName + ", Category: " + category + ", Price: PHP" + price);
    }

    // Setter methods for updating product
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
