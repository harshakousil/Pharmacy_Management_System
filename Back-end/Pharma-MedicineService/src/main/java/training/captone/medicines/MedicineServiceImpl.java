package training.captone.medicines;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the MedicineService interface.
 */
@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    MedicineRepository medRepoRef;

    @Autowired
    DiscountMedicineRepository DismedRepoRef;

    /**
     * Retrieve all medicines from the database.
     *
     * @return A list of all medicines.
     */
    @Override
    public List<MedicinesEO> findAllMedicines() {

        List<MedicinesEO> medicinesList = medRepoRef.findAll();

        return medicinesList;
    }

    /**
     * Add a new medicine to the database.
     *
     * @param medicine The medicine to be added.
     * @return The added medicine.
     */
    @Override
    public MedicinesEO addMedicines(MedicinesEO medicine) {

        MedicinesEO medicineData = medRepoRef.save(medicine);
        return medicineData;
    }

    /**
     * Update an existing medicine in the database.
     *
     * @param medicine The medicine to be updated.
     * @return The updated medicine.
     */
    @Override
    public MedicinesEO updateMedicines(MedicinesEO medicine) {

        MedicinesEO updatedMedicineData = medRepoRef.save(medicine);
        return updatedMedicineData;
    }

    /**
     * Delete a medicine by its ID.
     *
     * @param medicineId The ID of the medicine to delete.
     * @return A status message indicating the result of the deletion.
     */
    @Override
    public String DeleteMedicines(Integer medicineId) {

        try {
            medRepoRef.deleteById(medicineId);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Unable to Delete";
        }

    }

    /**
     * Find a medicine by its ID.
     *
     * @param medicineId The ID of the medicine to find.
     * @return The found medicine, or null if not found.
     */
    @Override
    public MedicinesEO findMedicine(Integer medicineId) {

        Integer objId = medicineId;

        Optional<MedicinesEO> alreadythere = medRepoRef.findById(objId);

        if (alreadythere.isPresent()) {

            MedicinesEO ExistingmedicineData = alreadythere.get();

            return ExistingmedicineData;
        }
        return null;
    }

    /**
     * Delete a discounted medicine by its ID.
     *
     * @param medicineId The ID of the discounted medicine to delete.
     * @return A status message indicating the result of the deletion.
     */
    @Override
    public String DeleteDiscountedMedicines(Integer medicineId) {

        String Response = DismedRepoRef.deleteMedicineById(medicineId);
        if (!Response.isEmpty()) {
            return "Success";
        } else {
            return null;
        }

    }
}
