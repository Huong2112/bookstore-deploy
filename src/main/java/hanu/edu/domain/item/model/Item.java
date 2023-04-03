package hanu.edu.domain.item.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Item {
    private long itemId;
    private long productId;
    @Setter
    private long quantity;

    public Item(long productId, long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
