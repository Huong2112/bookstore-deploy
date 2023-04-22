package hanu.edu.domain.order.service;

import hanu.edu.domain.order.model.Order;
import hanu.edu.domain.order.model.OrderDTO;
import hanu.edu.domain.order.model.OrderStatus;
import hanu.edu.domain.order.model.PaymentMethod;
import hanu.edu.domain.order.repository.OrderRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class CheckoutOrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void checkoutOrder(@NotNull OrderDTO orderDTO, long customerId) {
        orderRepository.save(new Order(orderDTO.getItems(), customerId,
                orderDTO.getVoucherId(), new Date(System.currentTimeMillis()),
                OrderStatus.CUSTOMER_CONFIRMED,
                PaymentMethod.of(orderDTO.getPaymentMethod()),
                orderDTO.getMessageOfCustomer(),
                orderDTO.getAddressToReceive(),
                new StringBuilder().append(orderDTO.getCustomerName() + " ").append(orderDTO.getPhone()).toString()));
    }
}
