package hanu.edu.domain.order.service;

import hanu.edu.domain.order.model.Order;
import hanu.edu.domain.order.model.OrderStatus;
import hanu.edu.domain.order.repository.OrderRepository;
import hanu.edu.domain.security.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStatusOrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void updateStatusOrder(long id, String fromStatus, String toStatus) {
        if(fromStatus.equalsIgnoreCase(String.valueOf(OrderStatus.SHIPPING)) &&
        toStatus.equalsIgnoreCase(String.valueOf(OrderStatus.CUSTOMER_REQUEST_CANCEL))) {
            throw new BaseException("400", "Not allow to cancel while shipping");
        }
        Order order = orderRepository.getById(id);
        order.setOrderStatus(OrderStatus.of(toStatus));
        orderRepository.save(order);
    }
}
