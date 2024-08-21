import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, String> userDatabase = new HashMap<>();
    private static final String GRAPHICAL_PASSWORD = "secureGraphicalCode"; // Example graphical password

    static {
        // Example users
        userDatabase.put("Manjusha", "Manjusha@123");
        userDatabase.put("Anshu", "Anshu@123");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Simple Authentication System");
        boolean running = true;

        while (running) {
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1 or 2.");
            }
        }

        scanner.close();
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            System.out.println("Login successful!");
            if (askForGraphicalPassword(scanner)) {
                System.out.println("Graphical password correct. Access granted.");
            } else {
                System.out.println("Incorrect graphical password.");
            }
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static boolean askForGraphicalPassword(Scanner scanner) {
        System.out.print("Enter graphical password: ");
        String input = scanner.nextLine();
        return GRAPHICAL_PASSWORD.equals(input);
    }
}
