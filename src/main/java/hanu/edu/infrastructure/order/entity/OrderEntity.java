package hanu.edu.infrastructure.order.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hanu.edu.domain.order.model.Order;
import hanu.edu.domain.order.model.OrderStatus;
import hanu.edu.domain.order.model.PaymentMethod;
import hanu.edu.domain.shoppingCart.model.Item;
import hanu.edu.infrastructure.voucher.entity.VoucherEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "items_order")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String items;
    private long customerId;
    private long voucherId;
    private Date checkoutDate;
    private String orderStatus;
    private String paymentMethod;
    private String messageOfCustomer;
    private String addressToReceive;
    @Column(columnDefinition = "TEXT")
    private String customerInfo;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "voucherId")
    private VoucherEntity voucher;

    public static OrderEntity toEntity(Order order) {
        try {
            return OrderEntity.builder()
                    .id(order.getId())
                    .items(order.getItems() == null ? null :
                            new ObjectMapper().writeValueAsString(order.getItems()))
                    .customerId(order.getCustomerId())
                    .voucherId(order.getVoucherId())
                    .checkoutDate(order.getCheckoutDate())
                    .orderStatus(String.valueOf(order.getOrderStatus()))
                    .paymentMethod(String.valueOf(order.getPaymentMethod()))
                    .messageOfCustomer(order.getMessageOfCustomer())
                    .addressToReceive(order.getAddressToReceive())
                    .customerInfo(order.getCustomerInfo()).build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Order toOrder() {
        try {
            return new Order(id, new ObjectMapper().readValue(items, new TypeReference<List<Item>>() {
            })
                    , customerId, voucherId, checkoutDate,
                    OrderStatus.of(orderStatus), PaymentMethod.of(paymentMethod)
                    , messageOfCustomer, addressToReceive, customerInfo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
