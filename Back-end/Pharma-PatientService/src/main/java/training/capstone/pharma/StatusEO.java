
package training.capstone.pharma;
/**
 * The StatusEO class represents an entity for managing the status of an order associated with a patient.
 */
public class StatusEO {
    
    private String email;
    private int orderId;
    private String newStatus;

    /**
     * Default constructor for StatusEO.
     */
    public StatusEO() {
    }

    /**
     * Constructs a StatusEO object with the given parameters.
     *
     * @param email     The email of the patient associated with the order.
     * @param orderId   The unique identifier of the order.
     * @param newStatus The new status to be assigned to the order.
     */
    public StatusEO(String email, int orderId, String newStatus) {
        this.email = email;
        this.orderId = orderId;
        this.newStatus = newStatus;
    }

    /**
     * Get the email of the patient associated with the order.
     *
     * @return The email of the patient.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of the patient associated with the order.
     *
     * @param email The email of the patient.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the unique identifier of the order.
     *
     * @return The order's unique identifier.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Set the unique identifier of the order.
     *
     * @param orderId The order's unique identifier.
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Get the new status to be assigned to the order.
     *
     * @return The new status.
     */
    public String getNewStatus() {
        return newStatus;
    }

    /**
     * Set the new status to be assigned to the order.
     *
     * @param newStatus The new status.
     */
    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "StatusEO [email=" + email + ", orderId=" + orderId + ", newStatus=" + newStatus + "]";
    }
}
