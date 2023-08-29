package training.iqgateway.pharma;

import java.util.List;

/**
 * Service interface for managing order reports.
 */
public interface OrderReportsService {

    /**
     * Retrieve a list of all orders.
     *
     * @return A list of OrderReportsEO representing all orders.
     */
    List<OrderReportsEO> findAllOrders();

    /**
     * Place a new order.
     *
     * @param order The OrderReportsEO object representing the new order.
     * @return The newly placed order.
     */
    OrderReportsEO placeOrder(OrderReportsEO order);
}
