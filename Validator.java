import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validator {
    
    private Scanner scanner = new Scanner(System.in);

    // Validate integer input
    public int validateInt(String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine(); 
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); 
            }
        }
        return value;
    }

    // Validate double input
    public double validateDouble(String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                scanner.nextLine(); 
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); 
            }
        }
        return value;
    }

    // Validate string input (non-empty)
    public String validateString(String prompt) {
        String value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a non-empty string.");
            }
        }
        return value;
    }

    // Validate date input
    public LocalDate validateDate(String prompt) {
        LocalDate date;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                date = LocalDate.parse(input);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        }
        return date;
    }
}
