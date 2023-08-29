package training.capstone.pharma;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The PatientServiceImpl class implements the PatientService interface and provides the
 * implementation for managing patient and user data and operations.
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepoRef;

    @Autowired
    private UserRepository userRepoRef;

    /**
     * Add a new patient to the system.
     *
     * @param patient The patient to add.
     * @return The added patient.
     */
    @Override
    public PatientEO addPatient(PatientEO patient) {
        PatientEO patinetDet = patientRepoRef.save(patient);
        return patinetDet;
    }

    /**
     * Find a patient by their ID and include their orders.
     *
     * @param patientId The ID of the patient to find.
     * @return The patient with orders included.
     */
    @Override
    public PatientEO findPatientWithOrdersById(String patientId) {
        PatientEO patientByOrders = patientRepoRef.findByEmail(patientId);
        return patientByOrders;
    }

    /**
     * Find an order by its order ID.
     *
     * @param orderId The ID of the order to find.
     * @return The order with the specified ID.
     */
    @Override
    public OrderEO findOrderById(int orderId) {
        OrderEO orders = patientRepoRef.findOrderById(orderId);
        return orders;
    }

    /**
     * Update the status of an order for a specific patient.
     *
     * @param patientId The ID of the patient.
     * @param orderId   The ID of the order to update.
     * @param newStatus The new status for the order.
     */
    @Override
    public void updateOrderStatus(String patientId, int orderId, String newStatus) {
        PatientEO patient = findPatientWithOrdersById(patientId);
        if (patient != null && patient.getOrders() != null) {
            for (OrderEO order : patient.getOrders()) {
                if (order.getOrderId() == orderId) {
                    order.setStatus(newStatus);
                    patientRepoRef.save(patient);
                    break;
                }
            }
        }
    }

    /**
     * Add a new user to the system.
     *
     * @param user The user to add.
     * @return The added user.
     */
    @Override
    public UserEO addUser(UserEO user) {
        UserEO userDet = userRepoRef.save(user);
        return userDet;
    }

    /**
     * Check if a user with the given email address already exists.
     *
     * @param email The email address to check.
     * @return True if the user exists, false otherwise.
     */
    @Override
    public Boolean IsUser(String email) {
        UserEO userDet = userRepoRef.findByemail(email);
        return userDet != null;
    }

    /**
     * Find a patient by their email address.
     *
     * @param email The email address of the patient to find.
     * @return The patient with the specified email address.
     */
    @Override
    public PatientEO findbyemail(String email) {
        return patientRepoRef.findByEmail(email);
    }

    /**
     * Get a list of all patients in the system.
     *
     * @return The list of all patients.
     */
    @Override
    public List<PatientEO> findAllPatients() {
        List<PatientEO> patientDet = patientRepoRef.findAll();
        return patientDet;
    }

    /**
     * Get the last order ID associated with a patient.
     *
     * @param patientId The ID of the patient to find the last order ID for.
     * @return The last order ID for the patient.
     */
    @Override
    public int getLastOrderid(String patientId) {
        PatientEO PatientDet = patientRepoRef.findByEmail(patientId);
        if (PatientDet != null && PatientDet.getOrders() != null && !PatientDet.getOrders().isEmpty()) {
            OrderEO lastOrder = PatientDet.getOrders().get(PatientDet.getOrders().size() - 1);
            int lastOrderId = lastOrder.getOrderId();
            return lastOrderId + 1;
        } else {
            return 1;
        }
    }
}
