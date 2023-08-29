package training.capstone.pharma;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing user data in the database.
 */
@Repository
public interface UserRepository extends MongoRepository<UserEO, String> {

    /**
     * Find a user by their email address.
     *
     * @param email The email address of the user to find.
     * @return The user object if found, or null if not found.
     */
    @Query("{'email': ?0}")
    public UserEO findByEmail(String email);
}
