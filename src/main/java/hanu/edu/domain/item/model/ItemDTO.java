package hanu.edu.domain.item.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ItemDTO {
    @NotNull
    private long productId;
    @Min(1)
    private long quantity;
}
