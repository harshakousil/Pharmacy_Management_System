
package training.capstone.pharma;
import org.springframework.data.annotation.Id;

/**
 * The MedicinesEO class represents information about medicines.
 */
public class MedicinesEO {
    @Id
    private Integer medicineId;

    private String medicineName;
    private String manufacturerName;
    private String quantity_ordered;
    private String unitPrice;
    private String isAvaible;

    /**
     * Default constructor for MedicinesEO.
     */
    public MedicinesEO() {
    }

    /**
     * Constructor to initialize MedicinesEO with values.
     *
     * @param medicineId      The ID of the medicine.
     * @param medicineName    The name of the medicine.
     * @param manufacturerName The name of the manufacturer.
     * @param quantity_ordered The quantity ordered.
     * @param unitPrice       The unit price of the medicine.
     * @param isAvaible       Availability status of the medicine.
     */
    public MedicinesEO(Integer medicineId, String medicineName, String manufacturerName, String quantity_ordered,
                       String unitPrice, String isAvaible) {
        super();
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.manufacturerName = manufacturerName;
        this.quantity_ordered = quantity_ordered;
        this.unitPrice = unitPrice;
        this.isAvaible = isAvaible;
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
     * @param medicineId The medicine ID to set.
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
     * @param medicineName The name of the medicine to set.
     */
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    /**
     * Get the name of the manufacturer.
     *
     * @return The name of the manufacturer.
     */
    public String getManufacturerName() {
        return manufacturerName;
    }

    /**
     * Set the name of the manufacturer.
     *
     * @param manufacturerName The name of the manufacturer to set.
     */
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    /**
     * Get the quantity ordered.
     *
     * @return The quantity ordered.
     */
    public String getQuantity_ordered() {
        return quantity_ordered;
    }

    /**
     * Set the quantity ordered.
     *
     * @param quantity_ordered The quantity ordered to set.
     */
    public void setQuantity_ordered(String quantity_ordered) {
        this.quantity_ordered = quantity_ordered;
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
     * @param unitPrice The unit price to set.
     */
    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Get the availability status of the medicine.
     *
     * @return The availability status of the medicine.
     */
    public String getIsAvaible() {
        return isAvaible;
    }

    /**
     * Set the availability status of the medicine.
     *
     * @param isAvaible The availability status to set.
     */
    public void setIsAvaible(String isAvaible) {
        this.isAvaible = isAvaible;
    }

    @Override
    public String toString() {
        return "MedicinesEO [medicineId=" + medicineId + ", medicineName=" + medicineName + ", manufacturerName="
                + manufacturerName + ", quantity_ordered=" + quantity_ordered + ", unitPrice=" + unitPrice
                + ", isAvaible=" + isAvaible + "]";
    }
}
