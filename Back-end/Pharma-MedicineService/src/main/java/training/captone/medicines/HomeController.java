package training.captone.medicines;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling medicine-related operations.
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {

    @Autowired
    private MedicineService medservice;

    @Autowired
    private DiscountMedicineRepository DiscountRepoRef;

    /**
     * Add a new discount scheme and apply it to relevant medicines.
     *
     * @param scheme The discount scheme to add.
     * @return A string indicating the success of the operation.
     */
    @PostMapping("/addscheme")
    private String addNewScheme(@RequestBody DiscountMedicineEO scheme) {
        List<MedicinesEO> AllMedicines = medservice.findAllMedicines();
        List<MedicinesEO> discountedMedicines = new ArrayList<>();

        for (Iterator iterator = AllMedicines.iterator(); iterator.hasNext();) {
            MedicinesEO medicinesEO = (MedicinesEO) iterator.next();

            Integer medicineId = medicinesEO.getMedicineId();
            String medicineName = medicinesEO.getMedicineName();
            String medicineDescription = medicinesEO.getMedicineDescription();
            String manufacturerName = medicinesEO.getManufacturerName();
            String stockQuantity = medicinesEO.getStockQuantity();
            String unitPrice = medicinesEO.getUnitPrice();

            if (scheme.getSchemeType().equalsIgnoreCase("Flat")) {
                if (scheme.getSchemeValue().equalsIgnoreCase("Medicines Quantity >75000")) {
                    if (Integer.parseInt(stockQuantity) >= 75000 && Integer.parseInt(stockQuantity) <= 10000) {
                        unitPrice = String.valueOf(Integer.parseInt(unitPrice) * 0.60);
                    }
                } else if (scheme.getSchemeValue().equalsIgnoreCase("Medicines Quantity >100000")) {
                    if (Integer.parseInt(stockQuantity) >= 100000 && Integer.parseInt(stockQuantity) <= 10000) {
                        unitPrice = String.valueOf(Integer.parseInt(unitPrice) * 0.60);
                    }
                }
            } else if (scheme.getSchemeType().equalsIgnoreCase("%Based")) {
                int schemeValue = Integer.parseInt(scheme.getSchemeValue());
                double reductionAmount = Double.parseDouble(unitPrice) * (schemeValue / 100.0);
                unitPrice = String.valueOf(Double.parseDouble(unitPrice) - reductionAmount);
            }

            Date expiryDate = medicinesEO.getExpiryDate();
            byte[] image = medicinesEO.getImage();
            discountedMedicines.add(new MedicinesEO(medicineId, medicineName, medicineDescription, manufacturerName,
                    stockQuantity, unitPrice, expiryDate, image));
        }
        scheme.setMedicines(discountedMedicines);
        DiscountRepoRef.save(scheme);
        return "Success";
    }

    /**
     * Add a new medicine.
     *
     * @param Medicine The medicine to add.
     * @return The added medicine.
     */
    @PostMapping("/addMedicine")
    private MedicinesEO addMedicines(@RequestBody MedicinesEO Medicine) {
        MedicinesEO AddedMedicine = medservice.addMedicines(Medicine);
        return AddedMedicine;
    }

    /**
     * Find a medicine by its ID.
     *
     * @param medicineId The ID of the medicine to find.
     * @return The found medicine.
     */
    @GetMapping("/findmedicine/{medicineId}")
    private MedicinesEO findMedicine(@PathVariable("medicineId") Integer medicineId) {
        MedicinesEO existingMedicine = medservice.findMedicine(medicineId);
        return existingMedicine;
    }

    /**
     * Get a list of all medicines.
     *
     * @return A list of all medicines.
     */
    @GetMapping("/GetAllMedicines")
    private List<MedicinesEO> AllMedicines() {
        List<MedicinesEO> medicinesList = medservice.findAllMedicines();
        return medicinesList;
    }

    /**
     * Get a list of all discounted medicines.
     *
     * @return A list of all discounted medicines.
     */
    @GetMapping("/GetAllDiscountedMedicines")
    private List<DiscountMedicineEO> AllDiscountedMedicines() {
        List<DiscountMedicineEO> DiscountmedicinesList = DiscountRepoRef.findAllDiscountedData();
        return DiscountmedicinesList;
    }

    /**
     * Update an existing medicine.
     *
     * @param Medicine The medicine to update.
     * @return The updated medicine.
     */
    @PostMapping("/updateMedicine")
    private MedicinesEO udpateMedicines(@RequestBody MedicinesEO Medicine) {
        MedicinesEO updateMedicine = medservice.addMedicines(Medicine);
        return updateMedicine;
    }

    /**
     * Delete a medicine by its ID.
     *
     * @param medicineId The ID of the medicine to delete.
     * @return A string indicating the result of the deletion operation.
     */
    @GetMapping(value = "/deleteMedicine/{medicineId}")
    private String deleteMedicine(@PathVariable("medicineId") Integer medicineId) {
        String response = medservice.DeleteMedicines(medicineId);
        String DisResponse = DiscountRepoRef.deleteMedicineById(medicineId);
        if (response.isEmpty() || DisResponse.isEmpty()) {
            return null;
        }
        return response;
    }
}
