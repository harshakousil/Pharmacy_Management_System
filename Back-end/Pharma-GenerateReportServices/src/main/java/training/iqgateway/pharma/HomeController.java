package training.iqgateway.pharma;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
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
 * Controller class responsible for managing order-related operations.
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {

    @Autowired
    OrderReportsService OrderServiceRef;

    /**
     * Update the status of orders based on their order date.
     */
    @PostMapping("/")
    public void SetStatusofOrder() {

        Date currentDate = new Date();
        List<OrderReportsEO> AllOrders = OrderServiceRef.findAllOrders();

        if (!AllOrders.isEmpty()) {
            for (Iterator iterator = AllOrders.iterator(); iterator.hasNext();) {
                OrderReportsEO orderReportsEO = (OrderReportsEO) iterator.next();

                Date orderDate = orderReportsEO.getOrderDate();

                long timeDifference = orderDate.getTime() - currentDate.getTime();
                long oneDayMillis = 24 * 60 * 60 * 1000; // One day in milliseconds
                String status = orderReportsEO.getStatus();
                if (timeDifference == 0) {
                    status = "Processing";
                } else if (timeDifference <= oneDayMillis) {
                    status = "Shipped";
                } else if (timeDifference <= 2 * oneDayMillis) {
                    status = "Delivered";
                } else {
                    status = "Unknown";
                }
                orderReportsEO.setStatus(status);
                OrderServiceRef.placeOrder(orderReportsEO);

            }
        } else {
            System.out.println("Error");
        }
    }

    /**
     * Place a new order with the given quantity.
     *
     * @param Quant The quantity of the order.
     * @param Order The OrderReportsEO object representing the new order.
     * @return The details of the newly placed order.
     */
    @PostMapping(value = { "/placenewOrder/{quantity}" })
    public OrderReportsEO placeNewOrder(@PathVariable("quantity") String Quant, @RequestBody OrderReportsEO Order) {
        Order.setOrderDate(new Date());
        Order.setQuantity(Quant);
        System.out.println(Order.getQuantity());
        OrderReportsEO OrderDetails = OrderServiceRef.placeOrder(Order);
        return OrderDetails;
    }

    /**
     * Get a list of all orders.
     *
     * @return A list of OrderReportsEO representing all orders.
     */
    @GetMapping(value = "/findAllOrders/")
    public List<OrderReportsEO> getAllOrders() {
        List<OrderReportsEO> getOrders = OrderServiceRef.findAllOrders();
        return getOrders;
    }
}
