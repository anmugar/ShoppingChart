package webapp;

/**
 * Created by AnaBelén on 24/01/2017.
 */
public class UserBean {
    private String username;
    private String password;
    public boolean valid;

    public String getPassword() {
        return password;
    }
    public void setPassword(String newPassword) {
        password = newPassword;
    }
    public String getUsername() {
        return username;
    }
    public void setUserName(String newUsername) {
        username = newUsername;
    }
    public boolean isValid() {
        return valid;
    }
    public void setValid(boolean newValid) {
        valid = newValid;
    }
}