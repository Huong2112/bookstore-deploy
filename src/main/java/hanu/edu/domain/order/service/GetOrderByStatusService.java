package hanu.edu.domain.order.service;

import hanu.edu.domain.order.model.Order;
import hanu.edu.domain.order.model.OrderStatus;
import hanu.edu.domain.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetOrderByStatusService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrderByStatus(String status) {
        return orderRepository.getByOrderStatus(OrderStatus.of(status));
    }
}
