package training.iqgateway.pharma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the OrderReportsService interface for managing order reports.
 */
@Service
public class OrderReportsServiceImpl implements OrderReportsService {

    @Autowired
    OrderReportsRepositroy orderRepoRef;

    /**
     * Retrieve a list of all orders.
     *
     * @return A list of OrderReportsEO representing all orders.
     */
    @Override
    public List<OrderReportsEO> findAllOrders() {
        List<OrderReportsEO> allOrders = orderRepoRef.findAll();
        return allOrders;
    }

    /**
     * Place a new order.
     *
     * @param order The OrderReportsEO object representing the new order.
     * @return The newly placed order.
     */
    @Override
    public OrderReportsEO placeOrder(OrderReportsEO order) {
        OrderReportsEO newOrder = orderRepoRef.save(order);
        return newOrder;
    }

}
