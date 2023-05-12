public class LoginService {
   // Attempts to log in a user with the specified email and password.

    public static User login(String email, String password) {
        // Loop through all registered users to find a match for the given email and password

        for (User user : RegistrationService.users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                // Return the user object if a match is found

                return user;
            }
        }
        // If no match is found, print an error message and return null

        System.out.println("Invalid email or password. Please try again.");
        return null;
    }
}