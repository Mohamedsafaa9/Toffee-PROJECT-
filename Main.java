import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Use try-with-resources to ensure that the Scanner object is properly closed.
        try (Scanner scanner = new Scanner(System.in)) {
            // Ask user for registration information
            System.out.print("Enter email for registration: ");
            String registrationEmail = scanner.nextLine();
            System.out.print("Enter password for registration: ");
            String registrationPassword = scanner.nextLine();
            System.out.print("Enter address for registration: ");
            String registrationAddress = scanner.nextLine();

            // Attempt registration
            boolean isRegistered = RegistrationService.register(registrationEmail, registrationPassword, registrationAddress);
            if (isRegistered) {
                System.out.println("Registration successful!");
            } else {
                System.out.println("Registration failed.");
                return;
            }

            // Ask user for login information
            System.out.print("Enter email for login: ");
            String loginEmail = scanner.nextLine();
            System.out.print("Enter password for login: ");
            String loginPassword = scanner.nextLine();

            // Attempt login
            User user = LoginService.login(loginEmail, loginPassword);

            if (user != null) {
                System.out.println("Login successful!");
                System.out.println("Welcome, " + user.getEmail() + "!");
            } else {
                System.out.println("Login failed.");
            }
        } catch (Exception e) {
            // Handle any exceptions that might occur
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
