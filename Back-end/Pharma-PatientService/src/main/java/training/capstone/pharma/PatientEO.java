
package training.capstone.pharma;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The PatientEO class represents information about a patient.
 */
@Document("patients")
public class PatientEO {
    @Id
    private String email;
    private String name;
    private String password;
    private List<OrderEO> orders;

    /**
     * Default constructor for PatientEO.
     */
    public PatientEO() {
    }

    /**
     * Constructor to initialize PatientEO with values.
     *
     * @param email    The email address of the patient.
     * @param name     The name of the patient.
     * @param password The password of the patient.
     * @param orders   The list of orders associated with the patient.
     */
    public PatientEO(String email, String name, String password, List<OrderEO> orders) {
        super();
        this.email = email;
        this.name = name;
        this.password = password;
        this.orders = orders;
    }

    /**
     * Get the email address of the patient.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address of the patient.
     *
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the name of the patient.
     *
     * @return The name of the patient.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the patient.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the password of the patient.
     *
     * @return The password of the patient.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password of the patient.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the list of orders associated with the patient.
     *
     * @return The list of orders.
     */
    public List<OrderEO> getOrders() {
        return orders;
    }

    /**
     * Set the list of orders associated with the patient.
     *
     * @param orders The list of orders to set.
     */
    public void setOrders(List<OrderEO> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "PatientEO [email=" + email + ", name=" + name + ", password=" + password + ", orders=" + orders + "]";
    }
}
