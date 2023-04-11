package hanu.edu.domain.order.model;

import hanu.edu.domain.shoppingCart.model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@Getter
public class Order {
    private long id;
    private List<Item> items;
    private long customerId;
    private long voucherId;
    private Date checkoutDate;
    @Setter
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;
    private String messageOfCustomer;

    public Order(List<Item> items, long customerId, long voucherId, Date checkoutDate,
                 OrderStatus orderStatus, PaymentMethod paymentMethod, String messageOfCustomer) {
        this.items = items;
        this.customerId = customerId;
        this.voucherId = voucherId;
        this.checkoutDate = checkoutDate;
        this.orderStatus = orderStatus;
        this.paymentMethod = paymentMethod;
        this.messageOfCustomer = messageOfCustomer;
    }
}
