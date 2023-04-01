package hanu.edu.domain.shoppingCart.model;

import hanu.edu.domain.Item.model.Item;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ShoppingCart {
    @NotNull
    private long customerId;
    @Setter
    private List<Item> items;
}
