import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ask user for registration information
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        // attempt registration
        boolean isRegistered = RegistrationService.register(email, password, address);
        if (isRegistered) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed.");
            return;
        }

        // ask user for login information
        System.out.print("Enter email: ");
        String loginEmail = scanner.nextLine();
        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();

        // attempt login
        User user = LoginService.login(loginEmail, loginPassword);

        if (user != null) {
            System.out.println("Login successful!");
            System.out.println("Welcome, " + user.getEmail() + "!");
        } else {

            System.out.println("Login failed.");
        }
    }
}
