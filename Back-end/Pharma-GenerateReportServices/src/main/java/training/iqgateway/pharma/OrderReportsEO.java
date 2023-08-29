package training.iqgateway.pharma;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Represents an order report entity in the application.
 */
@Document("OrderReports")
public class OrderReportsEO {

    // Status of the order
    private String status;

    // Name of the medicine in the order
    private String medicineName;

    // Dosage of the medicine
    private String dosage;

    // Name of the retailer
    private String retailerName;

    // Date the order was placed
    private Date orderDate;

    // Delivery address for the order
    private String deliveryAddress;

    // Quantity of medicine in the order
    private String quantity;

    // Special instructions for the order
    private String instructions;

    /**
     * Default constructor for the OrderReportsEO class.
     */
    public OrderReportsEO() {
    }

    /**
     * Parameterized constructor to create an OrderReportsEO instance.
     *
     * @param status          The status of the order.
     * @param medicineName    The name of the medicine in the order.
     * @param dosage          The dosage of the medicine.
     * @param retailerName    The name of the retailer.
     * @param orderDate       The date the order was placed.
     * @param deliveryAddress The delivery address for the order.
     * @param quantity        The quantity of medicine in the order.
     * @param instructions    Special instructions for the order.
     */
    public OrderReportsEO(String status, String medicineName, String dosage, String retailerName, Date orderDate,
                          String deliveryAddress, String quantity, String instructions) {
        this.status = status;
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.retailerName = retailerName;
        this.orderDate = orderDate;
        this.deliveryAddress = deliveryAddress;
        this.quantity = quantity;
        this.instructions = instructions;
    }

    /**
     * Get the status of the order.
     *
     * @return The status of the order.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the status of the order.
     *
     * @param status The status of the order.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the name of the medicine in the order.
     *
     * @return The name of the medicine in the order.
     */
    public String getMedicineName() {
        return medicineName;
    }

    /**
     * Set the name of the medicine in the order.
     *
     * @param medicineName The name of the medicine in the order.
     */
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    /**
     * Get the dosage of the medicine.
     *
     * @return The dosage of the medicine.
     */
    public String getDosage() {
        return dosage;
    }

    /**
     * Set the dosage of the medicine.
     *
     * @param dosage The dosage of the medicine.
     */
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    /**
     * Get the name of the retailer.
     *
     * @return The name of the retailer.
     */
    public String getRetailerName() {
        return retailerName;
    }

    /**
     * Set the name of the retailer.
     *
     * @param retailerName The name of the retailer.
     */
    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }

    /**
     * Get the date the order was placed.
     *
     * @return The date the order was placed.
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Set the date the order was placed.
     *
     * @param orderDate The date the order was placed.
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Get the delivery address for the order.
     *
     * @return The delivery address for the order.
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * Set the delivery address for the order.
     *
     * @param deliveryAddress The delivery address for the order.
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * Get the quantity of medicine in the order.
     *
     * @return The quantity of medicine in the order.
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of medicine in the order.
     *
     * @param quantity The quantity of medicine in the order.
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * Get special instructions for the order.
     *
     * @return Special instructions for the order.
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * Set special instructions for the order.
     *
     * @param instructions Special instructions for the order.
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    /**
     * Generate a string representation of the OrderReportsEO object.
     *
     * @return A string representation of the OrderReportsEO object.
     */
    @Override
    public String toString() {
        return "OrderReportsEO [status=" + status + ", medicineName=" + medicineName + ", dosage=" + dosage +
                ", retailerName=" + retailerName + ", orderDate=" + orderDate + ", deliveryAddress=" +
                deliveryAddress + ", quantity=" + quantity + ", instructions=" + instructions + "]";
    }
}
