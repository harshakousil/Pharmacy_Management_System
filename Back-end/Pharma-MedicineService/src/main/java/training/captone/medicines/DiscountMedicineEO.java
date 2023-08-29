package training.captone.medicines;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents discounted medicines and their associated details.
 */
@Document("DiscountedMedicines")
public class DiscountMedicineEO {

    // Name of the discount scheme
    private String schemeName;

    // Type of discount scheme (e.g., percentage-based)
    private String schemeType;

    // Value of the discount scheme (e.g., 40%)
    private String schemeValue;

    // Start date of the discount scheme
    private Date fromDate;

    // End date of the discount scheme
    private Date toDate;

    // List of medicines included in the discount scheme
    private List<MedicinesEO> medicines;

    /**
     * Default constructor for the DiscountMedicineEO class.
     */
    public DiscountMedicineEO() {
    }

    /**
     * Parameterized constructor to create a DiscountMedicineEO instance.
     *
     * @param schemeName  The name of the discount scheme.
     * @param schemeType  The type of discount scheme (e.g., percentage-based).
     * @param schemeValue The value of the discount scheme (e.g., 40%).
     * @param fromDate    The start date of the discount scheme.
     * @param toDate      The end date of the discount scheme.
     * @param medicines   List of medicines included in the discount scheme.
     */
    public DiscountMedicineEO(String schemeName, String schemeType, String schemeValue, Date fromDate, Date toDate,
                              List<MedicinesEO> medicines) {
        this.schemeName = schemeName;
        this.schemeType = schemeType;
        this.schemeValue = schemeValue;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.medicines = medicines;
    }

    /**
     * Get the name of the discount scheme.
     *
     * @return The name of the discount scheme.
     */
    public String getSchemeName() {
        return schemeName;
    }

    /**
     * Set the name of the discount scheme.
     *
     * @param schemeName The name of the discount scheme.
     */
    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    /**
     * Get the type of the discount scheme.
     *
     * @return The type of the discount scheme.
     */
    public String getSchemeType() {
        return schemeType;
    }

    /**
     * Set the type of the discount scheme.
     *
     * @param schemeType The type of the discount scheme.
     */
    public void setSchemeType(String schemeType) {
        this.schemeType = schemeType;
    }

    /**
     * Get the value of the discount scheme.
     *
     * @return The value of the discount scheme.
     */
    public String getSchemeValue() {
        return schemeValue;
    }

    /**
     * Set the value of the discount scheme.
     *
     * @param schemeValue The value of the discount scheme.
     */
    public void setSchemeValue(String schemeValue) {
        this.schemeValue = schemeValue;
    }

    /**
     * Get the start date of the discount scheme.
     *
     * @return The start date of the discount scheme.
     */
    public Date getFromDate() {
        return fromDate;
    }

    /**
     * Set the start date of the discount scheme.
     *
     * @param fromDate The start date of the discount scheme.
     */
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * Get the end date of the discount scheme.
     *
     * @return The end date of the discount scheme.
     */
    public Date getToDate() {
        return toDate;
    }

    /**
     * Set the end date of the discount scheme.
     *
     * @param toDate The end date of the discount scheme.
     */
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    /**
     * Get the list of medicines included in the discount scheme.
     *
     * @return List of medicines included in the discount scheme.
     */
    public List<MedicinesEO> getMedicines() {
        return medicines;
    }

    /**
     * Set the list of medicines included in the discount scheme.
     *
     * @param medicines List of medicines included in the discount scheme.
     */
    public void setMedicines(List<MedicinesEO> medicines) {
        this.medicines = medicines;
    }

    /**
     * Generate a string representation of the DiscountMedicineEO object.
     *
     * @return A string representation of the DiscountMedicineEO object.
     */
    @Override
    public String toString() {
        return "DiscountMedicineEO [schemeName=" + schemeName + ", schemeType=" + schemeType + ", schemeValue="
                + schemeValue + ", fromDate=" + fromDate + ", toDate=" + toDate + ", medicines=" + medicines + "]";
    }
}
