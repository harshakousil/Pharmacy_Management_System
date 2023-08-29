package training.captone.medicines;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository interface for managing medicine documents in the database.
 */
@Repository
public interface MedicineRepository extends MongoRepository<MedicinesEO, Integer> {

    /**
     * Retrieve all medicines from the database.
     *
     * @return A list of all medicines.
     */
    @Query("{}")
    List<MedicinesEO> findAllMedicines();

    /**
     * Updates or adds the medicine document to the database.
     *
     * @param medicine The medicine to save or update.
     * @return The saved or updated medicine.
     */
    @SuppressWarnings("unchecked")
    @Transactional
    MedicinesEO save(MedicinesEO medicine);

    /**
     * Delete a medicine document from the database by its ID.
     *
     * @param medicineId The ID of the medicine to delete.
     */
    @Transactional
    @Query("{'id': ?0}")
    void deleteMedicineById(String medicineId);
}
