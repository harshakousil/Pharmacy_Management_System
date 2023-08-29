package training.captone.medicines;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main application class for the Pharma Medicine Service.
 */
@SpringBootApplication
public class PharmaMedicineServiceApplication implements CommandLineRunner {

    @Autowired
    MedicineService medicineDet;

    public static void main(String[] args) {
        SpringApplication.run(PharmaMedicineServiceApplication.class, args);
    }

    /**
     * This method is called upon application startup. You can use it to perform
     * initialization tasks.
     *
     * @param args The command line arguments passed to the application.
     * @throws Exception If an error occurs during initialization.
     */
    @Override
    public void run(String... args) throws Exception {
        // Example of adding a medicine:
        // Date expiryDate = new Date(123, 11, 31);
        // medicineDet.addMedicines(new MedicinesEO(1, "Paracetamol", "For Relief", "ABC", "1000", "1", expiryDate));
    }
}
