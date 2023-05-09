import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    public static final List<User> users = new ArrayList<>();

    public static boolean register(String email, String password, String address) {
        // check if email and password meet criteria (e.g. email is valid format, password is strong)
        if (!isValidEmail(email) || !isValidPassword(password)) {
            return false;
        }

        // generate OTP and send to user's email
        String otp = generateOTP();
        sendOTP(email, otp);

        // wait for user to enter OTP
        boolean isVerified = waitForOTP(email, otp);
        if (!isVerified) {
            return false;
        }

        // create new user and add to list
        User user = new User(email, password, address);
        users.add(user);
        return true;
    }

    private static boolean isValidEmail(String email) {
        // TODO: implement email validation logic
        return true;
    }

    private static boolean isValidPassword(String password) {
        // TODO: implement password validation logic
        return true;
    }

    private static String generateOTP() {
        // TODO: generate random OTP and return it as a string
        return "123456";
    }

    private static void sendOTP(String email, String otp) {
        // TODO: send OTP to user's email using email service
    }

    private static boolean waitForOTP(String email, String expectedOTP) {
        // TODO: wait for user to enter OTP and return true if it matches expectedOTP
        return true;
    }
}
