package hanu.edu.domain.item.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Item {
    private long itemId;
    @NotNull
    private long productId;
    @Min(1)
    @Setter
    private long quantity;
}
