package training.capstone.pharma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the UserService interface for managing user-related operations.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = true)
    private UserRepository userRepoRef;

    /**
     * Find a user by their email address.
     *
     * @param email The email address of the user to find.
     * @return The user object if found, or null if not found.
     */
    @Override
    public UserEO findByEmail(String email) {
        return userRepoRef.findByEmail(email);
    }

    /**
     * Add a new user to the system.
     *
     * @param user The user object to be added.
     * @return The added user object.
     */
    @Override
    public UserEO addUser(UserEO user) {
        return userRepoRef.save(user);
    }
}
