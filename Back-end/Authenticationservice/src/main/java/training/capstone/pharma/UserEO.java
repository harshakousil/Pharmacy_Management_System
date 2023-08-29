package training.capstone.pharma;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a user entity in the application.
 */
@Document("Users")
public class UserEO {

    @Id
    private String email;

    private String password;

    private String rolename;

    /**
     * Default constructor for the UserEO class.
     */
    public UserEO() {
    }

    /**
     * Parameterized constructor to create a UserEO instance.
     *
     * @param email    The user's email address.
     * @param password The user's password.
     * @param rolename The user's role name.
     */
    public UserEO(String email, String password, String rolename) {
        this.email = email;
        this.password = password;
        this.rolename = rolename;
    }

    /**
     * Get the email address of the user.
     *
     * @return The user's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address of the user.
     *
     * @param email The user's email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the password of the user.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password of the user.
     *
     * @param password The user's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the role name of the user.
     *
     * @return The user's role name.
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * Set the role name of the user.
     *
     * @param rolename The user's role name.
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * Generate a string representation of the UserEO object.
     *
     * @return A string representation of the UserEO object.
     */
    @Override
    public String toString() {
        return "UserEO [email=" + email + ", password=" + password + ", rolename=" + rolename + "]";
    }
}
