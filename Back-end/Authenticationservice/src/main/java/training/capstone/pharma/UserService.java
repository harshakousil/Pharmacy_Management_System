package training.capstone.pharma;

/**
 * A service interface for managing user-related operations.
 */
public interface UserService {
    
    /**
     * Find a user by their email address.
     *
     * @param email The email address of the user to find.
     * @return The user object if found, or null if not found.
     */
    public UserEO findByEmail(String email);

    /**
     * Add a new user to the system.
     *
     * @param user The user object to be added.
     * @return The added user object.
     */
    public UserEO addUser(UserEO user);
}
