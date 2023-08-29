package training.captone.medicines;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing medicines.
 */
public interface MedicineService {

    /**
     * Retrieve all medicines from the database.
     *
     * @return A list of all medicines.
     */
    public List<MedicinesEO> findAllMedicines();

    /**
     * Add a new medicine to the database.
     *
     * @param medicine The medicine to be added.
     * @return The added medicine.
     */
    public MedicinesEO addMedicines(MedicinesEO medicine);

    /**
     * Update an existing medicine in the database.
     *
     * @param medicine The medicine to be updated.
     * @return The updated medicine.
     */
    public MedicinesEO updateMedicines(MedicinesEO medicine);

    /**
     * Find a medicine by its ID.
     *
     * @param medicineId The ID of the medicine to find.
     * @return The found medicine, or null if not found.
     */
    public MedicinesEO findMedicine(Integer medicineId);

    /**
     * Delete a medicine by its ID.
     *
     * @param medicineId The ID of the medicine to delete.
     * @return A status message indicating the result of the deletion.
     */
    public String DeleteMedicines(Integer medicineId);

    /**
     * Delete a discounted medicine by its ID.
     *
     * @param medicineId The ID of the discounted medicine to delete.
     * @return A status message indicating the result of the deletion.
     */
    public String DeleteDiscountedMedicines(Integer medicineId);
}
