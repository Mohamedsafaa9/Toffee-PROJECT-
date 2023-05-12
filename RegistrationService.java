import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    // list to store all registered users

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

    //Checks if the given email is in a valid format e
    // return true if the email is in a valid format, false otherwise
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }

    /*     * Checks if the given password is strong (i.e. at least 8 characters long and contains at least one lowercase letter,
     * one uppercase letter, one digit and one special character)
        return true if the password is strong, false otherwise
     */
    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasLowercase = false;
        boolean hasUppercase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else {
                hasSpecialChar = true;
            }
        }
        return hasLowercase && hasUppercase && hasNumber && hasSpecialChar;
    }
 // Generates a random 6-digit OTP
    private static String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return Integer.toString(otp);
    }

    //Sends the OTP to the given email using SMTP protocol
    private static void sendOTP(String email, String otp) {
        // email subject and message

        String subject = "OTP for registration";
        String message = "Your OTP for registration is: " + otp;
        // replace with your own email address and password

        String senderEmail = "your-email@example.com"; // replace with your own email address
        String senderPassword = "your-email-password"; // replace with your own email password
        // configure email server properties

        Properties properties = new Properties(); // Create a new Properties object
        properties.put("mail.smtp.auth", "true"); // Set the "mail.smtp.auth" property to "true" to enable authentication
        properties.put("mail.smtp.starttls.enable", "true"); // Set the "mail.smtp.starttls.enable" property to "true" to enable STARTTLS
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Set the "mail.smtp.host" property to the SMTP server address (in this case, "smtp.gmail.com")
        properties.put("mail.smtp.port", "587"); // Set the "mail.smtp.port" property to the SMTP server port (in this case, "587")

// create a new session with the SMTP server

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        // create a new email message and set the recipient, subject, and message content

        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(senderEmail));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            emailMessage.setSubject(subject);
            emailMessage.setText(message);
            // send the email message

            Transport.send(emailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

// method to wait for the user to enter the OTP and return true if it matches the expected OTP

    private static boolean waitForOTP(String email, String expectedOTP) {
        Scanner scanner = new Scanner(System.in);
        // prompt the user to enter the OTP

        System.out.print("Enter OTP sent to " + email + ": ");
        String enteredOTP = scanner.nextLine();
        // compare the entered OTP with the expected OTP and return the result

        return enteredOTP.equals(expectedOTP);
    }

