package training.iqgateway.pharma;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Repository interface for managing order reports in the database.
 */
public interface OrderReportsRepositroy extends MongoRepository<OrderReportsEO, String> {

    /**
     * Find all orders in the database.
     *
     * @return A list of OrderReportsEO representing all orders.
     */
    @Query("{}")
    List<OrderReportsEO> findAllOrders();

    /**
     * Find orders by their status.
     *
     * @param status The status of orders to retrieve.
     * @return A list of OrderReportsEO representing orders with the specified status.
     */
    @Query("{'status' : ?0}")
    List<OrderReportsEO> findOrdersByStatus(String status);

    /**
     * Save a new order report.
     *
     * @param order The OrderReportsEO object to be saved.
     * @return The saved OrderReportsEO object.
     */
    @Override
    OrderReportsEO save(OrderReportsEO order);
}
