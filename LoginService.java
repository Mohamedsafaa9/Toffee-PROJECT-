public class LoginService {
    public static User login(String email, String password) {
        for (User user : RegistrationService.users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
