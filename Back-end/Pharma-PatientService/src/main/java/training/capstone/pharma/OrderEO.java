
package training.capstone.pharma;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;

/**
 * The OrderEO class represents information about an order.
 */
public class OrderEO {
    @Id
    private int orderId;

    private Date orderDate;
    private Date deliveryDate;
    private String status;
    private List<MedicinesEO> medicines;

    /**
     * Default constructor for OrderEO.
     */
    public OrderEO() {
    }

    /**
     * Constructor to initialize OrderEO with values.
     *
     * @param orderId      The ID of the order.
     * @param orderDate    The date when the order was placed.
     * @param deliveryDate The expected delivery date of the order.
     * @param status       The status of the order.
     * @param medicines    The list of medicines in the order.
     */
    public OrderEO(int orderId, Date orderDate, Date deliveryDate, String status, List<MedicinesEO> medicines) {
        super();
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
        this.medicines = medicines;
    }

    /**
     * Get the order ID.
     *
     * @return The order ID.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Set the order ID.
     *
     * @param orderId The order ID to set.
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Get the date when the order was placed.
     *
     * @return The order date.
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Set the date when the order was placed.
     *
     * @param orderDate The order date to set.
     */
    public void setOrderDate(Date orderDate) {
        // Convert the date to a proper format
        Date dateString = orderDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy:mm:dd");

        try {
            int year = dateString.getYear(); // Year is 1900-based
            int month = dateString.getMonth();
            int day = dateString.getDate();

            Date convertedDate = new Date(year, month, day);
            this.orderDate = convertedDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the expected delivery date of the order.
     *
     * @return The delivery date.
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Set the expected delivery date of the order.
     *
     * @param deliveryDate The delivery date to set.
     */
    public void setDeliveryDate(Date deliveryDate) {
        // Convert the date to a proper format
        Date dateString = orderDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy:mm:dd");

        try {
            int year = dateString.getYear(); // Year is 1900-based
            int month = dateString.getMonth();
            int day = dateString.getDate();

            Date convertedDate = new Date(year, month, day);
            this.deliveryDate = convertedDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the status of the order.
     *
     * @return The order status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the status of the order.
     *
     * @param status The order status to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the list of medicines in the order.
     *
     * @return The list of medicines.
     */
    public List<MedicinesEO> getMedicines() {
        return medicines;
    }

    /**
     * Set the list of medicines in the order.
     *
     * @param medicines The list of medicines to set.
     */
    public void setMedicines(List<MedicinesEO> medicines) {
        this.medicines = medicines;
    }

    @Override
    public String toString() {
        return "OrderEO [orderId=" + orderId + ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate
                + ", status=" + status + ", medicines=" + medicines + "]";
    }
}
