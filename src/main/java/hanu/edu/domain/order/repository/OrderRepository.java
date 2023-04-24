package hanu.edu.domain.order.repository;

import hanu.edu.domain.order.model.Order;
import hanu.edu.domain.order.model.OrderStatus;

import java.util.List;

public interface OrderRepository {
    void save(Order order);

    Order getById(long id);

    List<Order> getByOrderStatus(OrderStatus status);
}
