
package training.capstone.pharma;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The UserEO class represents an entity for managing user information in the system.
 */
@Document("Users")
public class UserEO {
    
    @Id
    private String email;
    private String password;
    private String rolename;

    /**
     * Default constructor for UserEO.
     */
    public UserEO() {
    }

    /**
     * Constructs a UserEO object with the given parameters.
     *
     * @param email     The email address of the user.
     * @param password  The password associated with the user's account.
     * @param rolename  The role name or user type of the user (e.g., "Patient").
     */
    public UserEO(String email, String password, String rolename) {
        this.email = email;
        this.password = password;
        this.rolename = rolename;
    }

    /**
     * Get the email address of the user.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address of the user.
     *
     * @param email The email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the password associated with the user's account.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password associated with the user's account.
     *
     * @param password The user's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the role name or user type of the user.
     *
     * @return The user's role name (e.g., "Patient").
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * Set the role name or user type of the user.
     *
     * @param rolename The user's role name (e.g., "Patient").
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "UserEO [email=" + email + ", password=" + password + ", rolename=" + rolename + "]";
    }
}
