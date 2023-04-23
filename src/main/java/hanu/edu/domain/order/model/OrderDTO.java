package hanu.edu.domain.order.model;

import hanu.edu.domain.shoppingCart.model.Item;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class OrderDTO {
    @NotEmpty
    private List<Item> items;
    private long voucherId;
    private String paymentMethod;
    private String messageOfCustomer;
    private String addressToReceive;
    private String customerName;
    private String phone;
}
