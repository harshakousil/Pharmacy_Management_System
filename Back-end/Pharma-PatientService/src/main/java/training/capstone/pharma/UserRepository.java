package training.capstone.pharma;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * The UserRepository interface provides data access operations for managing user information in the database.
 * It extends the MongoRepository interface for MongoDB database access.
 */
@Repository
public interface UserRepository extends MongoRepository<UserEO, String> {
    
    /**
     * Find a user by their email address.
     *
     * @param email The email address of the user to find.
     * @return The UserEO object representing the user, or null if not found.
     */
    @Query("{'email' : ?0}")
    UserEO findByemail(String email);

    /**
     * Save a user object to the database.
     *
     * @param user The UserEO object to save.
     * @return The saved UserEO object.
     */
    @SuppressWarnings("unchecked")
    UserEO save(UserEO user);
}
