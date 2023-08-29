package training.captone.medicines;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a medicine entity in the application.
 */
@Document("medicines")
public class MedicinesEO {

    @Id
    private Integer medicineId;

    private String medicineName;

    private String medicineDescription;

    private String manufacturerName;

    private String stockQuantity;

    private String unitPrice;

    private Date expiryDate;

    private byte[] image;

    /**
     * Default constructor for the MedicinesEO class.
     */
    public MedicinesEO() {
    }

    /**
     * Parameterized constructor to create a MedicinesEO instance.
     *
     * @param medicineId         The ID of the medicine.
     * @param medicineName       The name of the medicine.
     * @param medicineDescription The description of the medicine.
     * @param manufacturerName   The manufacturer's name of the medicine.
     * @param stockQuantity      The stock quantity of the medicine.
     * @param unitPrice          The unit price of the medicine.
     * @param expiryDate         The expiry date of the medicine.
     * @param image              The image of the medicine.
     */
    public MedicinesEO(Integer medicineId, String medicineName, String medicineDescription, String manufacturerName,
                       String stockQuantity, String unitPrice, Date expiryDate, byte[] image) {
        super();
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.medicineDescription = medicineDescription;
        this.manufacturerName = manufacturerName;
        this.stockQuantity = stockQuantity;
        this.unitPrice = unitPrice;
        this.expiryDate = expiryDate;
        this.image = image;
    }

    /**
     * Get the medicine ID.
     *
     * @return The medicine ID.
     */
    public Integer getMedicineId() {
        return medicineId;
    }

    /**
     * Set the medicine ID.
     *
     * @param medicineId The medicine ID.
     */
    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    /**
     * Get the name of the medicine.
     *
     * @return The name of the medicine.
     */
    public String getMedicineName() {
        return medicineName;
    }

    /**
     * Set the name of the medicine.
     *
     * @param medicineName The name of the medicine.
     */
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    /**
     * Get the description of the medicine.
     *
     * @return The description of the medicine.
     */
    public String getMedicineDescription() {
        return medicineDescription;
    }

    /**
     * Set the description of the medicine.
     *
     * @param medicineDescription The description of the medicine.
     */
    public void setMedicineDescription(String medicineDescription) {
        this.medicineDescription = medicineDescription;
    }

    /**
     * Get the manufacturer's name of the medicine.
     *
     * @return The manufacturer's name of the medicine.
     */
    public String getManufacturerName() {
        return manufacturerName;
    }

    /**
     * Set the manufacturer's name of the medicine.
     *
     * @param manufacturerName The manufacturer's name of the medicine.
     */
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    /**
     * Get the stock quantity of the medicine.
     *
     * @return The stock quantity of the medicine.
     */
    public String getStockQuantity() {
        return stockQuantity;
    }

    /**
     * Set the stock quantity of the medicine.
     *
     * @param stockQuantity The stock quantity of the medicine.
     */
    public void setStockQuantity(String stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    /**
     * Get the unit price of the medicine.
     *
     * @return The unit price of the medicine.
     */
    public String getUnitPrice() {
        return unitPrice;
    }

    /**
     * Set the unit price of the medicine.
     *
     * @param unitPrice The unit price of the medicine.
     */
    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Get the expiry date of the medicine.
     *
     * @return The expiry date of the medicine.
     */
    public Date getExpiryDate() {
        return expiryDate;
    }

    /**
     * Set the expiry date of the medicine.
     *
     * @param expiryDate The expiry date of the medicine.
     */
    public void setExpiryDate(Date expiryDate) {
        Date dateString = expiryDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy:mm:dd");

        try {
            // Now, let's extract year, month, and day to create the equivalent date object
            int year = dateString.getYear(); // Year is 1900-based
            int month = dateString.getMonth();
            int day = dateString.getDate();

            // Create a Date object using the extracted values
            Date convertedDate = new Date(year, month, day);
            this.expiryDate = convertedDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the image of the medicine.
     *
     * @return The image of the medicine.
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * Set the image of the medicine.
     *
     * @param image The image of the medicine.
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     * Generate a string representation of the MedicinesEO object.
     *
     * @return A string representation of the MedicinesEO object.
     */
    @Override
    public String toString() {
        return "MedicinesEO [medicineId=" + medicineId + ", medicineName=" + medicineName + ", medicineDescription="
                + medicineDescription + ", manufacturerName=" + manufacturerName + ", stockQuantity=" + stockQuantity
                + ", unitPrice=" + unitPrice + ", expiryDate=" + expiryDate + ", image="
                + Arrays.toString(image) + "]";
    }
}
