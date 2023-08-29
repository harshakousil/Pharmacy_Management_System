package training.captone.medicines;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository interface for DiscountMedicineEO entities, providing CRUD operations.
 */
public interface DiscountMedicineRepository extends MongoRepository<DiscountMedicineEO, String> {

    /**
     * Find and retrieve all discounted medicines.
     *
     * @return A list of DiscountMedicineEO representing all discounted medicines.
     */
    @Query("{}")
    List<DiscountMedicineEO> findAllDiscountedData();

    /**
     * Delete a medicine by its unique ID.
     *
     * @param medicineId The unique ID of the medicine to delete.
     * @return A string indicating the result of the deletion operation.
     */
    @Transactional
    @Query("{'id': ?0}")
    String deleteMedicineById(Integer medicineId);
}
