package training.capstone.pharma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class for the Authentication Service application.
 */
@SpringBootApplication
public class AuthenticationserviceApplication implements CommandLineRunner {

    @Autowired	
    UserService userserviceRef;
    
    /**
     * The entry point of the application.
     * 
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(AuthenticationserviceApplication.class, args);
    }

    /**
     * This method is called after the application context is loaded
     * and the command line arguments have been processed. You can
     * use this method to perform any initialization or tasks that
     * need to be executed when the application starts.
     * 
     * @param args The command line arguments.
     * @throws Exception If an exception occurs during execution.
     */
    @Override
    public void run(String... args) throws Exception {
        // Add any initialization or startup code here
    }
}
