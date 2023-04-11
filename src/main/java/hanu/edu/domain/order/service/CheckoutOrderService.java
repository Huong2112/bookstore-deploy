package hanu.edu.domain.order.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hanu.edu.domain.order.model.Order;
import hanu.edu.domain.order.model.OrderDTO;
import hanu.edu.domain.order.model.OrderStatus;
import hanu.edu.domain.order.model.PaymentMethod;
import hanu.edu.domain.order.repository.OrderRepository;
import hanu.edu.domain.shoppingCart.model.Item;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.SimpleFormatter;

@Service
public class CheckoutOrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void checkoutOrder(@NotNull OrderDTO orderDTO, long customerId) {
        orderRepository.save(new Order(orderDTO.getItems(), customerId,
                orderDTO.getVoucherId(), new Date(System.currentTimeMillis()),
                OrderStatus.CUSTOMER_CONFIRMED,
                PaymentMethod.of(orderDTO.getPaymentMethod()),
                orderDTO.getMessageOfCustomer()));
    }
}
