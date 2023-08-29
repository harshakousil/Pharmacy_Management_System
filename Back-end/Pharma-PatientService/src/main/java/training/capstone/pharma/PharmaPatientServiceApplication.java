package training.capstone.pharma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The PharmaPatientServiceApplication class is the main entry point for the Pharma Patient Service application.
 */
@SpringBootApplication
public class PharmaPatientServiceApplication {

    @Autowired
    PatientService patientServiceRef;

    /**
     * The main method to start the Pharma Patient Service application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(PharmaPatientServiceApplication.class, args);
    }
}
