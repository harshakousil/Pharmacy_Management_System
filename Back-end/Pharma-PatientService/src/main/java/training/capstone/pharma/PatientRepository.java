

package training.capstone.pharma;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * The PatientRepository interface provides data access methods for managing patient data in the database.
 */
public interface PatientRepository extends MongoRepository<PatientEO, String> {

    /**
     * Find a patient by their email address.
     *
     * @param email The email address of the patient to find.
     * @return The patient with the specified email address.
     */
    @Query("{ '_id' : ?0 }")
    PatientEO findByEmail(String email);

    /**
     * Save a patient to the database.
     *
     * @param patient The patient to save.
     * @return The saved patient.
     */
    @SuppressWarnings("unchecked")
    PatientEO save(PatientEO patient);

    /**
     * Find a patient by their email address and include their orders.
     *
     * @param email The email address of the patient to find.
     * @return The patient with orders included.
     */
    @Query(value = "{ '_id': ?0 }")
    PatientEO findPatientWithOrdersById(String email);

    /**
     * Find an order by its order ID.
     *
     * @param orderId The ID of the order to find.
     * @return The order with the specified ID.
     */
    @Query(value = "{ 'orders._id': ?0 }", fields = "{ 'orders.$': 1 }")
    OrderEO findOrderById(int orderId);

    /**
     * Find the last order ID associated with a patient.
     *
     * @param patientId The ID of the patient to find the last order ID for.
     * @return The patient with the last order ID.
     */
    @Query(value = "{'patientId': ?0}, {'orders': { $slice: -1 }, 'orders.id': 1}")
    PatientEO findLastOrderIdByPatientId(String patientId);
}

