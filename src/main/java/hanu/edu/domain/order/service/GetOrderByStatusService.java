package hanu.edu.domain.order.service;

import hanu.edu.domain.order.model.Order;
import hanu.edu.domain.order.model.OrderStatus;
import hanu.edu.domain.order.model.PaymentMethod;
import hanu.edu.domain.order.repository.OrderRepository;
import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.product.repository.ProductRepository;
import hanu.edu.domain.security.exception.BaseException;
import hanu.edu.domain.shoppingCart.model.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetOrderByStatusService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<OutputOrder> getOrderByStatus(String status) {
        List<Order> orders = orderRepository.getByOrderStatus(OrderStatus.of(status));
        if(orders == null) {
            throw new BaseException("404", "No order found");
        }
        List<OutputOrder> outputOrderList = new ArrayList<>();
        double total = 0;
        for(Order order: orders) {
            List<OutputItemDetail> itemDetailList = new ArrayList<>();
            List<Item> items = order.getItems();
            for(Item item: items) {
                Product product = productRepository.getById(item.getProductId());
                if(product != null) {
                    OutputItemDetail outputItemDetail = new OutputItemDetail(product.getId(), product.getName(), product.getPrice(),
                            product.getImages(), item.getQuantity(), product.getCategory());
                    total += product.getPrice() * item.getQuantity();
                    itemDetailList.add(outputItemDetail);
                }
            }
            OutputOrder outputOrder = new OutputOrder(order.getId(), itemDetailList, order.getCustomerId(),
                    order.getVoucherId(), order.getCheckoutDate(), order.getOrderStatus().toString().toLowerCase(),
                    order.getPaymentMethod().toString().toLowerCase(),
                    order.getMessageOfCustomer(), order.getAddressToReceive(), total);
            outputOrderList.add(outputOrder);
        }
        return outputOrderList;
    }

    @AllArgsConstructor
    @Getter
    public class OutputOrder {
        private long id;
        private List<OutputItemDetail> items;
        private long customerId;
        private long voucherId;
        private Date checkoutDate;
        private String orderStatus;
        private String paymentMethod;
        private String messageOfCustomer;
        private String addressToReceive;
        private double total;
    }

    @AllArgsConstructor
    @Getter
    public class OutputItemDetail {
        private long productId;
        private String productName;
        private double price;
        private List<String> images;
        private long quantity;
        private String category;
    }
}
