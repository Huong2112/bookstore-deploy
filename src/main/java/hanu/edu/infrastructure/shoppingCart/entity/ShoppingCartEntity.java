package hanu.edu.infrastructure.shoppingCart.entity;

import hanu.edu.domain.shoppingCart.model.ShoppingCart;
import hanu.edu.infrastructure.Item.entity.ItemEntity;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "shopping_cart")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingCartEntity {
    @Id
    private long customerId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "shopping_cart_item",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<ItemEntity> itemEntities;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "customerId")
    private CustomerEntity customerEntity;

    public static ShoppingCartEntity toEntity(ShoppingCart shoppingCart) {
        return ShoppingCartEntity.builder()
                .customerId(shoppingCart.getCustomerId())
                .itemEntities(shoppingCart.getItems() == null ? null :
                shoppingCart.getItems().stream().map(ItemEntity::toEntity).collect(Collectors.toList()))
                .build();
    }

    public ShoppingCart toShoppingCart() {
        return new ShoppingCart(customerId, itemEntities.stream().map(ItemEntity::toItem).collect(Collectors.toList()));
    }
}
