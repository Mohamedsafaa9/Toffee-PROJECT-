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

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }
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

    private static String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return Integer.toString(otp);
    }

    private static void sendOTP(String email, String otp) {
        String subject = "OTP for registration";
        String message = "Your OTP for registration is: " + otp;

        String senderEmail = "your-email@example.com"; // replace with your own email address
        String senderPassword = "your-email-password"; // replace with your own email password

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com"); // replace with your own SMTP server address
        properties.put("mail.smtp.port", "587"); // replace with your own SMTP server port

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(senderEmail));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            emailMessage.setSubject(subject);
            emailMessage.setText(message);

            Transport.send(emailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    private static boolean waitForOTP(String email, String expectedOTP) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter OTP sent to " + email + ": ");
        String enteredOTP = scanner.nextLine();

        return enteredOTP.equals(expectedOTP);
    }

