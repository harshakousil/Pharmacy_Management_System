package training.capstone.pharma;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The HomeController class handles HTTP requests related to patients and orders.
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {

    @Autowired
    private PatientService patientServiceRef;

    /**
     * Registers a new patient and adds them to the system.
     *
     * @param patient The patient information to be added.
     * @return The newly added patient's details.
     * @throws IllegalArgumentException If the user with the given email already exists.
     */
    @PostMapping("/addPatient")
    public PatientEO addNewPatient(@RequestBody PatientEO patient) {
        System.out.println(patient.getEmail());

        Boolean alreadyExists = patientServiceRef.IsUser(patient.getEmail());

        PatientEO NewPatientDet = patientServiceRef.addPatient(patient);

        if (alreadyExists) {
            throw new IllegalArgumentException("User already exists");
        } else {
            String email = patient.getEmail();
            String password = patient.getPassword();
            String rolename = "Patient";
            UserEO user = new UserEO(email, password, rolename);
            UserEO newUserDetails = patientServiceRef.addUser(user);
        }
        return NewPatientDet;
    }

    /**
     * Adds a new order to a patient's record.
     *
     * @param patientDet The patient's email and the order to be added.
     * @return A status message indicating success or failure.
     */
    @PostMapping("/addOrder")
    public String addNewOrder(@RequestBody PatientEO patientDet) {
        PatientEO userDet = patientServiceRef.findbyemail(patientDet.getEmail());
        System.out.println(userDet);

        List<OrderEO> orders = patientDet.getOrders();

        int orderId = patientServiceRef.getLastOrderid(patientDet.getEmail());
        if (orders.size() == 1) {
            OrderEO order = orders.get(0);
            order.setOrderId(orderId);
            userDet.getOrders().add(order);
        } else {
            // Handle multiple orders
        }
        if (patientServiceRef.addPatient(userDet) != null) {
            return "success";
        } else {
            return "failure";
        }
    }

    /**
     * Retrieves a patient's details along with their orders by patient ID.
     *
     * @param patientId The ID of the patient.
     * @return The patient's details along with their orders.
     */
    @GetMapping("/PatientOrders/{PatientId}")
    public PatientEO findPatientWithOrdersById(@PathVariable("PatientId") String patientId) {
        PatientEO PatientOrderDet = patientServiceRef.findPatientWithOrdersById(patientId);
        return PatientOrderDet;
    }

    /**
     * Retrieves order details by order ID.
     *
     * @param orderId The ID of the order.
     * @return The order details.
     */
    @PostMapping("/OrderStatus/{OrderId}")
    public OrderEO findOrderById(@PathVariable("OrderId") int orderId) {
        OrderEO OrderDetails = patientServiceRef.findOrderById(orderId);
        return OrderDetails;
    }

    /**
     * Updates the status of an order for a patient.
     *
     * @param data The email, order ID, and new status to be updated.
     */
    @PostMapping("/updateOrderStatus")
    public void updateOrderStatusOfPatient(@RequestBody StatusEO data) {
        String patientId = data.getEmail();
        int orderId = data.getOrderId();
        String newStatus = data.getNewStatus();
        patientServiceRef.updateOrderStatus(patientId, orderId, newStatus);
    }

    /**
     * Retrieves details of all patients and their orders.
     *
     * @return A list of patient details along with their orders.
     */
    @GetMapping("/findAllPatientOrders")
    public List<PatientEO> findAllOrdersOfPatients() {
        List<PatientEO> PatientDetails = patientServiceRef.findAllPatients();
        return PatientDetails;
    }
}
