package training.capstone.pharma;

import java.util.List;

/**
 * The PatientService interface defines the contract for managing patient and user data and operations.
 */
public interface PatientService {

    /**
     * Add a new patient to the system.
     *
     * @param patient The patient to add.
     * @return The added patient.
     */
    public PatientEO addPatient(PatientEO patient);

    /**
     * Add a new user to the system.
     *
     * @param user The user to add.
     * @return The added user.
     */
    public UserEO addUser(UserEO user);

    /**
     * Find a patient by their email address.
     *
     * @param email The email address of the patient to find.
     * @return The patient with the specified email address.
     */
    public PatientEO findbyemail(String email);

    /**
     * Check if a user with the given email address already exists.
     *
     * @param email The email address to check.
     * @return True if the user exists, false otherwise.
     */
    public Boolean IsUser(String email);

    /**
     * Find a patient by their ID and include their orders.
     *
     * @param patientId The ID of the patient to find.
     * @return The patient with orders included.
     */
    public PatientEO findPatientWithOrdersById(String patientId);

    /**
     * Find an order by its order ID.
     *
     * @param orderId The ID of the order to find.
     * @return The order with the specified ID.
     */
    public OrderEO findOrderById(int orderId);

    /**
     * Get a list of all patients in the system.
     *
     * @return The list of all patients.
     */
    public List<PatientEO> findAllPatients();

    /**
     * Get the last order ID associated with a patient.
     *
     * @param patientId The ID of the patient to find the last order ID for.
     * @return The last order ID for the patient.
     */
    public int getLastOrderid(String patientId);

    /**
     * Update the status of an order for a specific patient.
     *
     * @param patientId The ID of the patient.
     * @param orderId   The ID of the order to update.
     * @param newStatus The new status for the order.
     */
    public void updateOrderStatus(String patientId, int orderId, String newStatus);
}
