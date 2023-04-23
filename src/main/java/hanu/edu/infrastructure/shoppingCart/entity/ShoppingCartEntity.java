package hanu.edu.infrastructure.shoppingCart.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hanu.edu.domain.shoppingCart.model.Item;
import hanu.edu.domain.shoppingCart.model.ShoppingCart;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "shopping_cart")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingCartEntity {
    @Id
    private long customerId;

    @Column(name = "items", columnDefinition = "TEXT")
    private String items;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "customerId")
    private CustomerEntity customerEntity;

    public static ShoppingCartEntity toEntity(ShoppingCart shoppingCart) {
        try {
            return ShoppingCartEntity.builder()
                    .customerId(shoppingCart.getCustomerId())
                    .items(shoppingCart.getItems() == null ? null :
                            new ObjectMapper().writeValueAsString(shoppingCart.getItems()))
                    .build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public ShoppingCart toShoppingCart() {
        try {
            if (items == null || items.length() == 0) {
                return new ShoppingCart(customerId, null);
            } else {
                return new ShoppingCart(customerId, new ObjectMapper().readValue(items, new TypeReference<List<Item>>() {
                }));
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
