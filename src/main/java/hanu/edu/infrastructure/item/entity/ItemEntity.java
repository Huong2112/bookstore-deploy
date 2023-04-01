package hanu.edu.infrastructure.item.entity;

import hanu.edu.domain.item.model.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;
    private long quantity;
    private long productId;

    public static ItemEntity toEntity(Item item) {
        return ItemEntity.builder()
                .itemId(item.getItemId())
                .productId(item.getProductId())
                .quantity(item.getQuantity())
                .build();
    }

    public Item toItem() {
        return new Item(itemId, productId, quantity);
    }
}
