public class User {
    private String email;
    private String password;
    private String address;
    private boolean isVerified;
    // other fields as needed

    public User(String email, String password, String address) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.isVerified = false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

}